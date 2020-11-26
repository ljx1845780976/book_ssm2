package service;

import pojo.Page;
import pojo.Paper;

import java.util.List;

/**
 *
 **/
public interface PaperService {

    public void addPaper(Paper paper);
    public void deletePaperById(Integer id);
    public void updatePaper(Paper paper);
    public Paper queryPaperById(Integer id);
    public List<Paper> queryPaper();

    Page<Paper> page(int pageNo, int pageSize) ;
    public Page<Paper> pageByPrice(int pageNo, int pageSize, double min, double max);

}
