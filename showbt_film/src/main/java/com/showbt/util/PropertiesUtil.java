package com.showbt.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesUtil {
	
	private  String fileName;
	private static PropertiesUtil pu;
	private PropertiesUtil (){}
	
	public static PropertiesUtil getInstance(){
		if(pu == null)
			pu = new PropertiesUtil();
		return pu;
	}
	
	public String getProperties(String name, String def) throws Exception{
		if(getFileName() ==null){
			throw new Exception("请调用setFileName设置属性文件名称");
		}
		ResourceBundle rb = ResourceBundle.getBundle(getFileName(),Locale.getDefault());
		return rb.getString(name);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
