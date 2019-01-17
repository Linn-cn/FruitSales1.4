package com.zl.controller;

import com.zl.aop.SystemControllerLog;
import com.zl.pojo.PeasantDO;
import com.zl.service.PeasantService;
import com.zl.util.AjaxPutPage;
import com.zl.util.AjaxResultPage;
import com.zl.util.Constants;
import com.zl.util.MessageBean;
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
    private PeasantService peasantService;

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
        result.setData(peasantService.listPeasant(ajaxPutPage));
        result.setCount(peasantService.getPeasantCount(ajaxPutPage));
        return result;
    }

    /** 
    * @Description: 修改农民资料
    * @Param: [peasantInfo] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/17 
    */
    @SystemControllerLog(description = "修改农民资料")
    @RequestMapping("/updatePeasant")
    @ResponseBody
    public MessageBean updatePeasant(PeasantDO peasantInfo) throws Exception{
        System.out.println(peasantInfo.toString());
        peasantService.updatePeasant(peasantInfo);
        return new MessageBean(true,Constants.SUCCESS_UPDATE);
    }

}
