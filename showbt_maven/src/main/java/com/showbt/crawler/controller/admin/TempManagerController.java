package com.showbt.crawler.controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Controller
@RequestMapping(value="/admin")
public class TempManagerController {
	
	@RequestMapping(value="/templ")
	@ResponseBody
	public String templ(HttpServletRequest request, HttpServletResponse response){
//		http://bbs.csdn.net/topics/380083886
		String dir = "/";
		Configuration conf = new Configuration();
		try {
			conf.setDirectoryForTemplateLoading(new File(dir));
			conf.setObjectWrapper(new DefaultObjectWrapper());
			Template temp = conf.getTemplate("test.ftl");
			Map root = new HashMap();
			root.put("user", "Abc ddd");
			Map latest = new HashMap();
			root.put("latestProduct", latest);
			latest.put("url", "products/greenmouse.html");
			latest.put("name", "green mouse");
			/* 将模板和数据模型合并 */
			Writer out = new OutputStreamWriter(System.out);
			temp.process(root, out);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		
		return "admin/templ";
	}
}
