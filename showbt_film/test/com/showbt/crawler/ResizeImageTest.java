package com.showbt.crawler;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.showbt.crawler.bean.Dytt8;
import com.showbt.crawler.service.Dytt8Service;
import com.showbt.util.ResizeImage;


public class ResizeImageTest {
	private ApplicationContext context;
	@Before
	public void before() {
		context =  new FileSystemXmlApplicationContext("WebRoot/WEB-INF/config/applicationContext.xml");
	}
	
	@Test
	public void testAdd(){
		Dytt8Service dytt8Service = (Dytt8Service) context.getBean("dytt8Service");
		List<Dytt8> dlist = dytt8Service.indexFilm();
		
		String outputFolder = "c:\\output\\";  
//		float times = 0.5f; 
		 ResizeImage r = new ResizeImage();
//		 List<BufferedImage> imageList = new ArrayList<BufferedImage>();//r.getImageList(inputFoler,new String[] {"jpg"});
		try {
			for(Dytt8 d: dlist){
				String[] iu = d.getImageUrl().split(",");
				System.out.println(iu[0]);
				BufferedImage bi = ImageIO.read(new URL(iu[0]));
//				imageList.add(bi);
				 String fName = r.writeHighQuality(r.zoomImage(bi,160,0),outputFolder,"index_thumb_"+d.getId());
				 d.setIndexThumb(fName);
				 dytt8Service.editUpdate(d);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//        for(BufferedImage i : imageList) {
//	        r.writeHighQuality(r.zoomImage(i,160,0),outputFolder);
//		}
	}
}
