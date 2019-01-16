package com.zl.util;

/**
 * @program: FruitSales
 * @description: 整个应用常量类
 * @author: ZhuLlin
 * @create: 2019-01-08 15:16
 **/
public class Constants {
    //密码加密次数
    public static final Integer HASHITERATIONS = 1024;

    //异常错误提示
    public static final String ERROR_MSG = "通信异常,请及时联系系统管理员QQ:1320291471!";

    //用户相关提示信息
/*    public static final String OLDPASSWORD = "oldPassword";*/
    public static final String EMPTY_USER = "当前用户不存在。";
    public static final String ERROR_PASSWORD = "密码错误。";
    public static final String LOCK_USER = "当前用户已被锁定,请及时联系系统管理员QQ:1320291471!";
    public static final String SUCCESS_RESET_PASSWORD = "密码重置成功";
    public static final String SUCCESS_UPDATE_PASSWORD = "密码修改成功，请重新登录";
    public static final String ERROR_USERINFO = "信息填写错误";

    //系统相关信息
    public static final String SYSINFO = "SysInfo";
    public static final String SUCCESS_SYSINFO = "修改系统信息成功";
    public static final String SUCCESS_MESSAGE = "成功";
}
