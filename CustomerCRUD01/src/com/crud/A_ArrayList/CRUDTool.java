package com.crud.A_ArrayList;

import java.util.ArrayList;
import java.util.List;

import com.crud.entity.Customer;

public class CRUDTool {

	private static List<Customer> customers = new ArrayList<>();

	static {
		customers.add(new Customer(0, "AA", 12, "male", "AA@126.com"));
		customers.add(new Customer(1, "BB", 12, "male", "BB@126.com"));
		customers.add(new Customer(2, "CC", 12, "male", "CC@126.com"));
	}

	public void getForList() {
		System.out.println(customers);
	}

	public void get(int id) {
		System.out.println(customers.get(id));
	}

	public void delete(int id) {
		customers.remove(id);
	}

	public void save(String cust) {
		String[] cts = cust.split("-");
		int id = customers.size();
		String gender = null;
		if ("0".equals(cts[2])) {
			gender = "female";
		}
		if ("1".equals(cts[2])) {
			gender = "male";
		}
		customers.add(new Customer(id, cts[0], Integer.parseInt(cts[1]), gender, cts[3]));
	}

	public void update(int id, String cust) {
		String[] cts = cust.split("-");
		String gender = null;
		if ("0".equals(cts[2])) {
			gender = "female";
		}
		if ("1".equals(cts[2])) {
			gender = "male";
		}
		customers.remove(id);
		customers.add(new Customer(id, cts[0], Integer.parseInt(cts[1]), gender, cts[3]));
	}

}
