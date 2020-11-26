package org.tarot.tower.service.inter;


import org.tarot.tower.common.entity.Manager;

import java.util.List;

/**
 * @package: org.tarot.tower.service.inter
 * @author: 王子豪
 * @date: 2020/11/23 18:13
 * @description: 缓存测试Service接口
 */
public interface CacheTestService {

    List<Manager> findAll();

    Manager saveUser(Manager manager);

    int updatePassword(Long id, String password);

    Manager findOne(Long id);
}
