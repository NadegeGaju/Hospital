package com.lab5.Entity.Mapping.and.Persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class CacheController {

    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/cache")
    public String getCacheInfo(@RequestParam String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            return "Cache not found";
        }

        // Assuming the native cache supports Iterable<Map.Entry>
        Object nativeCache = cache.getNativeCache();
        if (nativeCache instanceof Map) {
            Map<Object, Object> mapCache = (Map<Object, Object>) nativeCache;
            return mapCache.entrySet().stream()
                    .map(entry -> entry.getKey() + " -> " + entry.getValue())
                    .collect(Collectors.joining("\n"));
        }

        // Fallback or handle other types of native cache
        return "Cache type not supported for inspection";
    }
}
