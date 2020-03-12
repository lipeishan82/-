package com.jakey.util;
/**

* Copyright (C), 03.06-03.11

* FileName: DbUtil.java

* 数据库连接

* @author Lipeishan
* @Date    2020.03.06

* @version 1.00

*/
import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	private static String dbUrl = "jdbc:mysql://localhost:3306/eps_management?useUnicode=true&characterEncoding=utf8";
	private static String dbUserName = "root";
	private static String dbPassword = ":hksdaPoe3jE";
	private static String jdbcName = "com.mysql.jdbc.Driver";

	public static Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}

	public static void closeCon(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}

	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
