package com.showbt.crawler.collect;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StringUtil {
	public static String getRandomString(){
		StringBuffer generateRandStr = new StringBuffer(); 
        Random rand = new Random(); 
        int length = 6; 
        char ch;
        for(int i=0;i<length;i++) 
        { 
         int randNum = Math.abs(rand.nextInt())%26+97; // 产生97到122的随机数(a-z的键位值) 
            ch = ( char ) randNum;
            generateRandStr.append( ch );
        } 
        return generateRandStr.toString(); 
	}
	
	public static String getSavePath(String IMGPATH,String fileName){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(new Date()).toString();
		if(!(fileName.endsWith(".jpg"))){
			fileName = fileName + ".jpg";
		}
		String randStr = StringUtil.getRandomString();
		return IMGPATH+File.separator+date+File.separator+randStr+fileName;
	}
	
	public static String getDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(new Date()).toString();
	}
}
