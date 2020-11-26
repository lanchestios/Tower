package org.tarot.tower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tarot.tower.common.entity.Manager;
import org.tarot.tower.service.inter.CacheTestService;

import java.util.List;

/**
 * @package: org.tarot.tower.controller
 * @author: 王子豪
 * @date: 2020/11/23 18:39
 * @description: 测试Cache的使用(在使用Cache时需要在入口函数开启EnableCaching注解)
 *
 * Spring支持的常用CacheManager
 * SimpleCacheManager 使用简单的 Collection来存储缓存
 * ConcurrentMapCacheManager 使用 java.util.concurrent.ConcurrentHashMap实现的 Cache
 * NoOpCacheManager 仅测试用，不会实际存储缓存
 * EhCacheCacheManager 集成使用 EhCache 缓存技术。 EhCache是一个纯Java的进程内缓存框架，
 *                     具有快速、精干等特点，是 Hibernate中默认的 CacheProvider，
 *                     也是Java领域应用最为广泛的缓存
 * JCacheCacheManager 支持 JCache(JSR-107)标准的实现作为缓存技术，如 Apache Commons JCS
 * CaffeineCacheManager 使用 Caffeine作为缓存技术。Caffeine是使用 Java8 对 Guava 缓存的重写版本，
 *                      在 Spring boot2.0中将取代 Guava。如果出现 Caffeine, CaffeineCacheManager
 *                      将会自动配置。使用 spring.cache.cache-names 属性可以在启动时创建缓存
 * CompositeCacheManager 用于组合 CacheManager，即可以从多个 CacheManager 中轮询得到相应的缓存
 */
@RestController
@RequestMapping("/cache")
public class CacheTestController {

    @Autowired
    private CacheTestService cacheTestService;

    @RequestMapping("/findAll")
    List<Manager> findAll() {
        return cacheTestService.findAll();
    }

    @RequestMapping("/save")
    Manager save(Manager manager) {
        return cacheTestService.saveUser(manager);
    }

    @RequestMapping("/update")
    int update(Long id, String password) {
        return cacheTestService.updatePassword(id, password);
    }

    @RequestMapping("/findOne/{id}")
    Manager findOne(@PathVariable("id") Long id) {
        return cacheTestService.findOne(id);
    }
}
