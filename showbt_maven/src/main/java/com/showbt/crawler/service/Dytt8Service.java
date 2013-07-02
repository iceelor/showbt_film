package com.showbt.crawler.service;

import java.util.List;

import com.showbt.crawler.bean.Dytt8;
import com.showbt.crawler.common.ResultSet;
import com.showbt.crawler.common.service.BaseService;

public interface Dytt8Service extends BaseService<Dytt8> {
	
	public List<Dytt8> getDytt8All();
	
	public ResultSet<Dytt8> getDytt8List(ResultSet<Dytt8> rs);
	
	public Dytt8 getDytt8(long id);
	
	/**
	 * 采集每一页的内容
	 * @param url
	 */
	public List<String> collectDytt8(String url);
	
	/**
	 * 得到已经采集过但数据不完整的数据，准备进行重新采集
	 */
	public void reCollect();
	
	/**
	 * 首页电影列表
	 * @return
	 */
	public List<Dytt8> indexFilm();
	
	/**
	 * 推荐电影
	 * @return
	 */
	public List<Dytt8> indexRecommendFilm(int state);
	
	public List<Dytt8> indexRecommendFilm(int state, int resultSize);
	
	/**
	 * 查找未创建缩略图数据
	 * @return
	 */
	public List<Dytt8> createThumb();
	
	/**
	 * 获取栏目电影列表
	 * @param category	栏目
	 * @param page	分页
	 * @param pageSize
	 * @return
	 */
	public ResultSet<Dytt8> getCategoryList(int category,ResultSet<Dytt8> rs);
	
	/**
	 * 获取猜你喜欢的电影
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public ResultSet<Dytt8> getFaverateList(ResultSet<Dytt8> rs);
	
}
