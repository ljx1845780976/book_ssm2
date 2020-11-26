package dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import pojo.Paper;

import java.util.List;

/**
 *
 **/
@Repository
public  interface  PaperDao {
    @Insert("insert into t_paper(name,author,price,sale,stock,img_path) value(#{name},#{author},#{price},#{sale},#{stock},#{img_path})")
    public int addPaper(Paper paper);

    @Delete("delete from t_paper where id=#{id}")
    public int deletePaperById(Integer id);

    @Update("update t_paper set name=#{name}, author=#{author}, price=#{price},sale=#{sale},stock=#{stock}, img_path=#{img_path} where id=#{id}")
    public int updatePaper(Paper paper);

    @Select("select id, name,author,price,sale,stock,img_path img_Path from t_paper where id=#{id}")
    public Paper queryPaperById(Integer id);

    @Select("select id, name,author,price,sale,stock,img_path img_Path from t_paper")
    public List<Paper> queryPapers();

    @Select("select count(*) from t_paper")
    public int queryForPageTotalCount();

    @Select("select id, name,author,price,sale,stock,img_path img_Path from t_paper limit #{begin},#{end}")
    public List<Paper> queryForItems(@Param("begin") int begin,@Param("end") int end);

    @Select("select count(*) from t_paper where price between #{min} and #{max} ")
    public int queryByPriceForPageTotalCount(@Param("min") double min, @Param("max") double max);

    @Select("select id, name,author,price,sale,stock,img_path img_Path from t_paper where price between #{min} and #{max} order by price limit #{begin},#{end}")
    public List<Paper> queryByPriceForItems(@Param("begin") int begin,@Param("end") int end,@Param("min") double min,@Param("max") double max);
}