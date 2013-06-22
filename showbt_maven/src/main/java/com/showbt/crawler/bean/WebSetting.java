package com.showbt.crawler.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.showbt.constants.ShowBtTable;
import com.showbt.crawler.common.bean.BaseTO;

/**
 * 网站全局设置 
 * @author dell
 *
 */
@Table(name=ShowBtTable.TABLEPREFIX+"_websetting",uniqueConstraints = {@UniqueConstraint(columnNames = { "sKey" })})
@Entity
public class WebSetting extends BaseTO{
	@Transient
	private static final long serialVersionUID = -2068574421512928390L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;
	/**
	 * 网站设置关键字
	 */
	@Column(length=50)
	public String sKey;
	/**
	 * 网站设置的内容
	 */
	@Lob
	public String sValue;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getsKey() {
		return sKey;
	}
	public void setsKey(String sKey) {
		this.sKey = sKey;
	}
	public String getsValue() {
		return sValue;
	}
	public void setsValue(String sValue) {
		this.sValue = sValue;
	}
	
}
