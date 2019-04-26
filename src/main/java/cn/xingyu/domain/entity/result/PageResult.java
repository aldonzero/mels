package cn.xingyu.domain.entity.result;

import java.util.List;

public class PageResult {
 private Integer total;
 private Integer pageSize;
 private Integer current;
 private Object list;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", pageSize=" + pageSize +
                ", current=" + current +
                ", list=" + list +
                '}';
    }
}
