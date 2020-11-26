package org.tarot.tower.service.inter;

import com.github.pagehelper.PageInfo;
import org.tarot.tower.common.entity.CommodityWithCate;
import org.tarot.tower.common.entity.Commodity;

import java.util.List;

/**
 * @package: org.tarot.tower.service.inter
 * @author: 王子豪
 * @date: 2020/11/17 13:19
 * @description: MyBatisTestController 对应的逻辑层接口类
 */
public interface MyBatisTestService {

    Commodity daoTest();

    List<Commodity> annotationSelectOnMapperTest();

    PageInfo<Commodity> pagehelperTest(int pageNo, int pageSize);

    List<CommodityWithCate> annotationManyOnMapperTest();

}
