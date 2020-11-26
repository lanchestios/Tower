package org.tarot.tower.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @package: org.tarot.tower.controller
 * @author: 王子豪
 * @date: 2020/11/23 21:18
 * @description: 共享Session测试类 -- 也就是多系统同时访问Redis
 * 生产上有更多的 Redis 进行主从、读写分离等配置。Nginx 的单点故障也是我们应用的障碍，
 * 可以使用 ZooKeeper 进行负载均衡。
 */
@RestController
@RequestMapping("/session")
public class SessionTestController {

    private static final Logger logger = LoggerFactory.getLogger(SessionTestController.class);

    @RequestMapping("/get")
    public SessionInfo getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SessionInfo info = new SessionInfo();
        info.id = session.getId();
        info.creationTime = session.getCreationTime();
        info.lastAccessedTime = session.getLastAccessedTime();
        info.maxInactiveInterval = session.getMaxInactiveInterval();
        info.isNew = session.isNew();
        return info;
    }

    class SessionInfo{
        String id = "";
        Long creationTime = 0L;
        Long lastAccessedTime = 0L;
        Integer maxInactiveInterval = 0;
        Boolean isNew = false;
    }
}
