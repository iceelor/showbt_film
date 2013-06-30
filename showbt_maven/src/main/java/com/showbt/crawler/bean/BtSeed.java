package com.showbt.crawler.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.showbt.constants.ShowBtTable;
import com.showbt.crawler.common.bean.BaseTO;

/**
 * 磁铁资源
 * @author dell
 *
 */
@Table(name=ShowBtTable.TABLEPREFIX+"_btseed")
@Entity
public class BtSeed extends BaseTO{
	@Transient
	private static final long serialVersionUID = -2155346429932347009L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	/**
	 * 资源名称
	 */
	private String title;
	
	@Lob
	private String magnetUrl;
	
	/**
	 * 种子文件大小
	 */
	private String fileSize;
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMagnetUrl() {
		return magnetUrl;
	}

	public void setMagnetUrl(String magnetUrl) {
		this.magnetUrl = magnetUrl;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
}
