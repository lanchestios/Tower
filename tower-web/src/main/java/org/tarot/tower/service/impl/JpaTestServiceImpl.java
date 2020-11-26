package org.tarot.tower.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.tarot.tower.common.dao.ShopMapper;
import org.tarot.tower.common.entity.Shop;
import org.tarot.tower.service.inter.JpaTestService;

import java.util.List;

/**
 * @package: org.tarot.tower.service.impl
 * @author: 王子豪
 * @date: 2020/11/18 13:32
 * @description: JpaTestController 对应的逻辑层实现类
 */
@Service
public class JpaTestServiceImpl implements JpaTestService {
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public List<Shop> jpaDefaultQueryTest() {
        return shopMapper.findAll();
    }

    @Override
    public Page<Shop> jpaDefaultQueryTest(PageRequest pr) {
        return shopMapper.findAll(pr);
    }

    @Override
    public Page<Shop> jpaFuzzyQueryTest(String searchText, Pageable pageable) {
        return shopMapper.search(searchText, pageable);
    }
}
