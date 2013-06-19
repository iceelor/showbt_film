package com.showbt.crawler.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.showbt.crawler.common.bean.BaseTO;

/**
* 视频封装
* @author sunlightcs
* 2011-4-6
* http://hi.juziku.com/sunlightcs/
*/
@Table(name="tb_video" ,uniqueConstraints = {@UniqueConstraint(columnNames = { "sourceUrl" })})
@Entity
public class Video extends BaseTO{

	@Transient
	private static final long serialVersionUID = -2068574421512928390L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	/**
	 * 视频标题
	 */
	private String title;
	/**
	 * flash地址，可以直接嵌入其它网站
	 */
	private String flash;
	/**
	 * 视频缩略图
	 */
	private String pic;
	/**
	 * 视频时长
	 */
	private String timeLen;
	/**
	 * 视频原始地址
	 */
	private String sourceUrl;
	/**
	 * 视频来源，如优酷，土豆等
	 */
	private String source;
	/**
	 * 电影库对应的ID
	 */
	private long filmId;
	/**
	 * 视频使用状态，0：默认，1：公开
	 */
	private int state=0;
	/**
	 * 是否推荐，0：不推荐，1：推荐
	 */
	private int recommend=0;
	@Temporal(TemporalType.TIMESTAMP)
	private Date addTime = new Date();
	public String getFlash() {
		return flash;
	}
	public void setFlash(String flash) {
		this.flash = flash;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTimeLen() {
		return timeLen;
	}
	public void setTimeLen(String timeLen) {
		this.timeLen = timeLen;
	}
	public String getSourceUrl() {
		return sourceUrl;
	}
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}
	public long getFilmId() {
		return filmId;
	}
	public void setFilmId(long filmId) {
		this.filmId = filmId;
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
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
}