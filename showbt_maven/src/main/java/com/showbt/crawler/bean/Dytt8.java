package com.showbt.crawler.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.showbt.constants.ShowBtTable;
import com.showbt.crawler.common.bean.BaseTO;

@Table(name=ShowBtTable.TABLEPREFIX+"_dytt8",uniqueConstraints = {@UniqueConstraint(columnNames = { "sourceUrl" })})
@Entity
public class Dytt8 extends BaseTO{
	@Transient
	private static final long serialVersionUID = -2155346429932347009L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	/**
	 * 电影名称
	 */
	private String title;
	/**
	 * 副标题
	 */
	private String subtitle;
	/**
	 * 首页缩略图
	 */
	private String indexThumb;
	/**
	 * 首页幻灯缩略图
	 */
	private String slideThumb;
	/**
	 * 首页幻灯大图
	 */
	private String slideImg;
	/**
	 * 推荐缩略图
	 */
	private String recommendImg;
	/**
	 * 电影介绍图片
	 */
	@Lob
	private String imageUrl;
	/**
	 * 电影简介
	 */
	@Lob
	private String content;
	/**
	 * 下载地址
	 */
	@Lob
	private String downUrl;
	/**
	 * 电影原始地址
	 */
	private String sourceUrl;
	
	/**
	 * 在线播放地址
	 */
	private String onlineUrl;
	
	/**
	 * 采集时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date addTime= new Date();
	
	/**
	 * 主演
	 */
	private String protagonist;
	
	/**
	 * 导演
	 */
	private String director;
	
	/**
	 * 上映时间
	 */
	private String showTime;
	/**
	 * 电影发布状态
	 * ０：刚采集未经人为审核
	 * 1：通过人为审核
	 * ２：审核未通过
	 * ３：标记删除
	 */
	private int state;
	/**
	 * 是否为推荐电影
	 * ０为默认
	 * １为推荐电影
	 */
	private int recommend;
	
	/**
	 * 标签
	 */
	private String tags;
	
	/**
	 * 电影类型
	 */
	private int category;
	
	/**
	 * 分类名称
	 */
	private String categoryName;
	
	/**
	 * 区域
	 */
	private String district;
	/**
	 * 视频时长
	 */
	private String timeLen;
	/**
	 * 文件大小
	 */
	private String fileSize;
	/**
	 * 语言
	 */
	private String language;
	/**
	 * 字幕
	 */
	private String caption;
	/**
	 * 视频尺寸
	 */
	private String videoSize;
	/**
	 * 文件格式
	 */
	private String fileFormat;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDownUrl() {
		return downUrl;
	}
	public void setDownUrl(String downUrl) {
		this.downUrl = downUrl;
	}
	public String getSourceUrl() {
		return sourceUrl;
	}
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public String getProtagonist() {
		return protagonist;
	}
	public void setProtagonist(String protagonist) {
		this.protagonist = protagonist;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getIndexThumb() {
		return indexThumb;
	}
	public void setIndexThumb(String indexThumb) {
		this.indexThumb = indexThumb;
	}
	public String getSlideThumb() {
		return slideThumb;
	}
	public void setSlideThumb(String slideThumb) {
		this.slideThumb = slideThumb;
	}
	public String getSlideImg() {
		return slideImg;
	}
	public void setSlideImg(String slideImg) {
		this.slideImg = slideImg;
	}
	public String getRecommendImg() {
		return recommendImg;
	}
	public void setRecommendImg(String recommendImg) {
		this.recommendImg = recommendImg;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getTimeLen() {
		return timeLen;
	}
	public void setTimeLen(String timeLen) {
		this.timeLen = timeLen;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getVideoSize() {
		return videoSize;
	}
	public void setVideoSize(String videoSize) {
		this.videoSize = videoSize;
	}
	public String getFileFormat() {
		return fileFormat;
	}
	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}
	public String getOnlineUrl() {
		return onlineUrl;
	}
	public void setOnlineUrl(String onlineUrl) {
		this.onlineUrl = onlineUrl;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}