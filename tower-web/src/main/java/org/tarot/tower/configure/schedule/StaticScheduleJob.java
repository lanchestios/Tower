package org.tarot.tower.configure.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @package: org.tarot.tower.configure.schedule
 * @author: 王子豪
 * @date: 2020/11/22 16:20
 * @description:
 * 静态定时任务配置(使用 Spring 框架自带的 Schedule 模块)
 * 使用时需要在 SpringBoot 启动类上添加 @EnableScheduling 注解
 *
 * Cron 表达式(了解）
 *
 * second           0-59
 * minute           0-59
 * hour             0-23
 * day of month     1-31
 * month            0-11 或 月份英文缩写
 * day of week      1-7 或 周一至周末英文缩写
 *
 * '/' 每隔               例如 0 0/2 * * * ? 中 0/1 代表 每 2 分钟的 0 秒 执行该任务
 * '?' 某一天 只能在日和星期周使用,作用为不指定
 * 'L' 每月或每周的最后一天  例如 0 0 0 L * ? * 表示本月最后一天
 * 'W' 表示最近的工作日     例如 0 0 0 15W ? ? * 每月15日最近的工作日
 * '#' A#B 表示每月第A周的星期B
 */
@Component
public class StaticScheduleJob {

    /**
     * 静态定时任务
     * fixedRate 从上一次开始执行的时间点后 x 毫秒
     * fixedDelay 从上一次执行完毕时间点后 x 毫秒
     * cron 按照 cron 表达式执行
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void jobEveryMinutes() {
        System.out.println("执行任务（每分钟）：" + new Date());
    }
}
