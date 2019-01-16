package com.zl.util;

import java.io.Serializable;
import java.util.List;

/**
 * @program: FreeMarkeDemo
 * @description: 分页表格数据返回
 * @author: ZhuLlin
 * @create: 2019-01-02 15:31
 **/
public class AjaxResultPage<T> implements Serializable {

    //状态码
    private int code;

    //提示消息
    private String msg;

    //总条数
    private int count;

    //表格数据
    private List<T> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AjaxResultPage{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
