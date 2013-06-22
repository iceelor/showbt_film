package com.showbt.crawler.dao.impl;

import org.springframework.stereotype.Repository;

import com.showbt.crawler.bean.WebSetting;
import com.showbt.crawler.common.dao.impl.BaseDao;
import com.showbt.crawler.dao.WebSettingDAO;

@Repository
public class WebSettingDaoImpl extends BaseDao<WebSetting> implements WebSettingDAO<WebSetting>{

}
