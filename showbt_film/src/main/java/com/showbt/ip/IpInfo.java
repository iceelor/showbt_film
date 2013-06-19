package com.showbt.ip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class IpInfo {
	private static IpInfo ipInfo;
	private static String ipQueryUrl="http://ip.taobao.com/service/getIpInfo.php?ip="; 
	public static Queue<String> resultIpInfo;
	public static Queue<String> regionIpInfo;
	private static boolean readFlag = true;
	public static boolean getIpFlag = true;
	private static boolean writeFlag = true;
	private String inputFileName;
	private String outFileName;
	private static HttpClient httpClient = null;
	private String proxyIp;
	private int proxyPort;

	public void setProxyIp(String proxyIp) {
		this.proxyIp = proxyIp;
	}

	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public void setOutFileName(String outFileName) {
		this.outFileName = outFileName;
	}

	private IpInfo(){
		resultIpInfo = new LinkedList<String>();
		regionIpInfo = new LinkedList<String>();
		inputFileName = "D:/ipdata/ipdata.txt";
		outFileName = "D:/ipdata/taobaoipdata.txt";
		proxyIp = "202.84.17.41";
		proxyPort = 8080;
	}
	
	public static IpInfo getInstance(){
		if(ipInfo == null){
			ipInfo = new IpInfo();
		}
		return ipInfo;
	}
	
	public void getIpInfo(String ipAddress){
		String[] ip = ipAddress.split("\\s+");
//		resultIpInfo.add(ip[0]+"\t"+ip[1]+"\t"+ip[2]+"\t"+ip[3]);
		HttpClient httpClient = getHttp();
		HttpGet httpGet = new HttpGet(ipQueryUrl+ip[0]);
	    HttpEntity entity  = null;
		try {
			HttpResponse response = httpClient.execute(httpGet);
			entity = response.getEntity();
			String xx = EntityUtils.toString(entity);
			JSONObject obj = JSON.parseObject(xx);
			if(obj.getIntValue("code")==0){
				JSONObject data = obj.getJSONObject("data");
				resultIpInfo.add(ip[0]+"\t"+ip[1]+"\t"+data.toJSONString()+"\t"+ip[3]);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			httpGet.abort();
		}
	}
	
	public HttpClient getHttp(){
		if(httpClient == null){
			httpClient = new DefaultHttpClient();
			HttpHost proxy = new HttpHost(proxyIp,proxyPort);
			httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
		}
		return httpClient;
	}
	
	
	
	/**
	 * 从本地文件中读取数据
	 * @return
	 */
	public boolean readIpInfo(){
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(inputFileName);
			isr = new InputStreamReader(fis,"UTF-8");
			br = new BufferedReader(isr);
			String str;
			int i=0;
			while((str = br.readLine()) != null){
				regionIpInfo.add(str);
				if(i%100==0){
					Thread.sleep(2000);
				}
				i++;
			}
			readFlag = false;
System.out.println("数据已经读完："+regionIpInfo.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			try {
				fis.close();
				isr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return readFlag;
	}
	
	/**
	 * 将采集的数据写入文件中
	 * @return
	 */
	public boolean writeIpInfo(){
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(outFileName,true);
			bw = new BufferedWriter(fw);
			String ip; 
			while(writeFlag){
				while((ip = resultIpInfo.poll()) != null){
					bw.write(ip+"\r\n");
				}
				if(resultIpInfo.size()==0 && !getIpFlag){
					writeFlag = false;
				}else{
					try {
						bw.flush();
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
System.out.println("正在写数据");
			}
			bw.flush();
System.out.println("数据已经写完!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fw.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return writeFlag;
	}
}
