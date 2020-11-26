package org.tarot.tower.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @package: org.tarot.tower.controller
 * @author: 王子豪
 * @date: 2020/11/24 12:40
 * @description: Log测试
 */
@RestController
@RequestMapping("/log")
public class LogTestController {

    private static final Logger logger = LoggerFactory.getLogger(LogTestController.class);

    @GetMapping("/log")
    public String log() {
        String level = "";
        if (logger.isTraceEnabled()) {
            logger.trace("5-Trace");
            level += "5-Trace ";
        }

        if (logger.isDebugEnabled()) {
            logger.debug("4-Debug");
            level += "4-Debug ";
        }

        if (logger.isInfoEnabled()) {
            logger.info("3-Info");
            level += "3-Info";
        }

        if (logger.isWarnEnabled()) {
            logger.warn("2-Warn");
            level += "2-Warn";
        }

        if (logger.isErrorEnabled()) {
            logger.error("1-Error");
            level += "1-Error";
        }
        return level;
    }


}
