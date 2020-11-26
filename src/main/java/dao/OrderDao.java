package dao;

import com.mysql.cj.xdevapi.Column;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.springframework.stereotype.Repository;
import pojo.Order;

/**
 *
 **/
@Repository
public interface OrderDao {
    @Insert("insert into t_order(order_id,create_time,price,status,user_id) values(#{orderId},#{createTime},#{price},#{status},#{userId})")
      int saveOrder(Order order);
}
