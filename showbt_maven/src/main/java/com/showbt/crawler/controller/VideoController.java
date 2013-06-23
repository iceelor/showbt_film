package com.showbt.crawler.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.showbt.crawler.bean.Category;
import com.showbt.crawler.bean.Video;
import com.showbt.crawler.common.Cache;
import com.showbt.crawler.common.ResultSet;
import com.showbt.crawler.common.controller.BaseController;
import com.showbt.crawler.service.CategoryService;
import com.showbt.crawler.service.VideoService;

@Controller
public class VideoController extends BaseController{
	private @Autowired VideoService videoService;
	private @Autowired CategoryService categoryService;
	
	@RequestMapping(value="/videoContent")
	public ModelAndView videoContent(HttpServletRequest request, HttpServletResponse response){
		String sid = request.getParameter("id");
		long id = 0;
		ModelAndView mv = new ModelAndView(getDefaultTemptalePath()+"videoContent");
		if(StringUtils.isNumeric(sid)){
			id = Long.parseLong(sid);
			mv.addObject("video",videoService.getVideo(id));
		}
		String t = request.getParameter("t");
        mv.addObject("t", StringUtils.isNotBlank(t)?t:"v");
        return mv;
	}
	
	@RequestMapping(value="/videoList")
	public ModelAndView videoList(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView(getDefaultTemptalePath()+"videolist");
		ResultSet<Video> rs = new ResultSet<Video>();
		String p = request.getParameter("page");
		Map<String, Category> clst = Cache.getInstance().getCategoryCache(categoryService);
		mv.addObject("catList", clst);
		int currentPage = 1;
		if(StringUtils.isNotBlank(p)){
			currentPage = Integer.parseInt(p);
		}
		rs.setCurrentPage(currentPage);
		rs.setPageSize(24);
		rs = videoService.getVideoList(rs);
		mv.addObject("videoList", rs.getResults());
		
		mv.addObject("page", rs.getCurrentPage());
		mv.addObject("maxPage", rs.getMaxPage());
		mv.addObject("pageSize", rs.getPageSize());
		mv.addObject("total", rs.getTotalRecord());
		int beginPageNum = rs.getCurrentPage()-5;
		int endPageNum = rs.getCurrentPage()+4;
		if(beginPageNum<=1){
			beginPageNum = 1;
		}
		if(rs.getMaxPage()<endPageNum){
			endPageNum = rs.getMaxPage();
		}
		if(endPageNum-beginPageNum != 9){
			if(beginPageNum==1){
				endPageNum += (10-(endPageNum-beginPageNum)-1);
			}else if(endPageNum==rs.getMaxPage()){
				beginPageNum -= (10-(endPageNum-beginPageNum)-1);
			}
		}
		if(beginPageNum<=1){
			beginPageNum = 1;
		}
		if(rs.getMaxPage()<endPageNum){
			endPageNum = rs.getMaxPage();
		}
//System.out.println("end:::"+endPageNum+"    begin::"+beginPageNum+"  = "+ (endPageNum-beginPageNum));
		mv.addObject("beginPageNum", beginPageNum);
		mv.addObject("endPageNum", endPageNum);
		String t = request.getParameter("t");
        mv.addObject("t", StringUtils.isNotBlank(t)?t:"v");
        return mv;
	}
}
