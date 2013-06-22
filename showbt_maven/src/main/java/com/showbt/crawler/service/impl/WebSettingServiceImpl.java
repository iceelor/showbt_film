package com.showbt.crawler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.showbt.crawler.bean.WebSetting;
import com.showbt.crawler.common.service.impl.BaseServiceImpl;
import com.showbt.crawler.dao.WebSettingDAO;
import com.showbt.crawler.service.WebSettingService;

@Service("webSettingService")
@Transactional
public class WebSettingServiceImpl extends BaseServiceImpl<WebSetting> implements WebSettingService {

	private @Autowired WebSettingDAO<WebSetting> webSettingDao;
	
	@Override
	public List<WebSetting> getWebSettingAll() {
		String hql = "from WebSetting ws ";
		List<WebSetting> dList = webSettingDao.queryAll(hql);
		return dList;
	}

	@Override
	public WebSetting getWebSetting(long id) {
		String hql = " from WebSetting ws where ws.id="+id;
		List<WebSetting> dList = webSettingDao.queryAll(hql);
		if(dList != null && dList.size()>0)
			return dList.get(0);
		return null;
	}

}
