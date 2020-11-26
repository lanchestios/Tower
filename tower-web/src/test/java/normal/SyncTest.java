package normal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tarot.tower.TowerApplication;

/**
 * @package: PACKAGE_NAME
 * @author: 王子豪
 * @date: 2020/11/22 18:02
 * @description: 程序同步执行测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TowerApplication.class)
public class SyncTest {

    @Test
    public void syncTask() throws InterruptedException {
        System.out.println("开始测试");
        doTaskA();
        doTaskB();
        doTaskC();
        System.out.println("结束测试");
    }

    public void doTaskA() throws InterruptedException {
        System.out.println("开始任务A");
        Thread.sleep(1000);
        System.out.println("结束任务A");
    }

    public void doTaskB() throws InterruptedException {
        System.out.println("开始任务B");
        Thread.sleep(2000);
        System.out.println("结束任务B");
    }

    public void doTaskC() throws InterruptedException {
        System.out.println("开始任务C");
        Thread.sleep(3000);
    }
}
