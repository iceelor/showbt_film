package com.showbt.crawler.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.showbt.constants.ShowBtTable;
import com.showbt.crawler.common.bean.BaseTO;

/**
 * 记住关键字，进行数据采集
 * @author dell
 *
 */
@Table(name=ShowBtTable.TABLEPREFIX+"_keyword", uniqueConstraints = { @UniqueConstraint(columnNames = { "keyword" }) })
@Entity
public class KeyWord extends BaseTO{
	@Transient
	private static final long serialVersionUID = -2155346429932347009L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	/**
	 * 资源名称
	 */
	private String keyword;
	
	/**
	 * 数据采集，系统是否采集，0未采集，1已经采集
	 */
	private int state;
	
	/**
	 * 采集数据条数
	 */
	private int recordNum;
	
	/**
	 * 关键词搜索结果总共多少页
	 */
	private int maxPage;
	
	/**
	 * 采集到第几页
	 */
	private int current;
	
	/**
	 * 采集时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date addTime= new Date();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public int getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(int recordNum) {
		this.recordNum = recordNum;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}
	
}
