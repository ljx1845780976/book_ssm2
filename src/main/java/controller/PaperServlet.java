package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Page;
import pojo.Paper;
import pojo.WebUtils;
import service.PaperService;
import service.PaperServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 **/
@Controller
@RequestMapping("paperServlet")
public class PaperServlet  {

    @Autowired
    private PaperService paperService;

    @RequestMapping("/addPaper")
    public String addPaper(HttpServletRequest req) throws ServletException, IOException {
        int pageNo= WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo+=1;
        Paper paper = WebUtils.copyParamToBean(req.getParameterMap(), new Paper());
        paperService.addPaper(paper);
        //为什么用重定向？如果用请求转发每次刷新都会再次执行此Servlet页面 相当于执行一次addPaper方法
        return "redirect:/paperServlet/page?pageNo="+pageNo;
    }
    @RequestMapping("/list")
    public String list(ModelMap modelMap) throws ServletException, IOException {
        List<Paper> papers = paperService.queryPaper();
        modelMap.addAttribute("papers", papers);
         return "manager/manager";
    }
    @RequestMapping("/delete")
    public String delete(int id,int pageNo) throws ServletException, IOException {
        paperService.deletePaperById(id);
        return  "forward:/paperServlet/page?pageNo="+pageNo;
    }
    @RequestMapping("/show_init")
    public String show_init(int id,ModelMap modelMap) throws ServletException, IOException {
        Paper paper=paperService.queryPaperById(id);
        modelMap.addAttribute("paper",paper);
        return "manager/paper_update";
    }
    @RequestMapping("/update")
    public String update ( Paper paper,int pageNo) throws ServletException, IOException {
        paperService.updatePaper(paper);
        return "redirect:/paperServlet/page?pageNo="+pageNo;
    }
    @RequestMapping("/page")
    public String page (HttpServletRequest req,ModelMap modelMap) throws ServletException, IOException {
        //1 . 获取请求的参数pageNo 和 pageSize
        int pageNo=WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 . 调用PageService.page(pageNo,pageSize) 返回page对象
        Page<Paper> page= paperService.page(pageNo,pageSize);
        page.setUrl("paperServlet/page?");
        //3 . 保存page对象到Request域中
        modelMap.addAttribute("page",page);
        //4 . 请求转发到manager.jsp页面
        return "manager/manager"    ;
    }

    }