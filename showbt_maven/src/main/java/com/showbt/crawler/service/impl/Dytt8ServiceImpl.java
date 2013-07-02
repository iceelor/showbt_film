package com.showbt.crawler.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.showbt.crawler.bean.Dytt8;
import com.showbt.crawler.collect.Dytt8Collect;
import com.showbt.crawler.common.ResultSet;
import com.showbt.crawler.common.service.impl.BaseServiceImpl;
import com.showbt.crawler.dao.Dytt8DAO;
import com.showbt.crawler.service.Dytt8Service;
@Service("dytt8Service")
@Transactional
public class Dytt8ServiceImpl extends BaseServiceImpl<Dytt8> implements Dytt8Service {
	private @Autowired Dytt8DAO<Dytt8> dytt8Dao;
	
	public List<String> collectDytt8(String url){
		List<String> res = new ArrayList<String>();
		List<Dytt8> dlist = null;
		try {
			dlist = Dytt8Collect.collect(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(Dytt8 d: dlist){
			if(!isExist(d.getSourceUrl())){
				this.editSave(d);
				res.add(d.getTitle());
			}
		}
		return res;
	}
	
	public boolean isExist(String sourceUrl){
		String hql = "from Dytt8 d where d.sourceUrl=:sourceUrl";
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("sourceUrl", sourceUrl);
		List<Dytt8> dList = dytt8Dao.queryAll(hql, m);
		return (dList!=null&&dList.size()>0)?true:false;
	}
	
	public void reCollect(){
		String hql = "from Dytt8 d where d.downUrl is null";
		List<Dytt8> dList = dytt8Dao.queryAll(hql);
		List<Dytt8> dres = null;
		try {
			dres = Dytt8Collect.reCollect(dList);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		for(Dytt8 d : dres){
			try{
				this.editSave(d);
			}catch(Exception e){
				System.out.println("采集数据已经存在::"+e.getMessage());
			}
		}
	}

	@Override
	public List<Dytt8> getDytt8All() {
		String hql = "from Dytt8 d ";
		List<Dytt8> dList = dytt8Dao.queryAll(hql);
		return dList;
	}
	@Override
	public ResultSet<Dytt8> getDytt8List(ResultSet<Dytt8> rs) {
		rs.setTotalRecord((int)dytt8Dao.count(" from Dytt8 d",null));
		String hql = "from Dytt8 d ";
		List<Dytt8> dList = dytt8Dao.query(hql+" order by d.id desc", rs.getCurrentPage(), rs.getPageSize());
		rs.setResults(dList);
		return rs;
	}

	@Override
	public Dytt8 getDytt8(long id) {
		String hql = " from Dytt8 d where d.id="+id;
		List<Dytt8> dList = dytt8Dao.queryAll(hql);
		if(dList != null && dList.size()>0)
			return dList.get(0);
		return null;
	}

	@Override
	public List<Dytt8> indexFilm() {
		String hql = " from Dytt8 d where d.state=0 order by d.id desc";
		List<Dytt8> dList = dytt8Dao.query(hql, 1, 10);
		return dList;
	}

	@Override
	public List<Dytt8> createThumb() {
		String hql = " from Dytt8 d where d.indexThumb is null order by d.id desc";
		List<Dytt8> dList = dytt8Dao.queryAll(hql);
		return dList;
	}

	@Override
	public ResultSet<Dytt8> getCategoryList(int category, ResultSet<Dytt8> rs) {
		String hql = " from Dytt8 d where d.category=:category";
		Map<String,Object> values = new HashMap<String,Object>();
		values.put("category", category);
		rs.setTotalRecord((int)dytt8Dao.count(hql, values));
		hql += " order by d.id desc";
		List<Dytt8> dList = dytt8Dao.query(hql, values,rs.getCurrentPage(), rs.getPageSize());
		rs.setResults(dList);
		return rs;
	}

	@Override
	public ResultSet<Dytt8> getFaverateList(ResultSet<Dytt8> rs) {
		String hql = " from Dytt8 d";
		rs.setTotalRecord((int)dytt8Dao.count(hql, null));
		hql += " order by rand() desc";
		Random r = new Random();
		int first = r.nextInt(rs.getMaxPage());
		List<Dytt8> dList = dytt8Dao.query(hql, null,first, rs.getPageSize());
		rs.setResults(dList);
		return rs;
	}

	@Override
	public List<Dytt8> indexRecommendFilm(int state) {
		return indexRecommendFilm(state,10);
	}
	@Override
	public List<Dytt8> indexRecommendFilm(int state, int resultSize) {
		if(resultSize<1){
			resultSize = 10;
		}
		String hql = " from Dytt8 d where d.recommend="+state+" order by d.id desc";
		List<Dytt8> dList = dytt8Dao.query(hql, 1, resultSize);
		return dList;
	}
}
