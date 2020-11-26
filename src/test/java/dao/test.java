package test;

import dao.UserDao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Cart;
import pojo.Paper;
import pojo.User;
import service.OrderService;
import service.PaperService;
import service.UserService;

import java.io.InputStream;

/**
 *
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class test {
    @Autowired
   private UserService userService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private OrderService orderService;
    @Test
    public void queryUserByUsername() throws Exception{
        paperService.addPaper(new Paper(null,"雾里看花","容祖儿",10.1,100,140,null));
    }

}