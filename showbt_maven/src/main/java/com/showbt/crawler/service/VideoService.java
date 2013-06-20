package com.showbt.crawler.service;
import java.util.List;

import com.showbt.crawler.bean.Video;
import com.showbt.crawler.common.ResultSet;
import com.showbt.crawler.common.service.BaseService;

/**
* 视频工具类
* @author sunlightcs
* 2011-4-6
* http://hi.juziku.com/sunlightcs/
*/
public interface VideoService extends BaseService<Video> {
	/**
	 * 采集视视频
	 * @param url
	 */
	public void collectVideo(String url);
	
	/**
	 * 首页视频列表
	 * @return
	 */
	public List<Video> indexVideo();
	
	/**
	 * 首页推荐视频列表
	 * @return
	 */
	public List<Video> indexRecommendVideo();
	
	public List<Video> getVideoAll();
	
	/**
	 * 分页列表
	 * @param rs
	 * @return
	 */
	public ResultSet<Video> getVideoList(ResultSet<Video> rs);
	
	public Video getVideo(long id);
	
}