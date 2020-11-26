package test;

import dao.OrderDao;
import dao.OrderItemDao;
import dao.PaperDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.Order;
import pojo.OrderItem;

import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.*;

/**
 *
 **/
public class OrderDaoTest {
    private InputStream is;
    private SqlSession sqlSession;
    private OrderItemDao orderDao;
    @Before //用于测试方法前执行
    public void init () throws Exception{
        is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        sqlSession = factory.openSession();
        orderDao = sqlSession.getMapper(OrderItemDao.class);}
    @After//用于测试方法后执行
    public void destroy () throws Exception{
        //6.释放资源
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }
    @Test
    public void saveOrder() {
        orderDao.saveOrderItem(new OrderItem(null,"lake_moon",1,20,40,"1"));
    }
}