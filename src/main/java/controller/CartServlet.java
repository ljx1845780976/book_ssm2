package controller;

import dao.PaperDao;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import pojo.Cart;
import pojo.CartItem;
import pojo.Paper;
import pojo.WebUtils;
import service.PaperService;
import service.PaperServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 **/
@Controller
@RequestMapping("cartServlet")
@SessionAttributes({"cart","lastItem"})
public class CartServlet {
    @Autowired
    private PaperService paperService;
    @Autowired
    private PaperDao paperDao;
    @RequestMapping("/addItem")
    public @ResponseBody Map<String,Object> addItem(ModelMap modelMap, int id) throws ServletException, IOException {
        Paper paper = paperService.queryPaperById(id);
        //每次点击收藏，更新该收藏量加1
         paper.setSale(paper.getSale()+1);

         paperDao.updatePaper(paper);
        Cart cart = (Cart) modelMap.get("cart");
        if (cart == null) {
            cart = new Cart();
            modelMap.addAttribute("cart", cart);
        }
        cart.addItem(new CartItem(paper.getId(), paper.getName(), 1, paper.getPrice(), paper.getPrice()));


        //最后一个添加的名称
        modelMap.addAttribute("lastItem",paper.getName());
        //使用ajax显示不必重定向
        Map<String,Object> map=new HashMap<>();
        map.put("lastItem",paper.getName());
       return map;
//        //在Http协议中有一个请求头叫Referer，它可以它可以把请求发起时，浏览器的地址栏地址发给服务器
//        String referer = req.getHeader("Referer");
//        if ("http://localhost:8080/book_war_exploded/userServlet".equals(referer)) {
//            referer = "http://localhost:8080/book_war_exploded/client/paperServlet?action=page&pageNo=1";
//        }
//        resp.sendRedirect(referer);

    }
        @RequestMapping("/deleteItem")
        public String deleteItem(int id, ModelMap modelMap, @RequestHeader(value = "Referer") String referer ) throws ServletException, IOException {
        Cart cart = (Cart) modelMap.get("cart");
        if(cart!=null) {
            cart.deleteItem(id);
            return  "redirect:"+referer;
        }return null;

    }
    @RequestMapping("/clear")
    public String clear(ModelMap modelMap ,@RequestHeader(value = "Referer") String referer) throws ServletException, IOException {
        Cart cart = (Cart)modelMap.get("cart");
        if (cart!=null){
            cart.clear();
            return  "redirect:"+referer;

        }return null;
    }
    @RequestMapping("/update")
    public String update(int id, int count,ModelMap modelMap,@RequestHeader(value = "Referer") String referer) throws ServletException, IOException {
        Cart cart = (Cart) modelMap.get("cart");
        if (cart!=null){
            cart.updateItem(id,count);
            return  "redirect:"+referer;

        }return null;
    }

 }