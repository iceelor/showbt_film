package com.showbt.crawler.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
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
import com.showbt.crawler.common.ResultSet;
import com.showbt.crawler.common.controller.BaseController;
import com.showbt.crawler.service.BtSeedService;

@Controller
public class BtSeedController extends BaseController{
	
	private @Autowired BtSeedService btSeedService;
	
	@RequestMapping(value="/search")
	public ModelAndView seedSearch(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView(getDefaultTemptalePath(request)+"searchForm");
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
		ModelAndView mv = new ModelAndView(getDefaultTemptalePath(request)+"searchResult");
		if(StringUtils.isBlank(keywords)) return mv;
		KeyWord kw = Cache.getInstance().getKeyWordCache(keyWordService).get(keywords.trim());
		Map<String, Object> res = new HashMap<String, Object>();
		List<BtSeed> btList = null;
		ResultSet<BtSeed> rs = new ResultSet<BtSeed>();
		if(kw == null){
			res = TorrentkittyCollect.get(keywords, page);
			btList = (List<BtSeed>) res.get("resultList");
			kw = new KeyWord();
			kw.setKeyword(keywords);
			kw.setAddTime(new Date());
			kw.setState(0);
			kw.setRecordNum(btList.size());
			kw.setMaxPage(Integer.parseInt(res.get("maxPage").toString()));
			kw.setCurrent(1);
			keyWordService.editSave(kw);
			Cache.getInstance().getKeyWordCache(keyWordService).put(keywords, keyWordService.getKeyWord(keywords));
			for(BtSeed bs: btList){
				if(!btSeedService.isExist(bs.getTitle())){
					btSeedService.editSave(bs);
				}
			}
		}
		rs = btSeedService.getBtSeedList(rs, keywords);
		String t = request.getParameter("t");
		mv.addObject("result", rs.getResults());
        mv.addObject("t", StringUtils.isNotBlank(t)?t:"s");
		mv.addObject("page", rs.getCurrentPage());
		mv.addObject("keywords", keywords);
		mv.addObject("maxPage", rs.getMaxPage());
		return mv;
	}
}
