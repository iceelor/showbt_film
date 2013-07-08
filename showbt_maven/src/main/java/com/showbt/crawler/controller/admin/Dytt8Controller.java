package com.showbt.crawler.controller.admin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.showbt.crawler.bean.Dytt8;
import com.showbt.crawler.common.ResultSet;
import com.showbt.crawler.common.TemplateManager;
import com.showbt.crawler.common.controller.BaseController;
import com.showbt.crawler.service.Dytt8Service;
import com.showbt.util.HttpService;
import com.showbt.util.ResizeImage;

@Controller
@RequestMapping(value="/admin")
public class Dytt8Controller extends BaseController{
	private @Autowired Dytt8Service dytt8Service;
	
	@RequestMapping(value="/createDytt8Template")
	@ResponseBody
	public String createDytt8Template(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> model = initTemplateData(request);
		List<Dytt8> dlist = dytt8Service.getDytt8All();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		for(Dytt8 d: dlist){
			String templatePath = getDefaultTemptalePath(request)+"content.ftl";
			String targetHtmlPath = "movie/"+sdf.format(d.getAddTime())+"/"+sdf.format(d.getAddTime())+d.getId()+".html";
			model.put("dytt8", d);
			
			int category = 0;
			category = d.getCategory();
			
			ResultSet<Dytt8> rs1 = new ResultSet<Dytt8>();
			rs1.setCurrentPage(1);
			rs1.setPageSize(25);
			rs1 = dytt8Service.getCategoryList(category, rs1);
			model.put("categoryList", rs1.getResults());
			
			ResultSet<Dytt8> rs = new ResultSet<Dytt8>();
			rs.setCurrentPage(1);
			rs.setPageSize(25);
			rs = dytt8Service.getFaverateList(rs);
			model.put("faverteList", rs.getResults());
			String t = request.getParameter("t");
			model.put("t", StringUtils.isNotBlank(t)?t:"m");
	        
			String result = TemplateManager.getInstance().createHTML(model, templatePath,targetHtmlPath, request);
			d.setHtmlUrl(result);
			dytt8Service.editUpdate(d);
		}
		return "finshed";
	}
	
	@RequestMapping(value="/collectDytt8")
	public String collectDytt8(HttpServletRequest request, HttpServletResponse response){
		return "admin/dytt8/collectDytt8";
	}
	
	@RequestMapping(value="/collectDytt8Do")
	public String collectDytt8Do(HttpServletRequest request, HttpServletResponse response){
		String BASEHOST = "http://www.dytt8.net";
		String host = BASEHOST ;
		int STARTPAGE = 1;
		int PAGECOUNT = 100;
		String stp = request.getParameter("begin");
		String enp = request.getParameter("end");
		String proxy = request.getParameter("proxy");
		if(StringUtils.isNumeric(stp)){
			STARTPAGE = Integer.parseInt(stp);
		}
		if(StringUtils.isNumeric(enp)){
			PAGECOUNT = Integer.parseInt(enp);
		}
		if(StringUtils.isNotBlank(proxy) && proxy.trim().equals("1")){
			HttpService.setProxyState(true);
		}
		List<String> result = new ArrayList<String>();
		for(int i=STARTPAGE;i<PAGECOUNT;i++){
			if(i == 1){
				host = BASEHOST+"/html/gndy/dyzz/index.html";
			}else{
				host = BASEHOST+"/html/gndy/dyzz/list_23_"+i+".html";
			}
System.out.println("进入第"+i+"页"+host);
			result.addAll(dytt8Service.collectDytt8(host));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("result", result);
		return "admin/dytt8/collectResult";
	}
	
	/**
	 * 生成缩略图
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/createThumb")
	@ResponseBody
	public String createThumb(HttpServletRequest request, HttpServletResponse response){
		List<Dytt8> dlist = dytt8Service.createThumb();
		ResizeImage r = new ResizeImage();
		String path = request.getSession().getServletContext().getRealPath("/thumb/");
		File f = new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		String proxy = request.getParameter("proxy");
		if(StringUtils.isNotBlank(proxy)){
			Properties prop = System.getProperties();
			prop.put("http.proxyHost","202.84.17.41");
			prop.put("http.proxyPort","8080");
		}
//System.out.println(path);
		try {
			for(Dytt8 d: dlist){
				String[] iu = d.getImageUrl().split(",");
//System.out.println(iu[0]);
				BufferedImage bi = null;
				try{
					bi = ImageIO.read(new URL(iu[0]));
				}catch(IIOException ie){
					ie.printStackTrace();
				}
				if(bi != null){
					 String fName = r.writeHighQuality(r.zoomImage(bi,160,0),path,"index_thumb_"+d.getId());
					 d.setIndexThumb("thumb/"+fName);
					 dytt8Service.editUpdate(d);
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "finished";
	}
	
	@RequestMapping(value="/tab/tab")
	public String tab(HttpServletRequest request, HttpServletResponse response){
		String page = request.getParameter("page");
		int p = 1;
		if(StringUtils.isNumeric(page)){
			p = Integer.parseInt(page);
		}
		ResultSet<Dytt8> pageModel = new ResultSet<Dytt8>();
		pageModel.setCurrentPage(p);
		pageModel = dytt8Service.getDytt8List(pageModel);
		List<?> dl = pageModel.getResults();
		request.setAttribute("page", pageModel.getCurrentPage());
		request.setAttribute("maxPage", pageModel.getMaxPage());
		request.setAttribute("pageSize", pageModel.getPageSize());
		request.setAttribute("total", pageModel.getTotalRecord());
		request.setAttribute("dList", dl);
		return "admin/tab/tab";
	}
	
	@RequestMapping(value="tab/update")
	public String updateDytt8(HttpServletRequest request, HttpServletResponse response){
		String sid = request.getParameter("id");
		try{
		long id = Long.parseLong(sid);
			Dytt8 d = dytt8Service.getDytt8(id);
			request.setAttribute("dytt8", d);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "admin/tab/update";
	}
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="tab/updateDo")
	public String updateDo(HttpServletRequest request, HttpServletResponse response){
		Dytt8 model = new Dytt8();
		String sid = request.getParameter("id");
		long id = Long.parseLong(sid);
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String downUrl = request.getParameter("downUrl");
		String imageUrl = request.getParameter("imageUrl");
		String protagonist = request.getParameter("protagonist");
		String director = request.getParameter("director");
		String content = request.getParameter("content");
		String recommend = request.getParameter("recommend");
		String sourceUrl = request.getParameter("sourceUrl");
		String showTime = request.getParameter("showTime");
		String tags = request.getParameter("tags");
		String subtitle = request.getParameter("subtitle");
		String indexThumb = request.getParameter("indexThumb");
		String slideThumb = request.getParameter("slideThumb");
		String slideImg = request.getParameter("slideImg");
		String recommendImg = request.getParameter("recommendImg");
		String district = request.getParameter("district");
		String timeLen = request.getParameter("timeLen");
		String fileSize = request.getParameter("fileSize");
		String language = request.getParameter("language");
		String caption = request.getParameter("caption");
		String videoSize = request.getParameter("videoSize");
		String fileFormat = request.getParameter("fileFormat");
		String onlineUrl = request.getParameter("onlineUrl");
		
		
		model.setId(id);
		model.setTitle(title);
		model.setDownUrl(downUrl);
		model.setImageUrl(imageUrl);
		model.setProtagonist(protagonist);
		model.setDirector(director);
		model.setContent(content);
		model.setShowTime(showTime);
		model.setCategory(StringUtils.isNumeric(category)?Integer.parseInt(category):0);
		model.setRecommend(StringUtils.isNumeric(recommend)?Integer.parseInt(recommend):0);
		model.setTags(tags);
		model.setSourceUrl(sourceUrl);
		model.setAddTime(new Date());
		model.setSubtitle(subtitle);
		model.setIndexThumb(indexThumb);
		model.setSlideThumb(slideThumb);
		model.setSlideImg(slideImg);
		model.setRecommendImg(recommendImg);
		model.setDistrict(district);
		model.setTimeLen(timeLen);
		model.setFileSize(fileSize);
		model.setLanguage(language);
		model.setCaption(caption);
		model.setVideoSize(videoSize);
		model.setFileFormat(fileFormat);
		model.setOnlineUrl(onlineUrl);
		dytt8Service.editUpdate(model);
		return "redirect:tab.action";
	}
}
