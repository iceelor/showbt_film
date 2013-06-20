package com.showbt.crawler.collect;

import java.util.ArrayList;
import java.util.List;

import com.showbt.crawler.bean.Video;

public class VideoCollect {
	private final static String encode = "UTF-8";
	private final static String method = "get";
	
	/**
	 * 获取视频信息
	 * @param url
	 * @return
	 */
	public static Video getVideoInfo(String url) throws Exception{
		Video video = new Video();
		
		if(url.indexOf("v.youku.com")!=-1){
			try {
				video = YouKuCollect.getYouKuVideo(url, method, encode);//获取优酷视频
			} catch (Exception e) {
				e.printStackTrace();
				video = null;
			}
		}else if(url.indexOf("tudou.com")!=-1){
			try {
				video = TuDouCollect.getTudouVideo(url, method);//获取土豆视频
			} catch (Exception e) {
				video = null;
			}
		}else if(url.indexOf("v.ku6.com")!=-1){
			try {
				video = Ku6Collect.getKu6Video(url, method);
			} catch (Exception e) {
				video = null;
			}
		}else if(url.indexOf("6.cn")!=-1){
			try {
				video = SixCollect.get6Video(url, method);
			} catch (Exception e) {
				video = null;
			}
		}else if(url.indexOf("56.com")!=-1){
			try {
				video = FiveSixCollect.get56Video(url,method);
			} catch (Exception e) {
				video = null;
			}
		}
		
		return video;
	}
	
	/**
	 * 获取视频列表
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static List<Video> getVideoList(String url) throws Exception{
		List<String> contentUrlList = new ArrayList<String>();
		List<Video> res = null;
		if(url.indexOf("youku.com")!=-1){
			contentUrlList = YouKuCollect.getYouKuVideoList(url, method,encode);
			res = YouKuCollect.getYouKuVideoContent(contentUrlList);
		}else if(url.indexOf("tudou.com")!=-1){
			
		}else if(url.indexOf("v.ku6.com")!=-1){
			
		}else if(url.indexOf("6.cn")!=-1){
			
		}else if(url.indexOf("56.com")!=-1){
			
		}
		return res;
	}
	
}
