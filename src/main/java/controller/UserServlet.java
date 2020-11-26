package controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;
import pojo.WebUtils;
import service.UserService;
import service.UserServiceimp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 *
 **/
@Controller
@RequestMapping("userServlet")
@SessionAttributes({"username","user_Id"} )
public class UserServlet   {
    @Autowired
    private UserService userService;
    @RequestMapping("/register")
    protected String register(HttpServletRequest req, HttpServletResponse resp,
    User user,String code,ModelMap model) throws ServletException, IOException {

            //2、检查验证码是否正确
        // 从验证码jar包获取验证码
        String kaptcha= (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 获取后马上在Session域中删除,防止因为回退后又注册或重复点击注册按钮 注册多个重复账户，
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
//            if(kaptcha!=null && kaptcha.equalsIgnoreCase(code)){
        if("5374".equalsIgnoreCase(code)){
                //正确,先判断是否存在用户名，如果存在，则重新输入，不存在则保存用户跳至登录界面
                if(userService.existsUsername(user.getUsername())){
                    System.out.println("用户名已存在，请重新输入");
                    model.addAttribute("msg","用户名已存在，请重新输入");
                    return "user/register";
                }
                else {
                    System.out.println("注册成功！");
                    userService.registerUser(user);
                     return  "user/login";

                }
            }else {
                //不正确，停留至本页
                System.out.println("验证码错误");
                model.addAttribute("code","验证码错误");
                model.addAttribute("username",user.getUsername());
                model.addAttribute("email",user.getEmail());
                return "user/register";
            }

    }
    @RequestMapping("/loginOut")
    protected String loginOut(SessionStatus sessionStatus) throws ServletException, IOException {
         sessionStatus.setComplete();
         return "client/ForestAtNight";
    }
        @RequestMapping("/login")
        protected String login(HttpServletRequest req, ModelMap model, User user, String code) throws ServletException, IOException {
        //2、检查验证码是否正确
            String kaptcha= (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
            // 获取后马上在Session域中删除,防止因为回退后又注册或重复点击注册按钮 注册多个重复账户，
            req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
            if("5374".equalsIgnoreCase(code)){
                //正确,先判断是否存在用户名，如果存在，则重新输入，不存在则保存用户跳至登录界面
                if(userService.existsUsername(user.getUsername())){
                    User login_user=userService.login(user);
                    if(login_user==null){
                        System.out.println("用户名或密码错误，请重新输入!");
                        model.addAttribute("msg","用户名或密码错误，请重新输入!");
                        return "user/login";
                    }else {
                        System.out.println("登录成功！");
                       model.addAttribute("username",user.getUsername());
                       model.addAttribute("user_Id",login_user.getId());

                        return "user/login_success";

                    }

                }
                else {
                    System.out.println("用户名或密码错误，请重新输入!");
                    model.addAttribute("msg","用户名或密码错误，请重新输入!");
                    return "/user/login";

                }
            }else {
                //不正确，停留至本页
                System.out.println("验证码错误");
                model.addAttribute("code","验证码错误");
                model.addAttribute("username",user.getUsername());
                return  "user/login";
            }

    }
    @RequestMapping("/ajaxExistUsername")
    protected @ResponseBody
    Map<String,Boolean> ajaxExistUsername(String username) throws ServletException, IOException {

        Map<String,Boolean> map=new HashMap<>();//将参数和判断参数是否存在的方法封装成map方便取出结果
        map.put("existUsername",userService.existsUsername(username));//放入结果
        //返回给客户端
        return  map;

    }
}
