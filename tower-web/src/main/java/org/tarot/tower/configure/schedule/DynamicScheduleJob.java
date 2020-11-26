package org.tarot.tower.configure.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;
import java.util.concurrent.Executors;

/**
 * @package: org.tarot.tower.configure.schedule
 * @author: 王子豪
 * @date: 2020/11/22 17:06
 * @description: 动态定时任务 任务开始时动态获取任务相关信息
 */
@Configuration
public class DynamicScheduleJob implements SchedulingConfigurer {

    class LogRunnable implements Runnable {

        @Override
        public void run() {
            System.out.printf("动态执行任务 线程: %s, 时间: %s%n",
                    Thread.currentThread(),
                    new Date());
        }
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        //配置多线程任务 -- 默认为单线程
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));

        taskRegistrar.addTriggerTask(
                //添加任务执行 Runnable
                new LogRunnable(),
                //设置执行周期
                triggerContext -> {
                    //数据库取得执行周期
                    String cron = "0 0/1 * * * ?";
                    //合法性校验
                    //返回执行周期
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                });
    }
}
