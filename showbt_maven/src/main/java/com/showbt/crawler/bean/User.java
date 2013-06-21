package com.showbt.crawler.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.showbt.constants.ShowBtTable;
import com.showbt.crawler.common.bean.BaseTO;
@Table(name=ShowBtTable.TABLEPREFIX+"_users")
@Entity
public class User extends BaseTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")  
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
	private String id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
	}

	public User(String id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

}
