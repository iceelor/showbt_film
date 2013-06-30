package com.showbt.util;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HttpService {

	private static HttpClient httpClient = ConnectionManager.getHttpClient();
	private static String Encode = "UTF-8";
	private static boolean proxyState = false;;
	public static HttpRequestBase getHttpRequest(String url, String method,String referer){
		HttpRequestBase httpRequest = null;
		setProxy("202.84.17.41",8080);
		// String b = URLEncoder.encode(url,"UTF-8");
		if (null != method && method.trim().equalsIgnoreCase("post")) {
			httpRequest = new HttpPost(url);
		} else {
			httpRequest = new HttpGet(url);
		}
		httpRequest.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		// httpRequest.addHeader("Accept-Encoding","gzip, deflate");
//		httpRequest.addHeader("Content-Type", "text/html;charset=UTF-8");
		httpRequest.addHeader("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
		if(StringUtils.isNotBlank(referer)){
			httpRequest.addHeader("referer",referer);
		}
//		httpRequest.addHeader("Connection", "keep-alive");
		// httpRequest.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:20.0) Gecko/20100101 Firefox/20.0");
		return httpRequest;
	}
	
	public static HttpRequestBase getHttpRequest(String url, String method){
		HttpRequestBase httpRequest = null;
		setProxy("202.84.17.41",8080);
		if (null != method && method.trim().equalsIgnoreCase("post")) {
			httpRequest = new HttpPost(url);
		} else {
			httpRequest = new HttpGet(url);
		}
		httpRequest.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpRequest.addHeader("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
		return httpRequest;
	}

	public static HttpResponse httpRequest(String url, String method, String referer) {
		setProxy("202.84.17.41",8080);
		HttpRequestBase httpRequest= getHttpRequest(url,method,referer);
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpRequest);
		} catch (Exception e) {
			System.out.println("网页打开出错:"+e.getMessage());
			return null;
		}
		return httpResponse;
	}
	
	public static HttpResponse httpRequest(String url, String method) {
		setProxy("202.84.17.41",8080);
		HttpRequestBase httpRequest= getHttpRequest(url,method,null);
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpRequest);
		} catch (Exception e) {
			System.out.println("网页打开出错:"+e.getMessage());
			return null;
		}
		return httpResponse;
	}

	/**
	 * 将请求结果转换成字符串
	 * @param response
	 * @return
	 */
	public static String httpResponseToStr(String url, String method, String encode) {
		if(StringUtils.isBlank(encode)){
			encode = Encode;
		}
		setProxy("202.84.17.41",8080);
		HttpRequestBase httpRequest= getHttpRequest(url,method);
		HttpResponse httpResponse = null;
		String result = "";
		HttpEntity entity = null;
		try {
			httpResponse = httpClient.execute(httpRequest);
			entity = httpResponse.getEntity();
			result = EntityUtils.toString(entity,encode);
		} catch (Exception e) {
			System.out.println("httpResponseToStr：请求结果转换出错！"+e.getMessage());
			return null;
		}finally{
			httpRequest.abort();
			try {
				EntityUtils.consume(entity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 字符串转换成json对象
	 * @param str
	 * @return
	 */
	public static JSONObject strToJson(String str) {
		JSONObject obj = JSON.parseObject(str);
		return obj;
	}
	
	public static Document getURLContent(String url) throws Exception{
		return getURLContent(url,"get");
	}
	
	/**
	 * 获取网页的内容
	 */
	public static Document getURLContent(String url, String method) throws Exception{
//		Document doc = Jsoup.connect(url)
//		  .data("query", "Java")
//		  .userAgent("Mozilla")
//		  .cookie("auth", "token")
//		  .timeout(6000)
//		  .post();
		HttpEntity entity = null;
		HttpResponse response =  HttpService.httpRequest(url,method);
		 if(response != null){
			 entity = response.getEntity();
		 }
		Document doc = null;
		if(entity != null){
			Header header = entity.getContentType();
			String type = header.getValue();
			if(type.indexOf("charset=") != -1){
				Encode = type.substring(type.lastIndexOf("=")+1,type.length());	
			}
System.out.println("encode:"+Encode);
			doc = Jsoup.parse(entity.getContent(), Encode, url);
		}
		return doc;
	}
	
	/**
	 * 获取网页的内容
	 */
	public static Document getURLContent(String url, String method, String referer) throws Exception{
		HttpEntity entity = null;
		HttpResponse response =  HttpService.httpRequest(url,method,referer);
		 if(response != null){
			 entity = response.getEntity();
		 }
		Document doc = null;
		if(entity != null){
			Header header = entity.getContentType();
			String type = header.getValue();
			if(type.indexOf("charset=") != -1){
				setEncode(type.substring(type.lastIndexOf("=")+1,type.length()));	
			}
			doc = Jsoup.parse(entity.getContent(), Encode, url);
		}
		return doc;
	}

	/**
	 * 代理设置
	 * 如果要使用代理，请将proxy设置为true;或者代理不会生效
	 * @param proxy
	 * @param port
	 */
	public static void setProxy(String ip, int port) {
		if(isProxyState()){
			HttpHost host = new HttpHost(ip, port);
			httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, host);
		}
	}

	public static boolean isProxyState() {
		return proxyState;
	}

	public static void setProxyState(boolean proxyState) {
		HttpService.proxyState = proxyState;
	}

	public static void setEncode(String encode) {
		Encode = encode;
	}
	
}
