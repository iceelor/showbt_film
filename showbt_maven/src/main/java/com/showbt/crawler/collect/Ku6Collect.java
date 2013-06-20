package com.showbt.crawler.collect;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.showbt.crawler.bean.Video;
import com.showbt.util.HttpService;

public class Ku6Collect {
	/**
	 * 获取酷6视频
	 * @param url  视频URL
	 */
	public static Video getKu6Video(String url, String method) throws Exception{
		Document doc = HttpService.getURLContent(url,method);
		
		/**
		 * 获取视频地址
		 */
		Element flashEt = doc.getElementById("outSideSwfCode");
		String flash = flashEt.attr("value");
		
		/**
		 * 获取视频缩略图
		 */
		Element picEt = doc.getElementById("plVideosList");
		String time = null;
		String pic = null;
		if(picEt!=null){
			Elements pics = picEt.getElementsByTag("img");
			pic = pics.get(0).attr("src");
			
			/**
			 * 获取视频时长
			 */
			Element timeEt = picEt.select("span.review>cite").first(); 
			time = timeEt.text();
		}else{
			pic = doc.getElementsByClass("s_pic").first().text();
		}
		
		Video video = new Video();
		video.setPic(pic);
		video.setFlash(flash);
		video.setTimeLen(time);
		
		return video;
	}
}
