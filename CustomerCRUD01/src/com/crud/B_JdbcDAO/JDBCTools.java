package com.crud.B_JdbcDAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JDBC 的工具类
 * 
 * 其中包含: 获取数据库连接, 关闭数据库资源等方法.
 */
public class JDBCTools {
	
	private static DataSource dataSource = null;

	//数据库连接池应只被初始化一次. 
	static{
		dataSource = new ComboPooledDataSource("helloc3p0");
	}
	
	public static Connection getConnection() throws Exception {
		return dataSource.getConnection();
	}

	public static void releaseDB(ResultSet resultSet, Statement statement,
			Connection connection) {

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				//数据库连接池的 Connection 对象进行 close 时
				//并不是真的进行关闭, 而是把该数据库连接会归还到数据库连接池中. 
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

