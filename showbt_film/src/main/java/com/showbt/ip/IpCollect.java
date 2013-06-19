package com.showbt.ip;

import java.util.Date;


/**
 * ip地址数据采集
 * @author Ronny
 *
 */
public class IpCollect {
	private static boolean readFlag = true;
	private static boolean getIpFlag = true;
	private static Date startTime = null;
	private static Date endTime = null;
	
	public static void main(String[] args) throws Exception{
		startTime = new Date();
		final IpInfo ipInfo = IpInfo.getInstance();
		ipInfo.setInputFileName("D:/ipdata/ipdata1_2000.txt");
		ipInfo.setOutFileName("D:/ipdata/taobaoipdata1_2000.txt");
//		ipInfo.setProxyIp("");
//		ipInfo.setProxyPort(8080);
		//读取文件，将IP放入区域队列中
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(readFlag){
					readFlag = ipInfo.readIpInfo();
				}
			}
		}).start();
		
		//从区域队列中读取数据，调用淘宝接口，将返回结果放入结果队列中
		new Thread(new Runnable() {
			int i = 1;
			@Override
			public void run() {
				while(getIpFlag){
					int size = IpInfo.regionIpInfo.size();
					String ip;
					
					while((ip = IpInfo.regionIpInfo.poll()) != null){
System.out.println("序号:"+i);
						i++;
						ipInfo.getIpInfo(ip);
						if(i%10==0){
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(size==0 && !readFlag){
						getIpFlag = false;
					}
				}
				IpInfo.getIpFlag = false;
			}
		}).start();
		
		//从结果队列中读取数据，存入本地文件
		new Thread(new Runnable() {
			boolean writeFlag = true;
			@Override
			public void run() {
				while(writeFlag){
					writeFlag = ipInfo.writeIpInfo();
				}
				endTime = new Date();
				long mm = (endTime.getTime()-startTime.getTime());
				long m = mm/1000;
				long f = m/60;
System.out.println("总共用时："+f+"分钟"+(m%60)+"秒");
			}
		}).start();
		
	}
}
