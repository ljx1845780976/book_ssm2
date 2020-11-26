package test;

import dao.PaperDao;
import dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.Page;
import pojo.Paper;
import service.PaperService;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 **/
public class PaperDaoTest {
    private InputStream is;
    private SqlSession sqlSession;
    private  PaperDao paperDao;
    @Before //用于测试方法前执行
    public void init () throws Exception{
     is = Resources.getResourceAsStream("SqlMapConfig.xml");

    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

     sqlSession = factory.openSession();
    paperDao = sqlSession.getMapper(PaperDao.class);}
    @After//用于测试方法后执行
    public void destroy () throws Exception{
        //6.释放资源
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }
    @Test
    public void addPaper() {
    paperDao.addPaper(new Paper(null,"雾里看花","容祖儿",10.1,100,140,null));
    }

    @Test
    public void deletePaperById() {
        paperDao.deletePaperById(13);
    }

    @Test
    public void updatePaper() throws Exception{

        paperDao.updatePaper(new Paper(5,"Water","Nikey",90.0,150,13,"statics/img/seal.jpg"));

    }

    @Test
    public void queryPaperById() {

        System.out.println(paperDao.queryPaperById(3));
    }

    @Test
    public void queryPapers() {
        for(Paper p:paperDao.queryPapers()){
            System.out.println(p);
        }
    }
    @Test
    public void queryForPageTotalCount() {
        System.out.println(paperDao.queryForPageTotalCount());
    }
    @Test
    public void queryForItems(){
        List<Paper> list=paperDao.queryByPriceForItems(1,12,1d,100d);
        for (Paper p:list){
            System.out.println(p);
        }
    }
    @Test
    public  void page(){
        List<Paper> list= paperDao.queryForItems(1,4);
        for (Paper p:list){
            System.out.println(p);
        }
        System.out.println(paperDao.queryByPriceForPageTotalCount(1.2,100.3));
    }

}