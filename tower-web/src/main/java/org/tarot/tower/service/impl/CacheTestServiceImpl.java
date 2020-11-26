package org.tarot.tower.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarot.tower.common.dao.ManagerMapper;
import org.tarot.tower.common.entity.Manager;
import org.tarot.tower.service.inter.CacheTestService;

import java.util.List;
import java.util.Optional;

/**
 * @package: org.tarot.tower.service.impl
 * @author: 王子豪
 * @date: 2020/11/23 18:30
 * @description: 缓存测试Service实现类
 *
 * - Cacheable -- 主要针对方法配置，根据方法的请求参数对其结果进行缓存。
 *      - value：缓存名 必填
 *      - key：可选属性，可以使用SPEL标签自定义缓存的key
 *      - condition：属性指定发生的条件
 * - CachePut -- 主要针对方法配置，根据方法的请求参数对其结果进行缓存
 *               和 Cacheable 不同的是，每次都会触发真实方法的调用。
 *      - value：缓存名，必填
 *      - key：可选属性，可以使用SPEL标签自定义缓存的key
 * - CacheEvict -— 主要针对方法配置，能够根据一定的条件对缓存进行清空。
 *      - value：必填
 *      - key：可选（默认是所有参数的组合）
 *      - condition：缓存的条件
 *      - allEntries：是否清空所有缓存内容，默认为 false。如果指定为true，则方法调用后将立即清空所有缓存。
 *      - beforeInvocation：是否在方法执行前就清空，默认为 false。如果指定为true，则在方法还没有执行的时候就清空缓存。默认情况下，如果方法执行抛出异常，则不会清空缓存。
 * - Caching -- 用来组合使用其他注解，可以同时应用多个 Cache注解。
 *      例：@Caching(evict={ @CacheEvict("u1"), @CacheEvict("u2",allEntries=true) })
 */
@Service
public class CacheTestServiceImpl implements CacheTestService {

    @Autowired
    private ManagerMapper managerMapper;

    //标识读缓存操作
    @Cacheable("userList")
    @Override
    public List<Manager> findAll() {
        return managerMapper.findAll();
    }

    //写入缓存, key为 user.id, 一般可以标注在save方法上面
    @Transactional
    @CachePut(cacheNames = {"user"}, key = "#manager.id")
    @Override
    public Manager saveUser(Manager manager) {
        return managerMapper.save(manager);
    }

    //根据key（值为id）来清除缓存；一般标注在 delete, update方法上面
    @Transactional
    @CacheEvict(cacheNames = {"user"}, key = "#id")
    @Override
    public int updatePassword(Long id, String password) {
        return managerMapper.updatePassword(id, password);
    }

    //如果缓存存在，直接读取，否则调用方法
    @Cacheable(cacheNames = {"user"}, key = "#id")
    @Override
    public Manager findOne(Long id) {
        return managerMapper.findById(id).get();
    }
}
