package com.showbt.crawler.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.showbt.crawler.bean.KeyWord;
import com.showbt.crawler.common.service.impl.BaseServiceImpl;
import com.showbt.crawler.dao.KeyWordDAO;
import com.showbt.crawler.service.KeyWordService;

@Service("keyWordService")
@Transactional
public class KeyWordServiceImpl extends BaseServiceImpl<KeyWord> implements KeyWordService {
	private @Autowired KeyWordDAO<KeyWord> keyWordDao;

	public List<KeyWord> getKeyWordAll() {
		String hql = "from KeyWord kw ";
		List<KeyWord> dList = keyWordDao.queryAll(hql);
		return dList;

	}

	public KeyWord getKeyWord(long id) {
		String hql = " from KeyWord kw where kw.id="+id;
		List<KeyWord> dList = keyWordDao.queryAll(hql);
		if(dList != null && dList.size()>0)
			return dList.get(0);
		return null;
	}
	
	public KeyWord getKeyWord(String keyword){
		String hql = "from KeyWord kw where kw.keyword=:keyword";
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("keyword", keyword);
		List<KeyWord> dList = keyWordDao.queryAll(hql, m);
		return (dList!=null&&dList.size()>0)?dList.get(0):null;
	}
}
