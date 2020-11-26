package org.tarot.tower.configure.executor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @package: org.tarot.tower.configure.executor
 * @author: 王子豪
 * @date: 2020/11/23 9:42
 * @description:
 * 异步执行函数，在Test中测试
 * 注意：由于异步实现由AOP实现，必须用注入的方式，如果在同一个类中实现任务和测试，则依旧为同步运行
 */
@Component
public class Task {
    @Async("executor")
    public Future<String> doTaskA() throws InterruptedException {
        System.out.println("开始任务A");
        Thread.sleep(1000);
        System.out.println("结束任务A");
        return new AsyncResult<>("TASK A");
    }

    @Async("executor")
    public Future<String> doTaskB() throws InterruptedException {
        System.out.println("开始任务B");
        Thread.sleep(2000);
        System.out.println("结束任务B");
        return new AsyncResult<>("TASK B");
    }

    @Async("executor")
    public Future<String> doTaskC() throws InterruptedException {
        System.out.println("开始任务C");
        Thread.sleep(3000);
        System.out.println("结束任务C");
        return new AsyncResult<>("TASK C");
    }
}
