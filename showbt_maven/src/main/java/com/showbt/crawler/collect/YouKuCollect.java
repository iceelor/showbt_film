package com.showbt.crawler.collect;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.showbt.crawler.bean.Video;
import com.showbt.util.HttpService;

public class YouKuCollect {
	public static Video getYouKuVideo(String url,String method, String encode) throws Exception{
//System.out.println(url);
		int startIndex = url.indexOf("/id_")+4;
		int endIndex = url.indexOf(".html");
		String id = url.substring(startIndex,endIndex);
		String videoUrl = "http://v.youku.com/player/getPlayList/VideoIDS/"+id;
		String data = HttpService.httpResponseToStr(videoUrl,method,encode);
		JSONObject jsonObj = JSON.parseObject(data);
		JSONArray datas = jsonObj.getJSONArray("data");
//		for(int i=0; i<datas.size(); i++){
//			JSONObject obj = datas.getJSONObject(i);
//		}
		JSONObject obj = null;
		if(datas.size()>0){
			obj = datas.getJSONObject(0);
		}
		/**
		 *获取视频缩略图 
		 */
		String pic = obj.getString("logo");
		/**
		 * 获取视频地址
		 */		
		String flash = "http://player.youku.com/player.php/partnerid/XMTk2NA==/sid/"+id+"/v.swf";
		
		/**
		 * 获取视频时间
		 */
		double t = obj.getDoubleValue("seconds");
		int tt = Integer.parseInt(new java.text.DecimalFormat("0").format(t));
		int min = tt/60;
		int seconds = tt%60;
		String time = min+":"+seconds;
		
		/**
		 * 获取标题
		 */
		String title = "";
		title = obj.getString("title");
		
		Video video = new Video();
		video.setPic(pic);
		video.setFlash(flash);
		video.setTimeLen(time);
		video.setTitle(title);
		video.setSource("优酷");
		video.setSourceUrl(url);
		return video;
	}
	
	public static List<String> getYouKuVideoList(String videoListUrl,String method, String encode){
		String data = HttpService.httpResponseToStr(videoListUrl,method,encode);
//System.out.println(data);
		Document doc = Jsoup.parseBodyFragment(data);
		Elements es = doc.select("div.collgrid6t"); 
		es = es.select("div.items ul.v");
		List<String> res = new ArrayList<String>();
//		System.out.println(es);
		for(Element e:es){
			res.add(e.select("li.v_link a").attr("href"));
//			System.out.println(e.select("li.v_thumb img").attr("src"));
//			System.out.println(e.select("li.v_link a").attr("href"));
//			System.out.println(e.select("li.v_title a").html());
		}
		return res;
	}
	
	public static List<Video> getYouKuVideoContent(List<String> urlList) throws Exception{
		List<Video> vlist = new ArrayList<Video>();
		for(String url: urlList){
			try {
				vlist.add(getYouKuVideo(url,"get","UTF-8"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vlist;
	}
}
