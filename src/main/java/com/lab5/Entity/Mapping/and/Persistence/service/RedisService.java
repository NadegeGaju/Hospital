package com.lab5.Entity.Mapping.and.Persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setValue(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }
    public String getValue(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
    public void setHashValue(String hashKey, String field, String value) {
        stringRedisTemplate.opsForHash().put(hashKey, field, value);
    }
    public Map<Object, Object> getHashValues(String hashKey) {
        return stringRedisTemplate.opsForHash().entries(hashKey);
    }
    public void pushToList(String listKey, String value) {
        stringRedisTemplate.opsForList().leftPush(listKey, value);
    }
    public List<String> getList(String listKey) {
        return stringRedisTemplate.opsForList().range(listKey, 0, -1);
    }

    public void addToSet(String setKey, String... values) {
        stringRedisTemplate.opsForSet().add(setKey, values);
    }

    public Set<String> getSet(String setKey) {
        return stringRedisTemplate.opsForSet().members(setKey);
    }
    public void addToSortedSet(String sortedSetKey, String value, double score) {
        stringRedisTemplate.opsForZSet().add(sortedSetKey, value, score);
    }

    public Set<ZSetOperations.TypedTuple<String>> getSortedSet(String sortedSetKey) {
        return stringRedisTemplate.opsForZSet().rangeWithScores(sortedSetKey, 0, -1);
    }
}
