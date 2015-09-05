package com.luohj.privileges.core.cache;

public interface ICache {
	public Object get(String key);
	public void addOrUpdateCache(String key,Object value);
	public void evictCache(String key);
	public void evictCache();
}
