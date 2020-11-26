package org.tarot.tower.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @package: org.tarot.tower.controller
 * @author: 王子豪
 * @date: 2020/11/23 21:44
 * @description: Redis测试类
 * 1. 在 pom 文件中配置依赖
 * <dependency>
 *     <groupId>org.springframework.boot</groupId>
 *     <artifactId>spring-boot-starter-data-redis</artifactId>
 * </dependency>
 * 2. 在 application.yml 中配置 spring.redis
 * #  redis: # redis配置 由RedisAutoConfiguration加载spring.redis属性
 * #    # 基础配置
 * #    host: localhost
 * #    password: 123456
 * #    port: 6379
 * #    timeout: 3000ms # 连接超时时间 单位 ms
 * #    # 线程池设置
 * #    jedis:
 * #      pool:
 * #        max-idle: 10 # 最大空闲连接 默认为8
 * #        min-idle: 5 # 最小空闲连接 默认为0
 * #        max-active: 10 # 线程池最大活跃数 默认为8(-1为不限制,如消耗完则pool的状态为exhausted(耗尽)
 * #        max-wait: 3000ms # 等待可用连接的最大时间，单位毫秒，默认值为-1ms，表示永不超时。
 * #                         # 如果超过等待时间，则直接抛出 JedisConnectionException。
 * #  # 配置Session在Redis中共享
 * #  # Session使用HttpSessionWrapper包装类实现
 * #  # 负责Session管理的适配器类是 HttpSessionAdapter
 * #  # RedisOperationsSessionRepository是采用Redis存储Session的核心业务逻辑实现
 * #  session:
 * #    store-type: redis # 配置将Session储存在redis中
 */
@RestController
@RequestMapping("/redis")
public class RedisTestController {

//    @Autowired
//    // StringRedisTemplate 继承了 RedisTemplate
//    // RedisTemplate是一个泛型类，而 StringRedisTemplate 则不是
//    // 它只能对 key = String, value = String的键值对进行操作，
//    // RedisTemplate 可以对任何类型的 key-value 键值对操作
//    private StringRedisTemplate template;
//
//    @RequestMapping(value = {"/save/{key}/{value}"}, method = RequestMethod.GET)
//    public void redisSave(@PathVariable("key") String key, @PathVariable("value") String value) {
//        template.opsForValue().set(key, value);
//    }
//
//    @RequestMapping(value = {"/get/{key}"}, method = RequestMethod.GET)
//    public String redisGet(@PathVariable("key") String key) {
//        return template.opsForValue().get(key);
//    }
//
//    @RequestMapping(value = {"/hashGet/{key}/{field}"}, method = RequestMethod.GET)
//    public String redisHashGet(@PathVariable("key") String key, @PathVariable("field") String field) {
//        return template.opsForHash().get(key, field).toString();
//    }
}
