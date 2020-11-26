package pojo;

import java.util.List;

/** page 是分页模型对象
 *
 **/
public class Page<T> {
    public static final Integer PAGE_SIZE=4;
    // 当前页码
    private Integer pageNo;
    //总页码
    private Integer pageTotal;
    //当前显示数量
    private Integer pageSize=PAGE_SIZE;
    //总记录数
    private Integer pageTotalCount;
    //当前页数据
    private List<T> items;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                '}';
    }

    public void setPageNo(Integer pageNo) {

        this.pageNo = pageNo;
    }

    public void setPageTotal(Integer pageTotal) {

        this.pageTotal = pageTotal;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }
}
