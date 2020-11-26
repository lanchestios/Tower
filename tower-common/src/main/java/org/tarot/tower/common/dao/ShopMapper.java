package org.tarot.tower.common.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tarot.tower.common.entity.Shop;

/**
 * @package: org.tarot.tower.dao
 * @author: 王子豪
 * @date: 2020/11/18 13:26
 * @description:
 */
public interface ShopMapper extends JpaRepository<Shop,Long> {
    // 1.该注解可以写原生 SQL(设置 nativeQuery = true) 或 JPQL
    // 2.#{#entity} 代替实体SHOP名称#{# entity Name}，
    //   Spring Data JPA会自动根据 Category实体上对应的@Entity注解，
    //   自动将实体名称填入JPQL语句中。这帮助我们解决了项目中很多Dao接口的方法除了实体类名称不同，
    //   其他操作都相同的问题。
    @Query("select c from #{#entityName} c where c.shopName like %:searchText%")
    Page<Shop> search(@Param("searchText") String searchText, Pageable pageable);
}
