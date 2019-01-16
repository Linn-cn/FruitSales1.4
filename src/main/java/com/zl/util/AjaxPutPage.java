package com.zl.util;

/**
 * @program: FreeMarkeDemo
 * @description: 分页查询[带条件]输入映射
 * @author: ZhuLlin
 * @create: 2019-01-03 11:40
 **/
public class AjaxPutPage<T> {

    Integer page;   //当前页码

    Integer limit;  //每页显示

    Integer start;  //从多少开始

    T condition;    //条件类

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
        this.start = (this.page - 1) * this.limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "AjaxPutPage{" +
                "page=" + page +
                ", limit=" + limit +
                ", start=" + start +
                ", condition=" + condition +
                '}';
    }
}
