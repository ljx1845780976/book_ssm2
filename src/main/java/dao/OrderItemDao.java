package dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import pojo.OrderItem;

/**
 *
 **/
@Repository
public interface OrderItemDao {
    @Insert("insert into t_order_item(name,count,price, total_price,order_id) values(#{name},#{count},#{price},#{totalPrice},#{orderId})")
    public int saveOrderItem(OrderItem orderItem);
}
