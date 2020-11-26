package org.tarot.tower.common.entity;

import javax.persistence.*;

/**
 * @package: org.tarot.tower.common.entity
 * @author: 王子豪
 * @date: 2020/11/23 18:10
 * @description: JPA正向工程生成表
 */
@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 100)
    private String username;
    @Column(length = 100)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
