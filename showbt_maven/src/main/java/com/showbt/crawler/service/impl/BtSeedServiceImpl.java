package com.showbt.crawler.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.showbt.crawler.bean.BtSeed;
import com.showbt.crawler.common.ResultSet;
import com.showbt.crawler.common.service.impl.BaseServiceImpl;
import com.showbt.crawler.dao.BtSeedDAO;
import com.showbt.crawler.service.BtSeedService;

@Service("btSeedService")
@Transactional
public class BtSeedServiceImpl extends BaseServiceImpl<BtSeed> implements BtSeedService {
	private @Autowired BtSeedDAO<BtSeed> btSeedDao;

	public List<BtSeed> getBtSeedAll() {
		String hql = "from BtSeed bs ";
		List<BtSeed> dList = btSeedDao.queryAll(hql);
		return dList;
	}

	public BtSeed getBtSeed(long id) {
		String hql = " from BtSeed bs where bs.id="+id;
		List<BtSeed> dList = btSeedDao.queryAll(hql);
		if(dList != null && dList.size()>0)
			return dList.get(0);
		return null;
	}

	@Override
	public ResultSet<BtSeed> getBtSeedList(ResultSet<BtSeed> rs) {
		rs.setTotalRecord((int)btSeedDao.count(" from BtSeed bs",null));
		String hql = "from BtSeed bs ";
		List<BtSeed> dList = btSeedDao.query(hql+" order by bs.id desc", rs.getCurrentPage(), rs.getPageSize());
		rs.setResults(dList);
		return rs;
	}

	@Override
	public boolean isExist(String title) {
		String hql = " from BtSeed bs where bs.title=:title";
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("title", title);
		List<BtSeed> dList = btSeedDao.queryAll(hql, m);
		return (dList!=null&&dList.size()>0)?true:false;
	}

	@Override
	public ResultSet<BtSeed> getBtSeedList(ResultSet<BtSeed> rs, String keyword) {
		String hql = "from BtSeed bs where bs.title like :title";
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("title", "%"+keyword+"%");
		rs.setTotalRecord((int)btSeedDao.count(hql,m));
		List<BtSeed> dList = btSeedDao.query(hql+" order by bs.id desc", m, rs.getCurrentPage(), rs.getPageSize());
		rs.setResults(dList);
		return rs;
	}
}
