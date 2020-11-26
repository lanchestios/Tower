package org.tarot.tower.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tarot.tower.common.entity.CommodityWithCate;
import org.tarot.tower.common.dao.CommodityMapper;
import org.tarot.tower.common.entity.Commodity;
import org.tarot.tower.service.inter.MyBatisTestService;

import java.util.List;

/**
 * @package: org.tarot.tower.service.impl
 * @author: 王子豪
 * @date: 2020/11/17 13:19
 * @description: MyBatisTestController 对应的逻辑层实现类
 */
@Service
public class MyBatisTestServiceImpl implements MyBatisTestService {

    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public Commodity daoTest() {
        return commodityMapper.selectByPrimaryKey(1L);
    }

    @Override
    public List<Commodity> annotationSelectOnMapperTest() {
        return commodityMapper.selectAll();
    }

    @Override
    public PageInfo<Commodity> pagehelperTest(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Commodity> list = commodityMapper.selectAll();
        return new PageInfo<>(list);
    }

    @Override
    public List<CommodityWithCate> annotationManyOnMapperTest() {
        return commodityMapper.selectAllWithCate();
    }
}
