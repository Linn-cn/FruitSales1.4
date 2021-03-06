package com.zl.util;

/**
 * @program: FruitSales
 * @description: 整个应用常量类
 * @author: ZhuLlin
 * @create: 2019-01-08 15:16
 **/
public class Constants {
    //密码
    public static final Integer HASHITERATIONS = 1024;
    public static final String PASSWORD = "000000";

    //权限等级
    public static final Integer ROLE_PEASANT = 1;
    public static final Integer ROLE_DEALER = 2;

    //合同状态
    public static final Integer CONTRACT_CONFIRM = 1;
    public static final Integer CONTRACT_CANCEL = 2;

    //异常错误提示
    public static final String ERROR_CODE = "999";
    public static final String ERROR_MSG = "通信异常,请及时联系系统管理员QQ:1320291471!";
    public static final String ERROR_DELETE = "存在合同，无法直接删除";

    //用户相关提示信息
    public static final Integer ERROR_COUNT_MAX = 5;
    public static final String ERROR_COUNT = "输入密码错误五次，锁定账号时长还剩";
    public static final String EMPTY_USER = "当前用户不存在。";
    public static final String ERROR_PASSWORD_BEFORE = "密码错误";
    public static final String ERROR_PASSWORD_AFTER = "次,五次将锁定账号一小时。";
    public static final String LOCK_USER = "当前用户已被锁定,请及时联系系统管理员QQ:1320291471!";
    public static final String SUCCESS_RESET_PASSWORD = "密码重置成功";
    public static final String SUCCESS_UPDATE_PASSWORD = "密码修改成功，请重新登录";
    public static final String ERROR_USERINFO = "信息填写错误";

    //系统相关信息
    public static final String SYSINFO = "SysInfo";
    public static final String SYSINFO_DEALER = "SysDealer";
    public static final String SYSINFO_GARDEN = "SysGarden";
    public static final String SYSINFO_CONTRACT = "SysContract";
    public static final String SYSINFO_PEASANT = "SysPeasant";
    public static final String SUCCESS_SYSINFO = "修改系统信息成功";
    public static final String SUCCESS_MESSAGE = "成功";

    //农民相关提示信息
    public static final String SUCCESS_UPDATE = "修改成功";
    public static final String SUCCESS_DELETE = "删除成功";
    public static final String SUCCESS_INSERT = "添加成功,默认密码为000000";
    public static final String ERROR_NUMBER = "不能超过剩余库存";
}
