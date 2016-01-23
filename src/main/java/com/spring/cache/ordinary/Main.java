package com.spring.cache.ordinary;

/**
 * @author 	Lian
 * @date	2016年1月23日 下午8:24:31
 * @desc	测试类, 测试我们的缓存是否有效
 */
public class Main {
	public static void main(String[] args) {
		MyAccountService service = new MyAccountService();

		// 开始查询账号
		service.getAccountByName("lian");	// 第一次查询, 应该是从数据库中查询
		service.getAccountByName("lian");	// 第二次查询, 应该是从缓存中返回

		// 重置缓存
		service.reload();
		System.out.println("after reload...");

		service.getAccountByName("lian");	// 第一次查询, 应该是从数据库中查询
		service.getAccountByName("lian");	// 第二次查询, 应该是从缓存中返回
	}
}
