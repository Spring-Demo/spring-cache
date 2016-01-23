package com.spring.cache.ordinary;

/**
 * @author 	Lian
 * @date	2016年1月23日 下午8:08:11
 * @desc	账号实体类
 */
public class Account {
	private int id;
	private String name;

	public Account(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
