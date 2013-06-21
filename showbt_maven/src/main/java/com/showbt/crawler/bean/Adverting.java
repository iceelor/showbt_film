package com.showbt.crawler.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.showbt.constants.ShowBtTable;
import com.showbt.crawler.common.bean.BaseTO;

@Table(name=ShowBtTable.TABLEPREFIX+"_adverting")
@Entity
public class Adverting extends BaseTO{
	@Transient
	private static final long serialVersionUID = 3412387197635127629L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/**
	 * 页面上取广告代码用
	 */
	private String adKey;
	
	/**
	 * 广告标题
	 */
	private String title;
	/**
	 * 广告代码
	 */
	@Column(length=2000)
	private String adCode;
	/**
	 * 广告宽度
	 */
	private int width;
	/**
	 * 广告高度
	 */
	private int height;
	/**
	 * 广告来源
	 */
	private String source;
	/**
	 * 广告录入时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date addTime = new Date();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAdCode() {
		return adCode;
	}
	public void setAdCode(String adCode) {
		this.adCode = adCode;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getAdKey() {
		return adKey;
	}
	public void setAdKey(String adKey) {
		this.adKey = adKey;
	}
	
}
