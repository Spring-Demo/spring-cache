package com.spring.cache.ordinary;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 	Lian
 * @date	2016年1月23日 下午8:09:31
 * @desc	自定义缓存管理器: 负责实现缓存逻辑, 支持对象的增加.修改和删除, 支持对象的泛型.
 */
public class MyCacheManager<T> {
	private Map<String, T> cache = new ConcurrentHashMap<String, T>();

	/**
	 * 得到缓存的对象
	 * @param key
	 * @return
	 */
	public T getValue(Object key) {
		return cache.get(key);
	}

	/**
	 * 添加或更新缓存
	 * @param key
	 * @param value
	 */
	public void addOrUpdateCache(String key, T value) {
		cache.put(key, value);
	}

	/**
	 * 根据key来删除缓存中的一条记录
	 * @param key
	 */
	public void evictCache(String key) {
		if(cache.containsKey(key)) {
			cache.remove(key);
		}
	}

	/**
	 * 清空缓存中的所有记录
	 */
	public void evictCache() {
		cache.clear();
	}
}
