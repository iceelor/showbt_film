package com.showbt.util;

import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;

public class ConnectionManager {
	static final int TIMEOUT = 20000;//连接超时时间
	static final int SO_TIMEOUT = 20000;//数据传输超时
	static String UA = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1" +
			" (KHTML, like Gecko) Chrome/21.0.1180.89 Safari/537.1";
//	static String Accept_Language = "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3";
//	static String Connection = "keep-alive";
	
	public static DefaultHttpClient getHttpClient(){
		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("http",80,PlainSocketFactory.getSocketFactory()));
		schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
		
		PoolingClientConnectionManager  cm = new PoolingClientConnectionManager(schemeRegistry);
		cm.setMaxTotal(500);
		cm.setDefaultMaxPerRoute(200);
		
		HttpParams params = new BasicHttpParams();
		params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,TIMEOUT);
		params.setParameter(CoreConnectionPNames.SO_TIMEOUT, SO_TIMEOUT);
		params.setParameter(CoreProtocolPNames.USER_AGENT, UA);
		DefaultHttpClient client = new DefaultHttpClient(cm,params);
		return client;
	}
}
