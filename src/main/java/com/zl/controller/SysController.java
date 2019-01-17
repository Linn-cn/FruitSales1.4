package com.zl.controller;

import com.zl.aop.SystemControllerLog;
import com.zl.pojo.LogDO;
import com.zl.pojo.SysDO;
import com.zl.service.LogService;
import com.zl.service.SysService;
import com.zl.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @program: FruitSales
 * @description: 系统管理控制类
 * @author: ZhuLlin
 * @create: 2019-01-08 18:44
 **/
@Controller
@RequestMapping("/sys")
public class SysController {

    @Autowired
    private SysService sysService;

    @Autowired
    private LogService logService;

    /** 
    * @Description: 显示欢迎界面
    * @Param: [model]
    * @return: java.lang.String 
    * @Author: ZhuLin
    * @Date: 2019/1/8 
    */
    @RequestMapping("/welcome")
    public String gotoWelcome(HttpSession session){
        SysDO sysDO = sysService.getSysInfo();
        System.out.println("系统参数:" + sysDO.toString());
        session.setAttribute(Constants.SYSINFO,sysDO);
        return "redirect:/welcome.jsp";
    }

    /**
     * @Description: 跳转系统信息修改界面
     * @Param: [model]
     * @return: java.lang.String
     * @Author: ZhuLin
     * @Date: 2019/1/8
     */
    @RequestMapping("/gotoUpdateSysInfo")
    public String gotoUpdateSysInfo(){
        return "admin/sysParameter";
    }

    /**
     * @Description: 返回系统信息
     * @Param: [model]
     * @return: java.lang.String
     * @Author: ZhuLin
     * @Date: 2019/1/8
     */
    @RequestMapping("/getSysInfo")
    @ResponseBody
    public SysDO getSysInfo(){
        SysDO sysDO = sysService.getSysInfo();
        return sysDO;
    }

    /** 
    * @Description: 修改系统信息
    * @Param: [sysDO] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/8 
    */
    @SystemControllerLog(description = "修改系统信息")
    @RequestMapping("/updateSysInfo")
    @ResponseBody
    public MessageBean updateSysInfo(SysDO sysDO) throws Exception{
        System.out.println(sysDO.toString());
        sysService.updateSysInfo(sysDO);
        return new MessageBean(true,Constants.SUCCESS_SYSINFO);
    }

    /** 
    * @Description: 跳转系统日志界面
    * @Param: [] 
    * @return: java.lang.String 
    * @Author: ZhuLin
    * @Date: 2019/1/10 
    */ 
    @RequestMapping("/gotoSysLogInfo")
    public String gotoSysLogInfo(){
        return "admin/sysLog";
    }

    /**
     * @Description: 返回日志信息
     * @Param: [model]
     * @return: java.lang.String
     * @Author: ZhuLin
     * @Date: 2019/1/8
     */
    @RequestMapping("/getSysLogInfo")
    @ResponseBody
    public AjaxResultPage<LogDO> getSysLogInfo(AjaxPutPage<LogDO> ajaxPutPage){
        AjaxResultPage<LogDO> result = new AjaxResultPage<LogDO>();
        result.setCode(0);
        result.setMsg(Constants.SUCCESS_MESSAGE);
        result.setCount(logService.getLogCount());
        result.setData(logService.listLogDO(ajaxPutPage));
        return result;
    }

}
