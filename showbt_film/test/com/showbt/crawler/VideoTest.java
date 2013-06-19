package com.showbt.crawler;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.showbt.crawler.bean.Video;
import com.showbt.crawler.collect.VideoCollect;
import com.showbt.crawler.service.VideoService;
import com.showbt.util.HttpService;

public class VideoTest {
	private ApplicationContext context;

	@Before
	public void before() {
		context =  new FileSystemXmlApplicationContext("WebRoot/WEB-INF/config/applicationContext.xml");
	}
	
	@Test
	public void test(){
		VideoService videoService = (VideoService) context.getBean("videoService");
//		String url = "http://v.youku.com/v_show/id_XMjU0MjI2NzY0.html";
//		String url = "http://www.tudou.com/programs/view/pVploWOtCQM/";
//		String url = "http://v.ku6.com/special/show_4024167/9t7p64bisV2A31Hz.html";
//		String url = "http://v.ku6.com/show/BpP5LeyVwvikbT1F.html";
//		String url = "http://6.cn/watch/14757577.html";
//		String url = "http://www.56.com/u64/v_NTkzMDEzMTc.html";
		String url = "http://v.youku.com/v_show/id_XNTA1MzA4MTg0.html";
		Video video = null;
		try {
			video = VideoCollect.getVideoInfo(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("视频标题："+video.getTitle());
		System.out.println("视频缩略图："+video.getPic());
		System.out.println("视频地址："+video.getFlash());
		System.out.println("视频时长："+video.getTimeLen());
	}
	
	@Test
	public void testYouKuList(){
		VideoService videoService = (VideoService) context.getBean("videoService");
		String url = "http://fun.youku.com/xiaodian/index/_page83102_2.html";
		try {
//			HttpService.setProxyState(true);
			videoService.collectVideo(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
