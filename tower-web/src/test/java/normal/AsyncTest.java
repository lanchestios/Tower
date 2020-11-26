package normal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tarot.tower.TowerApplication;
import org.tarot.tower.configure.executor.Task;

/**
 * @package: PACKAGE_NAME
 * @author: 王子豪
 * @date: 2020/11/22 18:32
 * @description: 程序异步执行测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TowerApplication.class)
public class AsyncTest {

    @Autowired
    private Task task;

    @Test
    public void asyncTask() throws InterruptedException {
        System.out.println("开始测试");
        task.doTaskA();
        task.doTaskB();
        task.doTaskC();
        Thread.sleep(3000);
        System.out.println("结束测试");
    }
}
