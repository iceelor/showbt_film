package com.showbt.crawler.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.showbt.crawler.bean.BtSeed;
import com.showbt.crawler.common.controller.BaseController;
import com.showbt.util.HttpService;

@Controller
public class BtSeedController extends BaseController{
	
	@RequestMapping(value="/search")
	public ModelAndView seedSearch(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView(getDefaultTemptalePath()+"searchForm");
		String t = request.getParameter("t");
        mv.addObject("t", StringUtils.isNotBlank(t)?t:"s");
		return mv;
	}
	
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
		int pg = 1;
		String url = "http://www.torrentkitty.com/search/"+keywords;
		if(StringUtils.isNotBlank(page)){
			url += "/"+page;
			pg = Integer.parseInt(page);
		}
System.out.println(url);
		int max = 1;
		try {
//			HttpService.setEncode("ISO-8859-1");
			Document d = HttpService.getURLContent(url);
			if(d !=null){
			//分页
				Elements aes = d.select("div.pagination a");
				for(Element a : aes){
					String p = a.attr("href")+"  ";
					try{
						int temp = Integer.parseInt(p.trim());
						if(temp>max){
							max = temp;
						}
					}catch(Exception e){
						System.out.println("数字转转换出错");
					}
				}
				Element es = d.getElementById("archiveResult");
				Elements ees = es.select("tr");
				List<BtSeed> bsList = new ArrayList<BtSeed>();
				for (Element td : ees) {
					BtSeed bs = new BtSeed();
					String name = td.select("td.name").text();
					String size = td.select("td.size").text();
					String magnet = "";
					Elements  as= td.select("td.action").select("a");
					
					for(Element a : as){
						String ref = a.attr("rel");
						if(StringUtils.isNotBlank(ref)&& ref.equalsIgnoreCase("magnet")){
							magnet = a.attr("href");
							break;
						}
					}
					bs.setTitle(name);
					bs.setFileSize(size);
					bs.setMagnetUrl(magnet);
					if(StringUtils.isNotBlank(bs.getMagnetUrl()))
						bsList.add(bs);
				}
				mv.addObject("result", bsList);
			}
//			for(BtSeed bs: bsList){
//				xx += bs.getTitle()+"  "+bs.getFileSize()+"    "+bs.getMagnetUrl()+" <br/>";
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String t = request.getParameter("t");
        mv.addObject("t", StringUtils.isNotBlank(t)?t:"s");
		mv.addObject("page", pg);
		mv.addObject("keywords", keywords);
		mv.addObject("maxPage", max);
		return mv;
	}
}
