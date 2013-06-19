package com.showbt.crawler.collect;

import org.jsoup.nodes.Document;

import com.showbt.crawler.bean.Video;
import com.showbt.util.HttpService;

public class TuDouCollect {
	/**
	 * 获取土豆视频
	 * @param url  视频URL
	 */
	public static Video getTudouVideo(String url, String method) throws Exception{
		Document doc = HttpService.getURLContent(url,method);
		String content = doc.html();
		int beginLocal = content.indexOf("<script>document.domain");
		int endLocal = content.indexOf("</script>");
		content = content.substring(beginLocal, endLocal);
		
		/**
		 * 获取视频地址
		 */	
		String flash = getScriptVarByName("iid_code", content);
		flash = "http://www.tudou.com/v/" + flash + "/v.swf";
		
		/**
		 *获取视频缩略图 
		 */
		String pic = getScriptVarByName("thumbnail", content);
		
		/**
		 * 获取视频时间
		 */	
		String time = getScriptVarByName("time", content);

		Video video = new Video();
		video.setPic(pic);
		video.setFlash(flash);
		video.setTimeLen(time);
		
		return video;
	}
	
	/**
	 * 获取script某个变量的值
	 * @param name  变量名称
	 * @return   返回获取的值 
	 */
	private static String getScriptVarByName(String name, String content){
		String script = content;
		
		int begin = script.indexOf(name);
		
		script = script.substring(begin+name.length()+2);
		
		int end = script.indexOf(",");
		
		script = script.substring(0,end);
		
		String result=script.replaceAll("'", "");
		result = result.trim();
		
		return result;
	}
}
