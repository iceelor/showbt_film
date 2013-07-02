package com.showbt.crawler.service;

import java.util.List;

import com.showbt.crawler.bean.BtSeed;
import com.showbt.crawler.common.ResultSet;
import com.showbt.crawler.common.service.BaseService;

public interface BtSeedService extends BaseService<BtSeed> {
	
	public List<BtSeed> getBtSeedAll();
	
	public ResultSet<BtSeed> getBtSeedList(ResultSet<BtSeed> rs);
	
	public BtSeed getBtSeed(long id);
	
	public boolean isExist(String title);
	
	public ResultSet<BtSeed> getBtSeedList(ResultSet<BtSeed> rs, String keyword);
}
