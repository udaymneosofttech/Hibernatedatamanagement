package com.bigfm.com.BigFmDataManagement.hazelcast;


import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.query.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

;

@Component
public class CacheUtils {

   //@Autowired

   private HazelcastInstance instance;

    private IMap<Object, Object> hazelCastMap;

    public IMap<Object, Object> getMapInstance(CacheMap cacheMap) {

        return instance.getMap(cacheMap.getMapName());
    }

    public void put(Object key, Object value, CacheMap cacheMap) {

        hazelCastMap = getMapInstance(cacheMap);
        hazelCastMap.put(key, value);
    }

    public Object get(Object key, CacheMap cacheMap) {

        hazelCastMap = getMapInstance(cacheMap);
        return hazelCastMap.get(key);
    }

    public Set<Map.Entry<Object,Object>> getAll(CacheMap cacheMap) {

        hazelCastMap = getMapInstance(cacheMap);
        return hazelCastMap.entrySet();
    }

    public Boolean containsKey(Object key, CacheMap cacheMap) {

        hazelCastMap = getMapInstance(cacheMap);

        return hazelCastMap.containsKey(key);
    }

    public void evict(Object key, CacheMap cacheMap) {

        hazelCastMap = getMapInstance(cacheMap);

        hazelCastMap.evict(key);
    }

    public void evictAll(CacheMap cacheMap) {

        hazelCastMap = getMapInstance(cacheMap);

        hazelCastMap.evictAll();
    }

    public Collection<Object> getByPredicate(CacheMap cacheMap, Predicate predicate) {

        hazelCastMap = getMapInstance(cacheMap);

        return hazelCastMap.values(predicate);
    }

    public void putAll(Map<Object, Object> map, CacheMap cacheMap) {

        hazelCastMap = getMapInstance(cacheMap);

        hazelCastMap.putAll(map);
    }

}
