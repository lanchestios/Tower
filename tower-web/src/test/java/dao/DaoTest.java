package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tarot.tower.TowerApplication;
import org.tarot.tower.common.dao.CommodityMapper;

/**
 * @package: dao
 * @author: 王子豪
 * @date: 2020/11/24 21:40
 * @description: Dao层单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TowerApplication.class)
public class DaoTest {

    @Autowired
    private CommodityMapper mapper;

    @Test
    public void main(){
        System.out.println(mapper.selectAll());
    }

}
