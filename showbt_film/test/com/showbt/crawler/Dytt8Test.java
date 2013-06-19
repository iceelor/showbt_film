package com.showbt.crawler;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.showbt.crawler.bean.Dytt8;
import com.showbt.crawler.common.ResultSet;
import com.showbt.crawler.service.Dytt8Service;

public class Dytt8Test {
	private ApplicationContext context;

	@Before
	public void before() {
		context =  new FileSystemXmlApplicationContext("WebRoot/WEB-INF/config/applicationContext.xml");
	}
	
	@Test
	public void testAdd(){
		Dytt8Service dytt8Service = (Dytt8Service) context.getBean("dytt8Service");
		String BASEHOST = "http://www.dytt8.net";
		String host = BASEHOST ;
		int STARTPAGE = 3;
		int PAGECOUNT = 100;
		for(int i=STARTPAGE;i<PAGECOUNT;i++){
			if(i == 1){
				host = BASEHOST+"/html/gndy/dyzz/index.html";
			}else{
				host = BASEHOST+"/html/gndy/dyzz/list_23_"+i+".html";
			}
System.out.println("进入第"+i+"页"+host);
			dytt8Service.collectDytt8(host);
		}
		
	}
	@Test
	public void testFaverte(){
		Dytt8Service dytt8Service = (Dytt8Service) context.getBean("dytt8Service");
		ResultSet<Dytt8> rs = new ResultSet<Dytt8>();
		rs.setCurrentPage(1);
		rs = dytt8Service.getFaverateList(rs);
		System.out.println(rs.getResults());
	}
	
	@Test
	public void testUpdate(){
		Dytt8Service dytt8Service = (Dytt8Service) context.getBean("dytt8Service");
		dytt8Service.reCollect();
	}
}
