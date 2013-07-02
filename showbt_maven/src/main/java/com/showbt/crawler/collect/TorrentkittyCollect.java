package com.showbt.crawler.collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.showbt.crawler.bean.BtSeed;
import com.showbt.util.HttpService;


public class TorrentkittyCollect {
	public static Map<String, Object> get(String keywords, String page){
		Map<String, Object> res = new HashMap<String, Object>();
		int pg = 1;
		String url = "http://www.torrentkitty.com/search/"+keywords;
		if(StringUtils.isNotBlank(page)){
			url += "/"+page;
			pg = Integer.parseInt(page);
		}
System.out.println(url);
		int max = 1;
		List<BtSeed> bsList = new ArrayList<BtSeed>();
		try {
//			HttpService.setEncode("ISO-8859-1");
			Document d = HttpService.getURLContent(url);
			if(d !=null){
			//分页
				Elements aes = d.select("div.pagination a");
				for(Element a : aes){
					String p = a.attr("href")+"  ";
					try{
						int temp = Integer.parseInt(p.trim());
						if(temp>max){
							max = temp;
						}
					}catch(Exception e){
						System.out.println("数字转转换出错");
					}
				}
				Element es = d.getElementById("archiveResult");
				Elements ees = es.select("tr");
				for (Element td : ees) {
					BtSeed bs = new BtSeed();
					String name = td.select("td.name").text();
					String size = td.select("td.size").text();
					String magnet = "";
					Elements  as= td.select("td.action").select("a");
					
					for(Element a : as){
						String ref = a.attr("rel");
						if(StringUtils.isNotBlank(ref)&& ref.equalsIgnoreCase("magnet")){
							magnet = a.attr("href");
							break;
						}
					}
					bs.setTitle(name);
					bs.setFileSize(size);
					bs.setMagnetUrl(magnet);
					if(StringUtils.isNotBlank(bs.getMagnetUrl()))
						bsList.add(bs);
				}
				
			}
//			for(BtSeed bs: bsList){
//				xx += bs.getTitle()+"  "+bs.getFileSize()+"    "+bs.getMagnetUrl()+" <br/>";
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		res.put("page", pg);
		res.put("maxPage", max);
		res.put("resultList", bsList);
		return res;
	}
}
