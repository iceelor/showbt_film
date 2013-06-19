package com.showbt.google.ditu;

import java.util.ArrayList;
import java.util.List;

import com.showbt.util.JdbcUtil;

public class DistrictDaoImpl {
	public int addDistrict(District d){
		String sql = "insert into district (id,parentid,cityname,lng,lat,zoom,northeastlat,northeastlng,southwestlat,southwestlng,fullname) values(?,?,?,?,?,?,?,?,?,?,?)";
		List<Object> values = new ArrayList<Object>();
		values.add(d.getId());
		values.add(d.getParentId());
		values.add(d.getCityName());
		values.add(d.getLng());
		values.add(d.getLat());
		values.add(d.getZoom());
		values.add(d.getNorthEastLat());
		values.add(d.getNorthEastLng());
		values.add(d.getSouthWestLat());
		values.add(d.getSouthWestLng());
		values.add(d.getFullName());
		return JdbcUtil.getInstance().insert(sql, values);
	}
}
