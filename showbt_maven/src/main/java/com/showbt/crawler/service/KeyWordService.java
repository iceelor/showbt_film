package com.showbt.crawler.service;

import java.util.List;

import com.showbt.crawler.bean.KeyWord;
import com.showbt.crawler.common.service.BaseService;

public interface KeyWordService extends BaseService<KeyWord> {
	public List<KeyWord> getKeyWordAll();

	public KeyWord getKeyWord(long id);
	
	public KeyWord getKeyWord(String keyword);
}
