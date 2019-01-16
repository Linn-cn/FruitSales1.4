package com.zl.util;

/**
 * @program: FruitSales
 * @description: 与前台通信类
 * @author: ZhuLlin
 * @create: 2019-01-07 23:10
 **/
public class MessageBean {

    // 是否成功
    private boolean success;
    // 返回消息
    private Object msg;
    // 其他对象
    private Object data;

    public MessageBean(Object data) {
        this.data = data;
    }

    public MessageBean(boolean success) {
        this.success = success;
    }

    public MessageBean(boolean success, Object msg) {
        this.success = success;
        this.msg = msg;
    }

    public MessageBean(boolean success, Object msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public Object getdata() {
        return data;
    }

    public void setdata(Object data) {
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

}
