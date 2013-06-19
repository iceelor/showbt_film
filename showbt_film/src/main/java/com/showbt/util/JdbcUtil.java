package com.showbt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JdbcUtil {
	private static JdbcUtil jdbcUtil;
	private static Connection conn;
	private static String driver = "";
	private static String url = "";
	private static String user = "";
	private static String password = "";

	private JdbcUtil() {
		conn = this.getConnection();
	}

	public static JdbcUtil getInstance() {
		if (jdbcUtil == null) {
			jdbcUtil = new JdbcUtil();
		}
		return jdbcUtil;
	}

	static {
		try {
			PropertiesUtil.getInstance().setFileName("jdbc");
			driver = PropertiesUtil.getInstance().getProperties(
					"jdbc.driverClassName", "");
			url = PropertiesUtil.getInstance().getProperties("jdbc.url", "");
			user = PropertiesUtil.getInstance().getProperties("jdbc.username",
					"");
			password = PropertiesUtil.getInstance().getProperties(
					"jdbc.password", "");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public List<Map<String, Object>> select(String sql, List<?> whereValues) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			if(whereValues != null){
				int i = 1;
				for (Object v : whereValues) {
					if (v instanceof Integer) {
						pstmt.setInt(i, (int) v);
					} else if (v instanceof Long) {
						pstmt.setLong(i, (long) v);
					} else if (v instanceof Boolean) {
						pstmt.setBoolean(i, (boolean) v);
					} else if (v instanceof Double) {
						pstmt.setDouble(i, (double) v);
					} else if (v instanceof Float) {
						pstmt.setFloat(i, (float) v);
					} else if (v instanceof Short) {
						pstmt.setInt(i, (int) v);
					} else if (v instanceof Date) {
						Date d = (Date) v;
						java.sql.Timestamp sqld = new java.sql.Timestamp(
								d.getTime());
						pstmt.setTimestamp(i, sqld);
					} else {
						pstmt.setString(i, v.toString());
					}
					i++;
				}
			}
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int ccount = rsmd.getColumnCount();
			while (rs.next()) {
				Map<String, Object> record = new LinkedHashMap<>();
				for(int c=1; c<=ccount; c++){
					String cName = rsmd.getColumnName(c);
					record.put(cName, rs.getObject(cName));
				}
				result.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStmt(pstmt);
		}
		return result;
	}

	public int insert(String sql, List<?> values) {
		if(values == null)return 0;
		int result = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			int i = 1;
			for (Object v : values) {
				if (v instanceof Integer) {
					pstmt.setInt(i, (int) v);
				} else if (v instanceof Long) {
					pstmt.setLong(i, (long) v);
				} else if (v instanceof Boolean) {
					pstmt.setBoolean(i, (boolean) v);
				} else if (v instanceof Double) {
					pstmt.setDouble(i, (double) v);
				} else if (v instanceof Float) {
					pstmt.setFloat(i, (float) v);
				} else if (v instanceof Short) {
					pstmt.setInt(i, (int) v);
				} else if (v instanceof Date) {
					Date d = (Date) v;
					java.sql.Timestamp sqld = new java.sql.Timestamp(
							d.getTime());
					pstmt.setTimestamp(i, sqld);
				} else {
					pstmt.setString(i, (String)v);
				}
				i++;
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStmt(pstmt);
		}
		return result;
	}

	private void closeStmt(PreparedStatement pstmt) {
		try {
			if(pstmt != null)
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pstmt = null;
	}

	public static void closeConn() {
		try {
			if(conn != null)
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
	}

	public static void main(String args[]) {
		JdbcUtil ju = JdbcUtil.getInstance();
//		String sql = "insert into test (name,sex,money,addtime) values(?,?,?,?)";
//		List values = new ArrayList();
//		values.add("test");
//		values.add(1);
//		values.add(1.232);
//		values.add(new Date());
//		int i = ju.insert(sql, values);
//		System.out.println(i);
		String sql = "select * from test";
		List<Map<String,Object>> r = ju.select(sql, null);
		for(Map<String,Object> m : r){
			System.out.println(m);
		}
	}
}
