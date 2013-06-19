package com.showbt.crawler.collect;

import org.jsoup.nodes.Document;

import com.showbt.crawler.bean.Video;
import com.showbt.util.HttpService;

public class FiveSixCollect {
	/**
	 * 获取56视频
	 * @param url  视频URL
	 */
	public static Video get56Video(String url, String method) throws Exception{
		Document doc = HttpService.getURLContent(url,method);
		String content = doc.html();
		
		/**
		 * 获取视频缩略图
		 */
		int begin = content.indexOf("\"img\":\"");
		content = content.substring(begin+7, begin+200);
		int end = content.indexOf("\"};");
		String pic = content.substring(0, end).trim();
		pic = pic.replaceAll("\\\\", "");		
		
		/**
		 * 获取视频地址
		 */
		String flash = "http://player.56.com" + url.substring(url.lastIndexOf("/"), url.lastIndexOf(".html")) + ".swf";
		
		Video video = new Video();
		video.setPic(pic);
		video.setFlash(flash);
		
		return video;
	}
}
