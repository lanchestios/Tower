package org.tarot.tower.configure.executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @package: org.tarot.tower.configure.executor
 * @author: 王子豪
 * @date: 2020/11/22 18:40
 * @description: 线程池配置
 */
@Configuration
public class TaskExecutorPoolConfig {

    @Bean("executor")
    public Executor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //线程池维护线程最小数量
        executor.setCorePoolSize(10);
        //线程池维护线程最大数量
        executor.setMaxPoolSize(20);
        //拥塞队列长度
        executor.setQueueCapacity(100);
        //线程池维护线程所允许的空闲时间
        executor.setKeepAliveSeconds(30);
        //前缀
        executor.setThreadNamePrefix("TaskExecutorPool-");
        //拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
