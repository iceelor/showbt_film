package com.showbt.crawler.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.showbt.crawler.bean.Dytt8;
import com.showbt.crawler.common.dao.impl.BaseDao;
import com.showbt.crawler.dao.Dytt8DAO;
import com.showbt.util.JdbcUtil;

@Repository
public class Dytt8DaoImpl extends BaseDao<Dytt8> implements Dytt8DAO<Dytt8>{
	public int addDytt8(Dytt8 d){
		String sql = "insert into tb_dytt8 (title,content,downurl,imageurl,addtime,sourceurl) values(?,?,?,?,now(),?)";
		List<Object> values = new ArrayList<Object>();
		values.add(d.getTitle());
		values.add(d.getContent());
		values.add(d.getDownUrl());
		values.add(d.getImageUrl().toString());
		values.add(d.getSourceUrl());
		return JdbcUtil.getInstance().insert(sql, values);
	}

}
