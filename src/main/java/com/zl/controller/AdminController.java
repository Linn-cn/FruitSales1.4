package com.zl.controller;

import com.zl.aop.SystemControllerLog;
import com.zl.pojo.DealerDO;
import com.zl.pojo.PeasantDO;
import com.zl.service.DealerService;
import com.zl.service.PeasantService;
import com.zl.service.UserService;
import com.zl.util.AjaxPutPage;
import com.zl.util.AjaxResultPage;
import com.zl.util.Constants;
import com.zl.util.MessageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @Autowired
    private UserService userService;

    @Autowired
    private DealerService dealerService;

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
        peasantService.updatePeasant(peasantInfo);
        return new MessageBean(true,Constants.SUCCESS_UPDATE);
    }

    /**
    * @Description: 删除农民
    * @Param: [id]
    * @return: com.zl.util.MessageBean
    * @Author: ZhuLin
    * @Date: 2019/1/18
    */
    @SystemControllerLog(description = "删除农民")
    @RequestMapping("/deletePeasant")
    @ResponseBody
    public MessageBean deletePeasant(String id) throws Exception{
        peasantService.deletePeasant(id);
        return new MessageBean(true,Constants.SUCCESS_DELETE);
    }

    /** 
    * @Description: 批量删除农民
    * @Param: [list] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/18 
    */ 
    @RequestMapping("/batchesDelPeasant")
    @ResponseBody
    public MessageBean batchesDelPeasant(@RequestParam("deleteId[]")List<String> deleteId) throws Exception{
        peasantService.batchesDelPeasant(deleteId);
        return new MessageBean(true,Constants.SUCCESS_DELETE);
    }

    /**
     * @Description: 管理员重置密码
     * @Param: [id] 需要重置的用户id
     * @return: com.zl.util.MessageBean
     * @date: 2019/1/19 14:49 
     */
    @RequestMapping("/resetPeasantPwd")
    @ResponseBody
    public MessageBean resetPeasantPwd(String id) throws Exception{
        userService.resetPeasantPwd(id);
        return new MessageBean(true,Constants.SUCCESS_RESET_PASSWORD);
    }

    /**
     * @Description: 跳转零售商列表
     * @Param: []
     * @return: java.lang.String
     * @date: 2019/1/19 23:01 
     */
    @RequestMapping("/gotoDealerList")
    public String gotoDealerList(){
        return "admin/dealerList";
    }

    /**
     * @Description: 获取零售商列表
     * @Param: []
     * @return: com.zl.util.AjaxResultPage<com.zl.pojo.PeasantDO>
     * @Author: ZhuLin
     * @Date: 2019/1/13
     */
    @RequestMapping("/getDealerList")
    @ResponseBody
    public AjaxResultPage<DealerDO> getDealerList(AjaxPutPage<DealerDO> ajaxPutPage, DealerDO dealerCondition){
        System.out.println(dealerCondition.toString());
        AjaxResultPage<DealerDO> result = new AjaxResultPage<DealerDO>();
        ajaxPutPage.setCondition(dealerCondition);
        result.setData(dealerService.listDealer(ajaxPutPage));
        result.setCount(dealerService.getDealerCount(ajaxPutPage));
        return result;
    }

}
