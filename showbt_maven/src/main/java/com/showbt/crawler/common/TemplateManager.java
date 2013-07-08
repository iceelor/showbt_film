package com.showbt.crawler.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TemplateManager {

	private static TemplateManager templ = null;
	private final static String TEMPLATE_ROOT = "WEB-INF/views";

	private TemplateManager() {
	}

	public static TemplateManager getInstance() {
		if (templ == null) {
			templ = new TemplateManager();
		}
		return templ;
	}

	public String createHTML(Map<String, Object> model, String templatePath, String targetHtmlPath, HttpServletRequest request){
		ServletContext context = request.getSession().getServletContext();
		Configuration freemarkerCfg = new Configuration();
		// 加载模版
		freemarkerCfg.setServletContextForTemplateLoading(context, "/");
		freemarkerCfg.setEncoding(Locale.getDefault(), "UTF-8");
		String htmlPath = "";
		targetHtmlPath = "html/" + targetHtmlPath;
		try {
			// 指定模版路径
			Template template = freemarkerCfg.getTemplate(TEMPLATE_ROOT+templatePath, "UTF-8");
			template.setEncoding("UTF-8");
			// 静态页面路径
			htmlPath = context.getRealPath("/") + targetHtmlPath;
			// 站点根目录的绝对路径
			File htmlFile = new File(htmlPath);
			if (!htmlFile.getParentFile().exists()) {
				htmlFile.getParentFile().mkdirs();
			}
			if (!htmlFile.exists()) {
				htmlFile.createNewFile();
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile), "UTF-8"));
				// 处理模版
				template.process(model, out);
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			targetHtmlPath = "";
		}
		/* 将请求转发到生成的htm文件 */
		return targetHtmlPath;
	}
}
