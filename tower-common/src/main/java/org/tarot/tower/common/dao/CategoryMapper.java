package org.tarot.tower.common.dao;

import org.apache.ibatis.annotations.Select;
import org.tarot.tower.common.entity.Category;

public interface CategoryMapper {

    @Select("SELECT * FROM category WHERE commodity_id = #{commodityId}")
    Category selectByCommodityId(Long commodityId);

}