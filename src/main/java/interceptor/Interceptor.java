package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 **/
public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截成功");

        String username= (String) request.getSession().getAttribute("username");
        if (username==null){
            System.out.println("用户名不存在，请先登录");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
            return false;
        }
        return true;
    }
    }

