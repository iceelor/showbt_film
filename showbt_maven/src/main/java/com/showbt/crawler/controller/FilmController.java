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
import com.showbt.crawler.bean.Dytt8;
import com.showbt.crawler.common.Cache;
import com.showbt.crawler.common.ResultSet;
import com.showbt.crawler.common.controller.BaseController;
import com.showbt.crawler.service.CategoryService;
import com.showbt.crawler.service.Dytt8Service;

@Controller
public class FilmController extends BaseController{
	private @Autowired Dytt8Service dytt8Service;
	private @Autowired CategoryService categoryService;
	
	@RequestMapping(value="/content")
	public ModelAndView content(HttpServletRequest request, HttpServletResponse response){
		initation(request);
		String sid = request.getParameter("id");
		long id = 0;
		ModelAndView mv = new ModelAndView(getDefaultTemptalePath(request)+"content");
		int category = 0;
		if(StringUtils.isNumeric(sid)){
			id = Long.parseLong(sid);
			Dytt8 d = dytt8Service.getDytt8(id);
			mv.addObject("dytt8",d);
			category = d.getCategory();
		}
		ResultSet<Dytt8> rs1 = new ResultSet<Dytt8>();
		rs1.setCurrentPage(1);
		rs1.setPageSize(25);
		rs1 = dytt8Service.getCategoryList(category, rs1);
		mv.addObject("categoryList", rs1.getResults());
		
		ResultSet<Dytt8> rs = new ResultSet<Dytt8>();
		rs.setCurrentPage(1);
		rs.setPageSize(25);
		rs = dytt8Service.getFaverateList(rs);
		mv.addObject("faverteList", rs.getResults());
		String t = request.getParameter("t");
        mv.addObject("t", StringUtils.isNotBlank(t)?t:"m");
        return mv;
	}
	
	@RequestMapping(value="/filmList")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView(getDefaultTemptalePath(request)+"list");
		ResultSet<Dytt8> rs = new ResultSet<Dytt8>();
		String p = request.getParameter("page");
		String ord = request.getParameter("ord");
		int currentPage = 1;
		if(StringUtils.isNotBlank(p)){
			currentPage = Integer.parseInt(p);
		}
		rs.setCurrentPage(currentPage);
		rs.setPageSize(24);
		rs = dytt8Service.getDytt8List(rs);
		mv.addObject("filmList", rs.getResults());
		mv.addObject("page", rs.getCurrentPage());
		mv.addObject("maxPage", rs.getMaxPage());
		mv.addObject("pageSize", rs.getPageSize());
		mv.addObject("total", rs.getTotalRecord());
		mv.addObject("ord", StringUtils.isNotBlank(ord)?ord:"hot");
		Map<String, Category> clst = Cache.getInstance().getCategoryCache(categoryService);
		mv.addObject("catList", clst);
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
        mv.addObject("t", StringUtils.isNotBlank(t)?t:"m");
        return mv;
	}
	
}
