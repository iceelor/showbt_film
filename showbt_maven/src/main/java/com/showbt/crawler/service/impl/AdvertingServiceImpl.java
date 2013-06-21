package com.showbt.crawler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.showbt.crawler.bean.Adverting;
import com.showbt.crawler.common.service.impl.BaseServiceImpl;
import com.showbt.crawler.dao.AdvertingDAO;
import com.showbt.crawler.service.AdvertingService;

@Service("advertingService")
@Transactional
public class AdvertingServiceImpl extends BaseServiceImpl<Adverting> implements AdvertingService {

	private @Autowired AdvertingDAO<Adverting> advertingDao;
	
	@Override
	public List<Adverting> getAdvertingAll() {
		String hql = "from Adverting ad ";
		List<Adverting> dList = advertingDao.queryAll(hql);
		return dList;
	}

	@Override
	public Adverting getAdverting(long id) {
		String hql = " from Adverting ad where ad.id="+id;
		List<Adverting> dList = advertingDao.queryAll(hql);
		if(dList != null && dList.size()>0)
			return dList.get(0);
		return null;
	}


}
