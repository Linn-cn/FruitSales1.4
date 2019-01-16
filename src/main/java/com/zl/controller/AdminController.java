package com.zl.controller;

import com.zl.pojo.PeasantDO;
import com.zl.service.AdminService;
import com.zl.util.AjaxPutPage;
import com.zl.util.AjaxResultPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: FruitSales
 * @description: 管理员特有权限Controller
 * @author: ZhuLlin
 * @create: 2019-01-11 18:17
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /** 
    * @Description: 跳转农民列表界面
    * @Param: [] 
    * @return: java.lang.String 
    * @Author: ZhuLin
    * @Date: 2019/1/13 
    */ 
    @RequestMapping("/gotoPeasantList")
    public String gotoPeasantList(){
        return "admin/peasantList";
    }

    /** 
    * @Description: 获取农民列表
    * @Param: [] 
    * @return: com.zl.util.AjaxResultPage<com.zl.pojo.PeasantDO> 
    * @Author: ZhuLin
    * @Date: 2019/1/13 
    */
    @RequestMapping("/getPeasantList")
    @ResponseBody
    public AjaxResultPage<PeasantDO> getPeasantList(AjaxPutPage<PeasantDO> ajaxPutPage,PeasantDO peasantCondition){
        System.out.println(peasantCondition.toString());
        AjaxResultPage<PeasantDO> result = new AjaxResultPage<PeasantDO>();
        ajaxPutPage.setCondition(peasantCondition);
        result.setData(adminService.listPeasant(ajaxPutPage));
        result.setCount(adminService.getPeasantCount(ajaxPutPage));
        return result;
    }

}
