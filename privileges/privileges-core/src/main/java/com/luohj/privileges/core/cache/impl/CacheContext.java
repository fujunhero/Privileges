package com.luohj.privileges.core.cache.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.luohj.privileges.core.cache.ICache;

@Service
public class CacheContext implements ICache {
	private Map<String, Object> cache = Maps.newConcurrentMap();
	
    /**
     * 获取缓存
     * @param key
     * @return
     */
    @Override
    public Object get(String key){
        return cache.get(key);
    }

    /**
     * 添加或更新缓存
     * @param key
     * @param value
     */
    public void addOrUpdateCache(String key,Object value) {
        cache.put(key, value);
    }

    /**
     * 根据 key 来删除缓存中的一条记录
     * @param key
     */
    @Override
    public void evictCache(String key) {
        if(cache.containsKey(key)) {
            cache.remove(key);
        }
    }

    /**
     * 清空缓存中的所有记录
     */
    @Override
    public void evictCache() {
        cache.clear();
    }

}
