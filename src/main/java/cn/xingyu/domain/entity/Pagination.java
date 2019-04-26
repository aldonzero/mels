package cn.xingyu.domain.entity;

public class Pagination<T> {
    private Integer pageSize;
    private Integer page;
    private String orderBy;
    private String sort = "ASC";
    private T t ;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "pageSize=" + pageSize +
                ", page=" + page +
                ", orderBy='" + orderBy + '\'' +
                ", sort='" + sort + '\'' +
                ", t=" + t +
                '}';
    }
}
