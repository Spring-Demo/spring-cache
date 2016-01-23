package com.spring.cache.ordinary;

/**
 * @author 	Lian
 * @date	2016年1月23日 下午8:15:10
 * @desc	提供账号查询的服务类: 使用缓存管理器来支持账号查询缓存
 */
public class MyAccountService {
	private MyCacheManager<Account> cacheManager;

	/**
	 * 构造一个缓存管理器
	 */
	public MyAccountService() {
		cacheManager = new MyCacheManager<Account>();
	}

	public Account getAccountByName(String accountName) {
		// 首先查询缓存, 如果在缓存中, 则直接返回缓存的结果
		Account result = cacheManager.getValue(accountName);
		if (result != null) {
			System.out.println("get from cache : " + accountName);
			return result;
		}

		// 否则就到数据库中查询
		result = getFromDB(accountName);
		// 若结果不为null, 将数据库查询的结果更新到缓存中
		if (result != null) {
			cacheManager.addOrUpdateCache(accountName, result);
		}

		return result;
	}

	/**
	 * 模拟从数据库中查询数据
	 * @param accountName
	 * @return
	 */
	private Account getFromDB(String accountName) {
		System.out.println("simulate querying db..." + accountName);
		return new Account(accountName);
	}

	/**
	 * 清空缓存
	 */
	public void reload() {
		cacheManager.evictCache();
	}
}
