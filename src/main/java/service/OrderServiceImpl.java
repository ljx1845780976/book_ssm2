package service;

import dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Cart;
import pojo.CartItem;
import pojo.OrderItem;
import pojo.Paper;
import pojo.Order;
import java.util.Date;

/**
 *
 **/
@Service("orderService")
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private PaperDao paperDao;

    @Override
    public String createOrder(Cart cart, Integer userId) {
        //订单号==唯一性
        String orderId=System.currentTimeMillis()+""+userId;
        //创建订单对象
        Order order=new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        // 保存订单
         orderDao.saveOrder(order);
         // 遍历收藏栏中的每一项转换成订单项
        for(CartItem cartItem:cart.getItems().values()){
            orderItemDao.saveOrderItem(new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId));
            //每转换一项，下载量加1
            Paper paper=paperDao.queryPaperById(cartItem.getId());
            paper.setStock(paper.getStock()+cartItem.getCount());
            paperDao.updatePaper(paper);
        }
        //买完清空收藏栏
        cart.clear();
        return orderId;
    }

}
