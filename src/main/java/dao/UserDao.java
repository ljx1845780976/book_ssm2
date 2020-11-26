package dao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import pojo.User;

/**
 *
 **/
@Repository
public interface UserDao {
    /**
     *  根据用户名查询用户信息
     * @param name
     * @return  返回null ，则说明没有该用户
     */
    @Select("select id,username,password,email from t_user where username=#{username}")
    public User queryUserByUsername(String name);
    //根据用户名和密码查询用户信息
    @Select("select id,username,password,email from t_user where username=#{username} and password=#{password}")
    public User queryUserByUsernameAndPassword(@Param("username") String name,@Param("password") String password);
    //保存用户信息
    @Insert("insert into t_user(username,password,email) values(#{username},#{password},#{email})")
    public int saveUser(User user);

}
