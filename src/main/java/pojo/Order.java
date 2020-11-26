package pojo;

import java.util.Date;

/**
 *
 **/
public class Order {
    private  String orderId;
    private Date createTime;
    private  double price;
    //0未发货 1已发货 2已签收
    private  Integer status=0;
    private  Integer userId;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public double getPrice() {
        return price;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getUserId() {
        return userId;
    }

    public Order(String orderId, Date createTime, double price, Integer status, Integer userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    public Order() {
    }
}
