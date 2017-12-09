/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timor.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class DataBaseConnection {
    // 定义了MySQL数据库的驱动程序
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	// 定义了MySQL数据库的连接地址
	public static final String DBURL = "jdbc:mysql://127.0.0.1:3306/timor";
	public static final String DBUSER = "root";
	public static final String DBPASS = "123456";

	private Connection conn = null;
	public DataBaseConnection() throws Exception{
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (Exception e) {
			throw e;
		}
	}

	public  Connection getConnection() {

		return this.conn;
	}
	public  void closeConnection() throws Exception{
		try {
			conn.close();
		} catch (SQLException e) {
			throw e;
		}
	}
}
