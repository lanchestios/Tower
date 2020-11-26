package org.tarot.tower.common.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tarot.tower.common.entity.Manager;

/**
 * @package: org.tarot.tower.common.dao
 * @author: 王子豪
 * @date: 2020/11/23 18:15
 * @description:
 */
public interface ManagerMapper extends JpaRepository<Manager, Long> {

    @Query("update #{#entityName} a set a.password = :password where a.id = :id")
    Integer updatePassword(@Param("id") Long id, @Param("password") String password);
}
