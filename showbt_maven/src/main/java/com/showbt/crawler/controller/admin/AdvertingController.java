package com.showbt.crawler.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.showbt.crawler.bean.Adverting;
import com.showbt.crawler.common.Cache;
import com.showbt.crawler.service.AdvertingService;

@Controller("adverting_Controller")
@RequestMapping(value="/admin")
public class AdvertingController {
	
	private @Autowired AdvertingService advertingService;
	
	@RequestMapping(value="/ad")
	public String ad(HttpServletRequest request, HttpServletResponse response){
		Map<String,Adverting> adList = Cache.getInstance().getAdvertingCache(advertingService);
		request.setAttribute("adList", adList);
		return "admin/adList";
	}
	
	@RequestMapping(value="/addAd")
	public String addAd(HttpServletRequest request, HttpServletResponse response){
		return "admin/addAd";
	}
	
	@RequestMapping(value="/addAdDo")
	public String addAdDo(HttpServletRequest request, HttpServletResponse response){
		String adKey = request.getParameter("adKey");
		String title = request.getParameter("title");
		String adCode = request.getParameter("adCode");
		String width = request.getParameter("width");
		String height = request.getParameter("height");
		String source = request.getParameter("source");
		Adverting ad = new Adverting();
		ad.setAdKey(adKey);
		ad.setTitle(title);
		ad.setAdCode(adCode);
		ad.setWidth(Integer.parseInt(width));
		ad.setHeight(Integer.parseInt(height));
		ad.setSource(source);
		advertingService.editSave(ad);
		Cache.setAdvertingCache(null);
		return "redirect:ad.action";
	}
	
	@RequestMapping(value="/updateAd")
	public String updateAd(HttpServletRequest request, HttpServletResponse response){
		String sid = request.getParameter("id");
		long id = 0;
		if(NumberUtils.isDigits(sid)){
			id = Long.parseLong(sid);
		}else{
			return "redirect:ad.action";
		}
		Adverting ad = advertingService.getAdverting(id);
		request.setAttribute("ad", ad);
		return "admin/updateAd";
	}
	
	@RequestMapping(value="/updateAdDo")
	public String updateAdDo(HttpServletRequest request, HttpServletResponse response){
		
		String sid = request.getParameter("id");
		long id = 0;
		if(NumberUtils.isDigits(sid)){
			id = Long.parseLong(sid);
		}else{
			return "redirect:ad.action";
		}
		Adverting ad = advertingService.getAdverting(id);
		String adKey = request.getParameter("adKey");
		String title = request.getParameter("title");
		String adCode = request.getParameter("adCode");
		String width = request.getParameter("width");
		String height = request.getParameter("height");
		String source = request.getParameter("source");

		ad.setAdKey(adKey);
		ad.setTitle(title);
		ad.setAdCode(adCode);
		ad.setWidth(Integer.parseInt(width));
		ad.setHeight(Integer.parseInt(height));
		ad.setSource(source);
		advertingService.edit(ad);
		Cache.setAdvertingCache(null);
		return "redirect:ad.action";
	}
}
