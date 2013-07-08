package com.showbt.crawler.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.showbt.crawler.bean.Dytt8;
import com.showbt.crawler.bean.Video;
import com.showbt.crawler.common.Cache;
import com.showbt.crawler.common.controller.BaseController;
import com.showbt.crawler.service.Dytt8Service;
import com.showbt.crawler.service.VideoService;
import com.showbt.util.HttpService;

@Controller("film_index_controller")
public class IndexController extends BaseController{
	
	private @Autowired Dytt8Service dytt8Service;
	private @Autowired VideoService videoService;
	
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView(getDefaultTemptalePath(request)+"index");
		List<Dytt8> dlst = dytt8Service.indexFilm();
		List<Video> vlst = videoService.indexVideo();
		List<Video> videoRecommenList = videoService.indexRecommendVideo();
		List<Dytt8> dRecommentList = dytt8Service.indexRecommendFilm(3);
		List<Dytt8> topRecommentList = dytt8Service.indexRecommendFilm(1,8);//幻灯片
		List<Dytt8> topRightRecommentList = dytt8Service.indexRecommendFilm(2);//幻灯片边上的列表
        mv.addObject("filmList",dlst);
        mv.addObject("filmRecommenList",dRecommentList);
        mv.addObject("topRecommentList",topRecommentList);
        mv.addObject("topRightRecommentList",topRightRecommentList);
        mv.addObject("videoRecommenList",videoRecommenList);
        mv.addObject("videoList",vlst);
        mv.addObject("ad", Cache.getInstance().getAdvertingCache(advertingService));
        String t = request.getParameter("t");
        mv.addObject("t", StringUtils.isNotBlank(t)?t:"i");
        return mv;
	}
	
	@RequestMapping(value="/test")
	@ResponseBody
	public String test(HttpServletRequest request, HttpServletResponse response){
		String url = request.getRequestURL().toString();
//		String uri = request.getParameter("url");
		String uri = "http://wm.lrswl.com/page/?s=37229";
//		http://wm.lrswl.com/page/?s=37229&loc=http%3A//localhost%3A8080/showbt/test.do%3Ft%3Di&ref=http%3A//localhost%3A8080/showbt/test.do%3Ft%3Di&zhv=1871
		System.out.println(url);
		Document d = null;
		String res = "";
		try {
			HttpService.setProxyState(true);
			d = HttpService.getURLContent(uri+"&loc="+url+"&ref="+url+"&zhv=1871","get",url);
			res = d.select("a").attr("href");
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return res;
	}
}
