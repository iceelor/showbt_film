package com.showbt.crawler.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.showbt.crawler.bean.Video;
import com.showbt.crawler.collect.VideoCollect;
import com.showbt.crawler.common.ResultSet;
import com.showbt.crawler.common.service.impl.BaseServiceImpl;
import com.showbt.crawler.dao.VideoDAO;
import com.showbt.crawler.service.VideoService;

/**
* 视频工具类
* @author sunlightcs
* 2011-4-6
* http://hi.juziku.com/sunlightcs/
*/
@Service("videoService")
@Transactional
public class VideoServiceImpl extends BaseServiceImpl<Video> implements VideoService{
	
	private @Autowired VideoDAO<Video> videoDao;
	
	public boolean isExist(String sourceUrl){
		String hql = "from Video v where v.sourceUrl=:sourceUrl";
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("sourceUrl", sourceUrl);
		List<Video> dList = videoDao.queryAll(hql, m);
		return (dList!=null&&dList.size()>0)?true:false;
	}

	@Override
	public void collectVideo(String url) {
		List<Video> vlist = null;
		try {
			vlist = VideoCollect.getVideoList(url);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		for(Video v: vlist){
			if(!isExist(v.getSourceUrl())){
				this.editSave(v);
			}
		}
	}

	@Override
	public List<Video> indexVideo() {
		String hql = " from Video v where v.state=0 order by v.id desc";
		List<Video> vList = videoDao.query(hql, 1, 12);
		return vList;
	}

	@Override
	public List<Video> getVideoAll() {
		String hql = "from Video v ";
		List<Video> dList = videoDao.queryAll(hql);
		return dList;
	}

	@Override
	public ResultSet<Video> getVideoList(ResultSet<Video> rs) {
		rs.setTotalRecord((int)videoDao.count(" from Video v",null));
		String hql = "from Video v ";
		List<Video> dList = videoDao.query(hql+" order by v.id desc", rs.getCurrentPage(), rs.getPageSize());
		rs.setResults(dList);
		return rs;
	}

	@Override
	public Video getVideo(long id) {
		String hql = " from Video v where v.id="+id;
		List<Video> dList = videoDao.queryAll(hql);
		if(dList != null && dList.size()>0)
			return dList.get(0);
		return null;
	}

	@Override
	public List<Video> indexRecommendVideo() {
		String hql = " from Video v where v.state=0 order by v.id desc";
		List<Video> vList = videoDao.query(hql, 1, 10);
		return vList;
	}
}
