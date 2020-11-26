package org.tarot.tower.service.impl;

import org.springframework.stereotype.Service;
import org.tarot.tower.service.inter.SpringBootTestService;

/**
 * @package: org.tarot.tower.service.impl
 * @author: 王子豪
 * @date: 2020/11/16 21:55
 * @description: SpringBootTestController 对应的逻辑层实现类
 */
@Service
public class SpringBootTestServiceImpl implements SpringBootTestService {
    public String getServiceInfo() {
        return "This is a test service by autowire";
    }
}
