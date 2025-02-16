package com.yunussemree.redisexample.cache;

public interface ICacheService {
    void evictCacheValues(String cacheName);
}
