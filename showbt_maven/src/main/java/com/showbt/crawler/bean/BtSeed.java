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
	 * 采集时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date addTime= new Date();
}
