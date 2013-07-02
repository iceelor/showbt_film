package com.showbt.crawler.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.showbt.crawler.bean.BtSeed;
import com.showbt.crawler.bean.KeyWord;
import com.showbt.crawler.collect.TorrentkittyCollect;
import com.showbt.crawler.common.Cache;
import com.showbt.crawler.common.controller.BaseController;
import com.showbt.crawler.service.BtSeedService;

@Controller
public class BtSeedController extends BaseController{
	
	private @Autowired BtSeedService btSeedService;
	
	@RequestMapping(value="/search")
	public ModelAndView seedSearch(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView(getDefaultTemptalePath()+"searchForm");
		String t = request.getParameter("t");
        mv.addObject("t", StringUtils.isNotBlank(t)?t:"s");
		return mv;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/searchDo")
	public ModelAndView seedSearchDo(HttpServletRequest request, HttpServletResponse response){
		String keywords = request.getParameter("keywords");
		String page=request.getParameter("page");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
System.out.println(keywords);
		ModelAndView mv = new ModelAndView(getDefaultTemptalePath()+"searchResult");
		if(StringUtils.isBlank(keywords)) return mv;
		KeyWord kw = Cache.getInstance().getKeyWordCache(keyWordService).get(keywords.trim());
		Map<String, Object> res = null;
		List<BtSeed> btList = null;
		if(kw == null){
			res = TorrentkittyCollect.get(keywords, page);
			kw = new KeyWord();
			kw.setKeyword(keywords);
			kw.setAddTime(new Date());
			kw.setState(0);
			keyWordService.editSave(kw);
			Cache.getInstance().getKeyWordCache(keyWordService).put(keywords, keyWordService.getKeyWord(keywords));
			btList = (List<BtSeed>) res.get("resultList");
			for(BtSeed bs: btList){
				if(!btSeedService.isExist(bs.getTitle())){
					btSeedService.editSave(bs);
				}
			}
		}
		String t = request.getParameter("t");
		mv.addObject("result", res.get("resultList"));
        mv.addObject("t", StringUtils.isNotBlank(t)?t:"s");
		mv.addObject("page", res.get("page"));
		mv.addObject("keywords", keywords);
		mv.addObject("maxPage", res.get("maxPage"));
		return mv;
	}
}
