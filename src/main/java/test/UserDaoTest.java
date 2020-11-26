//package test;
//
//import DAO.UserDao;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.Test;
//import pojo.User;
//
//import java.io.InputStream;
//
//import static org.junit.Assert.*;
//
///**
// *
// **/
//public class UserDaoTest {
//
//    @Test
//    public void queryUserByUsername() throws Exception{
//        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
//
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//
//        SqlSession sqlSession = factory.openSession();
//         UserDao userDao=sqlSession.getMapper(UserDao.class);
//        System.out.println( userDao.queryUserByUsername("wrosen"));
//    }
//
//}