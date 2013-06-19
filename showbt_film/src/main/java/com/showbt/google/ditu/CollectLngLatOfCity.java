package com.showbt.google.ditu;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.showbt.util.HttpService;
import com.showbt.util.JdbcUtil;

/**
 * 通过城市名称，采集经纬度
 * 采集方式通过http请求
 * 数据来源于google map
 * google地方搜索请求地址:http://maps.google.com/maps/api/geocode/xml?address=香港&sensor=false
 * 适用于google map和高德地图
 * 不适用于百度地图
 * @author Ronny
 * @version 0.0.1
 */
public class CollectLngLatOfCity {
	
	
	
	
	private static String encode = "UTF-8";
	public static void main(String[] args){
		CollectLngLatOfCity clloc = new CollectLngLatOfCity();
		String sql = "SELECT * FROM `mn_district` md where md.id NOT in(select d.id from district d)";
		List<Map<String, Object>> res = JdbcUtil.getInstance().select(sql, null);
		for(int i=0; i<res.size(); i++){
			Map<String, Object> xx = res.get(i);
			long id = (long) xx.get("id");
			String cityName = (String) xx.get("cityname");
			long parentid = (long) xx.get("parentid");
			long zoom = (long) xx.get("zoom");
			clloc.searchPlaceMapAbc(cityName,id,parentid,zoom);
System.out.println(id);
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
	
	public void searchPlaceGoogleMap(String place, long id, long parentId,long zoom){
		DistrictDaoImpl ddi = new DistrictDaoImpl();
		String url = "";
//		try {
//			url = "http://maps.google.com/maps/api/geocode/json?address="+URLEncoder.encode(place, "UTF-8")+"&sensor=flase";
//			url = "http://maps.google.com/maps/api/geocode/json?address="+place+"&sensor=true";
			url = "http://maps.googleapis.com/maps/api/geocode/json?address="+place+"&sensor=true";
			
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
		try {
			JSONObject json = HttpService.strToJson(HttpService.httpResponseToStr(url, "get",encode));
			if(json.getString("status").equalsIgnoreCase("ok")){
				JSONArray ja = json.getJSONArray("results");
				for(int i=0; i<ja.size(); i++){
					JSONObject o = ja.getJSONObject(0);
//					JSONArray ac = o.getJSONArray("address_components");
					JSONObject geometry = o.getJSONObject("geometry");
					String fullName = o.getString("formatted_address");
					JSONObject location = geometry.getJSONObject("location");
					JSONObject northeast = geometry.getJSONObject("bounds").getJSONObject("northeast");
					JSONObject southwest = geometry.getJSONObject("bounds").getJSONObject("southwest");
//					System.out.println("ac:"+ac);
//					System.out.println("geometry:"+geometry);
//					System.out.println("fullName:"+fullName);
//					System.out.println("location:"+location);
//					System.out.println("northeast:"+northeast);
//					System.out.println("southwest:"+southwest);
					District d = new District();
					d.setId(id);
					d.setCityName(place);
					d.setParentId(parentId);
					d.setZoom((int)zoom);
					d.setFullName(fullName);
					d.setLat(location.getDoubleValue("lat"));
					d.setLng(location.getDoubleValue("lng"));
					d.setNorthEastLat(northeast.getDoubleValue("lat"));
					d.setNorthEastLng(northeast.getDoubleValue("lng"));
					d.setSouthWestLat(southwest.getDoubleValue("lat"));
					d.setSouthWestLng(southwest.getDoubleValue("lng"));
					ddi.addDistrict(d);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void searchPlaceMapAbc(String place, long id, long parentId,long zoom){
		DistrictDaoImpl ddi = new DistrictDaoImpl();
		String url = "http://api.home.news.cn/map/gss/simple?sid=1021&city="+place+"&resType=json&key=885d2fdae8c36c1fbcfe5b806ff768203ac9c5b0c8306ae139ac98f432932286151dc0ec55580eca&encode=UTF-8";
		if(zoom==5){
			url = "http://api.home.news.cn/map/gss/simple?sid=1023&resType=json&type=province&keyword="+place+"&key=885d2fdae8c36c1fbcfe5b806ff768203ac9c5b0c8306ae139ac98f432932286151dc0ec55580eca&encode=UTF-8";
		}
		try {
			JSONObject json = HttpService.strToJson(HttpService.httpResponseToStr(url, "get",encode));
			if(json.getString("status").equalsIgnoreCase("E0")){
				JSONObject jobj = null;
				District d = new District();
				if(zoom==5){
					jobj = json.getJSONObject("province_list").getJSONObject("province");
					String[] bounds = jobj.getString("bounds").split(";");
					String[] southwest = bounds[0].split(",");
					String[] northeast = bounds[1].split(",");
					d.setSouthWestLng(Double.parseDouble(southwest[0]));
					d.setSouthWestLat(Double.parseDouble(southwest[1]));
					d.setNorthEastLng(Double.parseDouble(northeast[0]));
					d.setNorthEastLat(Double.parseDouble(northeast[1]));
				}else{
					jobj = json.getJSONObject("city");
				}
				d.setId(id);
				d.setCityName(place);
				d.setParentId(parentId);
				d.setZoom((int)zoom);
				d.setLat(jobj.getDoubleValue("y"));
				d.setLng(jobj.getDoubleValue("x"));
				ddi.addDistrict(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
