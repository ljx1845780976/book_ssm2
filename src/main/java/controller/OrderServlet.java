package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import pojo.Cart;
import service.OrderService;
import service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 **/
@Controller
@RequestMapping("orderServlet")
@SessionAttributes(value = "orderId")
public class OrderServlet  {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/createOrder")
    public String createOrder( ModelMap modelMap,@SessionAttribute ("cart") Cart cart,
                               @SessionAttribute("user_Id") int user_Id) throws ServletException, IOException {
        System.out.println(user_Id);
        String orderId = null;
            orderId = orderService.createOrder(cart, user_Id);
        modelMap.addAttribute("orderId",orderId);

         return "redirect:/pages/cart/checkout.jsp";
    }

    }
