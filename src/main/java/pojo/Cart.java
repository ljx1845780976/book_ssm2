package pojo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 **/
public class Cart {
//    private  Integer totalCount;
//    private  double totalPrice;
    // LinkedHashMap 能实现按插入的顺序输出
    private Map<Integer,CartItem> items=new LinkedHashMap<>();

    public void addItem(CartItem cartItem){
        //先查看购物车是否已添加，如果已添加，数量加1
        CartItem item=items.get(cartItem.getId());
        if (item==null){
            //说明之前没有添加
            items.put(cartItem.getId(),cartItem);
        }else {
            item.setCount(item.getCount()+1);
            item.setTotalPrice(item.getPrice()*item.getCount());
        }

    }
    //根据id删除商品
    public void deleteItem(Integer id){
        items.remove(id);
    }
    //清空购物车
    public void clear(){
        items.clear();
    }
    //修改商品数量
    public void updateItem( Integer id,Integer count){
      //先看是否有该商品
        CartItem cartItem=items.get(id);
        if(cartItem!=null){
            cartItem.setCount(count);
            cartItem.setTotalPrice((cartItem.getPrice()*count));
        }
    }



    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }


    public void setItems(Map<Integer,CartItem> items) {
        this.items = items;
    }

    public Integer getTotalCount() {
        Integer totalCount=0;
        for(CartItem cartItem:items.values()){
            totalCount+=cartItem.getCount();
        }
        return totalCount;
    }

    public double getTotalPrice() {
       double totalPrice=0;
        for(CartItem cartItem:items.values()){
            totalPrice+=cartItem.getTotalPrice();
        }
        return totalPrice;
    }

    public Map<Integer,CartItem> getItems() {
        return items;
    }

}
