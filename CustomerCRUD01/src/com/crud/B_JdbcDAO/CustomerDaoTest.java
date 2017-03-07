package com.crud.B_JdbcDAO;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import com.crud.entity.Customer;

public class CustomerDaoTest {

	CustomerDao customerDao = new CustomerDao();
	
	@Test
	public void testBatch() {
	}

	@Test
	public void testGetForValue() {
	}

	@Test
	public void testGetForList() {
		Connection connection = null;
		
		try {
			connection = JDBCTools.getConnection();
			String sql = "SELECT id, name,age ,gender, email"
			+" FROM customers";
			List<Customer> customers = customerDao.getForList(connection, sql, null);
			System.out.println(customers); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCTools.releaseDB(null, null, connection);
		}
	}

	@Test
	public void testGet() {
		Connection connection = null;
		
		try {
			connection = JDBCTools.getConnection();
			String sql = "SELECT id, name,age ,gender, email"
			+" FROM customers WHERE id = ?";
			Customer customer = customerDao.get(connection, sql, 5);
			System.out.println(customer); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCTools.releaseDB(null, null, connection);
		}
	}

	@Test
	public void testUpdate() {
	}

}
