package org.tarot.tower.service.inter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.tarot.tower.common.entity.Shop;

import java.util.List;

/**
 * @package: org.tarot.tower.service.inter
 * @author: 王子豪
 * @date: 2020/11/18 13:32
 * @description: JpaTestController 对应的逻辑层接口类
 */
public interface JpaTestService {

    List<Shop> jpaDefaultQueryTest();

    Page<Shop> jpaDefaultQueryTest(PageRequest pr);

    Page<Shop> jpaFuzzyQueryTest(String searchText, Pageable pageable);
}
