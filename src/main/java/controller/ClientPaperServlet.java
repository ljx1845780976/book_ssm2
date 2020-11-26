package controller;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.Page;
import pojo.Paper;
import pojo.WebUtils;
import service.PaperService;
import service.PaperServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 **/
@Controller
@RequestMapping("clientPaperServlet")
public class ClientPaperServlet{

    @Autowired
    private PaperService paperService;
    @RequestMapping("/page")
    public ModelAndView page (HttpServletRequest req,ModelAndView mv) throws ServletException, IOException {
        //1 . 获取请求的参数pageNo 和 pageSize
        int pageNo= WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 . 调用PageService.page(pageNo,pageSize) 返回page对象
        Page<Paper> page= paperService.page(pageNo,pageSize);
        page.setUrl("clientPaperServlet/page?");

        //3 . 保存page对象到Request域中
        mv.addObject("page",page);
    //    4 . 请求转发到manager.jsp页面
        mv.setViewName("user/home");
        return mv;
    }
    @RequestMapping("/pageByPrice")
    public String pageByPrice (HttpServletRequest req, ModelMap modelMap) throws ServletException, IOException {
        //1 . 获取请求的参数pageNo，pageSize，min，max
        int pageNo= WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        double min=WebUtils.parseDouble(req.getParameter("min"),0);
        double max=WebUtils.parseDouble(req.getParameter("max"), Double.MAX_VALUE);
        //2 . 调用PageService.page(pageNo,pageSize) 返回page对象
        Page<Paper> page= paperService.pageByPrice(pageNo,pageSize,min,max);
        if (page==null){
            return "redirect:/pages/user/home.jsp";
        }
        // 追加min 和 max参数到地址栏中
        StringBuilder sb=new StringBuilder("clientPaperServlet/pageByPrice");
        if(req.getParameter("min")!=null){
            sb.append("?min=").append(req.getParameter("min"));
        }
        if(req.getParameter("max")!=null){
            sb.append("&max=").append(req.getParameter("max")).append("&");
        }
        page.setUrl(sb.toString());

        //3 . 保存page对象到Request域中
        modelMap.addAttribute("page",page);
        //4 . 请求转发到manager.jsp页面
        return   "user/home";
    }
}
