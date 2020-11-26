package service;

import dao.PaperDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Page;
import pojo.Paper;

import java.util.List;

/**
 *
 **/
@Service("paperService")
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperDao paperDao;
    @Override
    public void addPaper(Paper paper) {
        paperDao.addPaper(paper);
    }

    @Override
    public void deletePaperById(Integer id) {
        paperDao.deletePaperById(id);
    }

    @Override
    public void updatePaper(Paper paper) {
        paperDao.updatePaper(paper);
    }

    @Override
    public Paper queryPaperById(Integer id) {
        return paperDao.queryPaperById(id);
    }

    @Override
    public List<Paper> queryPaper() {
        return paperDao.queryPapers();
    }

    @Override
    public Page<Paper> page(int pageNo, int pageSize) {
        Page<Paper> page = new Page<Paper>();
         //1.设置当前页面
        //2.设置每页显示的数量
        page.setPageSize(pageSize);
        //3.1求总记录数
        Integer pageTotalCount=paperDao.queryForPageTotalCount();
        //3.2设置总的记录数
        page.setPageTotalCount(pageTotalCount);
        //4.1求总页码 = 总记录数/每页显示的数量 ，如果有余数页码加1
        Integer pageTotal=pageTotalCount / pageSize;
        if (pageTotalCount % pageSize >0){
            pageTotal+=1;
        }
        //4.2设置总页码
        page.setPageTotal(pageTotal);
        if(pageNo<=0){
            pageNo=1;
        }else if(pageNo>pageTotal){
            pageNo=pageTotal;
        }
        page.setPageNo(pageNo);

        //5.返回bean对象
        int begin=(pageNo-1)*pageSize;
        int end=pageSize;
        List<Paper> items=paperDao.queryForItems(begin,end);
        page.setItems(items);
       return page;
    }
    public Page<Paper> pageByPrice(int pageNo, int pageSize,double min,double max){
        Page<Paper> page = new Page<Paper>();
        page.setPageSize(pageSize);
        //3.1求总记录数
        Integer pageTotalCount=paperDao.queryByPriceForPageTotalCount(min,max);
        if (pageTotalCount==0){
            return null;
        }
        //3.2设置总的记录数
        page.setPageTotalCount(pageTotalCount);
        //4.1求总页码 = 总记录数/每页显示的数量 ，如果有余数页码加1
        Integer pageTotal=pageTotalCount / pageSize;
        if (pageTotalCount % pageSize >0){
            pageTotal+=1;
        }
        //4.2设置总页码
        page.setPageTotal(pageTotal);
        if(pageNo<=0){
            pageNo=1;
        }else if(pageNo>pageTotal){
            pageNo=pageTotal;
        }
        page.setPageNo(pageNo);

        //5.返回bean对象
        int begin=(pageNo-1)*pageSize;
        int end=pageSize;
        List<Paper> items=paperDao.queryByPriceForItems(begin,end,min,max);
        page.setItems(items);
        return page;
    }
}
