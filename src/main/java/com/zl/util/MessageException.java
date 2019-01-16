package com.zl.util;

/**
 * @program: FruitSales
 * @classname: MessageException
 * @description: 全局异常
 * @author: 朱林
 * @create: 2019-01-16 22:29
 **/
public class MessageException extends RuntimeException{

    private static final long serialVersionUID = 1394818049620775426L;
    private String exceptionCode;
    private String exceptionMsg;

    public MessageException(){}

    public MessageException(String exceptionCode, String exceptionMsg) {
        super();
        this.exceptionCode = exceptionCode;
        this.exceptionMsg = exceptionMsg;
    }
    public String getExceptionCode() {
        return exceptionCode;
    }
    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
    public String getExceptionMsg() {
        return exceptionMsg;
    }
    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    @Override
    public String toString() {
        return "MessageException [exceptionCode=" + exceptionCode + ", exceptionMsg=" + exceptionMsg + "]";
    }

}
