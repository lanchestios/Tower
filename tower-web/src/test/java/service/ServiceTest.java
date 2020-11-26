package service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.tarot.tower.TowerApplication;
import org.tarot.tower.common.dao.CommodityMapper;
import org.tarot.tower.common.entity.Commodity;
import org.tarot.tower.service.impl.MyBatisTestServiceImpl;

import java.util.LinkedList;

import static org.mockito.Mockito.when;

/**
 * @package: service
 * @author: 王子豪
 * @date: 2020/11/24 21:43
 * @description: Service层单元测试
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = TowerApplication.class)
public class ServiceTest {

    @Mock
    private CommodityMapper mapper;
    @InjectMocks
    private MyBatisTestServiceImpl service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFunc() {
        when(mapper.selectAll()).thenReturn(new LinkedList<Commodity>() {
            {
                add(new Commodity(1L, "xiaomi1", 1000));
                add(new Commodity(2L, "xiaomi2", 1000));
            }
        });
        System.out.println(service.pagehelperTest(1,10));
    }

}
