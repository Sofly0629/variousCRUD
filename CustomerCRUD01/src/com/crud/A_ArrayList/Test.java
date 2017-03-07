package com.crud.A_ArrayList;

public class Test {

	public static void main(String[] args) {
		CRUDTool tool = new CRUDTool();
		System.out.println("-------- 查询(所有)操作 --------");
		tool.getForList();
		System.out.println("-------- 查询(单个)操作 --------");
		tool.get(2);
		System.out.println("-------- 添加操作(格式:AA-12-(0:female,1male)-AA@126.com --------");
		tool.save("DD-12-0-DD@126");
		tool.get(3);
		System.out.println("-------- 修改操作 --------");
		tool.update(3, "ZZ-12-0-ZZ@126");
		tool.get(3);
		tool.getForList();
		System.out.println("-------- 删除操作 --------");
		tool.delete(3);
		tool.getForList();
		
		
	}
}
