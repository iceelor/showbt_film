package com.showbt.crawler.collect;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.showbt.crawler.bean.Video;
import com.showbt.util.HttpService;

public class SixCollect {
	/**
	 * 获取6间房视频
	 * @param url  视频URL
	 */
	public static Video get6Video(String url, String method) throws Exception{
		Document doc = HttpService.getURLContent(url, method);
		
		/**
		 * 获取视频缩略图
		 */
		Element picEt = doc.getElementsByClass("summary").first();
		String pic = picEt.getElementsByTag("img").first().attr("src");
		
		/**
		 * 获取视频时长
		 */
		String time = getVideoTime(doc, url, "watchUserVideo");
		if(time==null){
			time = getVideoTime(doc, url, "watchRelVideo");
		}
		
		/**
		 * 获取视频地址
		 */
		Element flashEt = doc.getElementById("video-share-code");
		doc = Jsoup.parse(flashEt.attr("value"));  
		String flash = doc.select("embed").attr("src");
		
		Video video = new Video();
		video.setPic(pic);
		video.setFlash(flash);
		video.setTimeLen(time);
		
		return video;
	}
	
	/**
	 * 获取6间房视频时长    
	 */
	private static String getVideoTime(Document doc, String url, String id) {
		String time = null;
		
		Element timeEt = doc.getElementById(id); 
		Elements links = timeEt.select("dt > a");
		
		
		for (Element link : links) {
		  String linkHref = link.attr("href");
		  if(linkHref.equalsIgnoreCase(url)){
			  time = link.parent().getElementsByTag("em").first().text();
			  break;
		  }
		}
		return time;
	}
}
