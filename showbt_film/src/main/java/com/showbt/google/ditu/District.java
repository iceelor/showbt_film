package com.showbt.google.ditu;

public class District {
	private long id;
	private long parentId;
	private String cityName;
	private String alias="";
	private double lng;
	private double lat;
	private int zoom=0;
	private int weight=0;
	private int order=0;
	private double northEastLat=0.0;
	private double northEastLng=0.0;
	private double southWestLat=0.0;
	private double southWestLng=0.0;
	private String fullName="";
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public int getZoom() {
		return zoom;
	}
	public void setZoom(int zoom) {
		this.zoom = zoom;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public double getNorthEastLat() {
		return northEastLat;
	}
	public void setNorthEastLat(double northEastLat) {
		this.northEastLat = northEastLat;
	}
	public double getNorthEastLng() {
		return northEastLng;
	}
	public void setNorthEastLng(double northEastLng) {
		this.northEastLng = northEastLng;
	}
	public double getSouthWestLat() {
		return southWestLat;
	}
	public void setSouthWestLat(double southWestLat) {
		this.southWestLat = southWestLat;
	}
	public double getSouthWestLng() {
		return southWestLng;
	}
	public void setSouthWestLng(double southWestLng) {
		this.southWestLng = southWestLng;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
