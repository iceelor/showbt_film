package com.showbt.crawler.collect;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.showbt.crawler.bean.Dytt8;
import com.showbt.crawler.common.bean.BaseTO;
import com.showbt.util.HttpService;

public class Dytt8Collect {
	private static final String BASEHOST = "http://www.dytt8.net";
	private static String IMGPATH = "D:\\sexpicture\\色戒美眉图"+File.separator+StringUtil.getDate();
	private static String encode = "gbk";
	
	static String method = "get";
	
	public static List<Dytt8> collect(String url){
		List<Dytt8> res = new ArrayList<Dytt8>();
		String pageContext = HttpService.httpResponseToStr(url, method, encode);
		List<String> articleURLS = getArticleURL(pageContext);
		for(String articleURL:articleURLS){
			String articleContext = HttpService.httpResponseToStr(BASEHOST+articleURL,method, encode);
			Dytt8 d = getDytt8(articleContext);
			d.setSourceUrl(BASEHOST+articleURL);
			res.add(d);
		}
		return res;
	}
	
	public static List<Dytt8> reCollect(List<Dytt8> dList){
		List<Dytt8> reslut = new ArrayList<Dytt8>();
		for(BaseTO d : dList){
			Dytt8 dytt8 = (Dytt8)d;
			String articleContext = HttpService.httpResponseToStr(dytt8.getSourceUrl(),method, encode);
			Dytt8 d1 = getDytt8(articleContext);
			dytt8.setDownUrl(d1.getDownUrl());
			reslut.add(dytt8);
		}
		return reslut;
	}
	
	/**
	 * 找出当前页面中所有帖子的地址
	 * @param pageStr  网页字符串
	 * @return
	 */
	public static List<String> getArticleURL(String pageContext){
		if(pageContext == null){
			return null;
		}
		List<String> articleURLS = new ArrayList<String>();
System.out.println("寻找帖子...........");
		try {
			Document doc = Jsoup.parseBodyFragment(pageContext);
			Elements es = doc.select("table.tbspan"); 
			es = es.select("a[class=ulink]");
			//es = es.select("div.meta a:containsOwn(全文)");
			for(Element e:es){
				articleURLS.add(e.attr("href"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return articleURLS;
	}
	
	/**
	 * 解析http://www.dytt8.net网站内容
	 * @param articleContext
	 * @return
	 */
	public  static Dytt8 getDytt8(String articleContext){
		Dytt8 dytt8 = new Dytt8();
		if(articleContext == null){
			return null;
		}
		Document doc = Jsoup.parse(articleContext);
		Elements es = doc.select("div.bd3r");
		Elements es_title = es.select("div.title_all h1 font");
		Elements es_content = es.select("div.co_content8");
		for(Element e:es_title){
			dytt8.setTitle(e.html());
		}
		List<String> imageUrl = new ArrayList<String>();
		String content = "";
		for(Element e:es_content){
			Elements ee = e.select("p");
			int i=0;
			for(Element c: ee){
				if(i==0){
					content += c.html();
					break;
				}	
			}
			imageUrl.add(e.select("img").attr("src"));
			dytt8.setDownUrl(e.select("table tr td a").attr("href"));
		}
		String imgstr = "";
		for(String img: imageUrl){
			imgstr+=img+",";
		}
		imgstr = imgstr.substring(0,imgstr.length()-1);
		dytt8.setImageUrl(imgstr);
		dytt8.setContent(content);
		return dytt8;
	}
	
	/**
	 * 获取帖子的图片地址
	 * @param articleURLS
	 * @return
	 */
	public  static List<String> getImgURLS(String articleContext){
		List<String>ImgURLS = new ArrayList<String>();
		if(articleContext == null){
			return null;
		}
System.out.println("获取图片地址-----------");
		Document doc = Jsoup.parse(articleContext);
		Elements es = doc.select("a[target=_blank] img[src]");
		 for(Iterator<Element> i=es.iterator();i.hasNext();){
				Element e = i.next();
				ImgURLS.add(e.attr("src"));
             }
		return ImgURLS;
	}
	/**
	 * 保存图片
	 * @param ImgURL
	 */
	public  static void savepic(String ImgURL){
		if(ImgURL == null){
			return ;
		}
		String[] strs = ImgURL.split("/");
		String fileName = strs[strs.length-1];
	    String savePath = IMGPATH+File.separator+fileName;
		HttpEntity entity = null;
		HttpResponse response = null;
		try {
			response = HttpService.httpRequest(ImgURL, method);
			if(response != null){
				entity = response.getEntity();
System.out.println("保存图片>>>>.>>>>>>"+fileName);
				InputStream is = entity.getContent();
				OutputStream os = new FileOutputStream(savePath);
				IOUtils.copy(is, os);
				IOUtils.closeQuietly(os);
				IOUtils.closeQuietly(is);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("图片保存失败");
			return ;
		}
	}
}
