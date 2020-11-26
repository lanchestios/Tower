package org.tarot.tower.common.dao;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.tarot.tower.common.entity.Commodity;
import org.tarot.tower.common.entity.CommodityWithCate;

import java.util.List;

public interface CommodityMapper {

    Commodity selectByPrimaryKey(Long commodityId);

    @Select("SELECT * FROM commodity")
    List<Commodity> selectAll();

    @Results({
            @Result(id = true, column = "commodity_id", property = "commodityId"),
            @Result(column = "commodity_id",
                    property = "categories",
                    many = @Many(
                            select = "org.tarot.tower.dao.CategoryMapper.selectByCommodityId",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    // @Many注解 将其他表以 column 对应字段通过 Mapper 连接到该表当中
    // 对于 @Result 注解，如果查询结果有 A 字段， 并且 ENTITY 有对应的字段，不做单独规定也可自动注入
    // 该例没有在@Result规定 commodity_name 但返回结果中拥有该字段
    @Select("SELECT * FROM commodity")
    List<CommodityWithCate> selectAllWithCate();

}