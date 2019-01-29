package com.zl.controller;

import com.zl.aop.SystemControllerLog;
import com.zl.pojo.*;
import com.zl.service.DealerService;
import com.zl.service.GardenStuffService;
import com.zl.service.PeasantService;
import com.zl.service.UserService;
import com.zl.util.*;
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

    @Autowired
    private GardenStuffService gardenStuffService;

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
        List<PeasantDO> list = peasantService.listPeasant(ajaxPutPage);
        result.setData(list);
        result.setCount(list.size());
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

    /*** 
    * @Description: 添加农民
    * @Param: [userDO, peasantDO] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/21 
    */ 
    @SystemControllerLog(description = "添加农民")
    @RequestMapping("/addPeasant")
    @ResponseBody
    public MessageBean addPeasant(UserDO userDO,PeasantDO peasantDO) throws Exception{
        String uuid = UuidUtils.creatUUID();
        userDO.setUserid(uuid);
        userDO.setRole(Constants.ROLE_DEALER);
        peasantDO.setPeasantId(uuid);
        userService.insertUser(userDO);
        peasantService.insertPeasant(peasantDO);
        return new MessageBean(true,Constants.SUCCESS_INSERT);
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
        gardenStuffService.deleteGardenStuffByPeasantid(id);
        return new MessageBean(true,Constants.SUCCESS_DELETE);
    }

    /** 
    * @Description: 批量删除农民
    * @Param: [list] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/18 
    */
    @SystemControllerLog(description = "批量删除农民")
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
    @SystemControllerLog(description = "管理员重置密码")
    @RequestMapping("/resetUserPwd")
    @ResponseBody
    public MessageBean resetUserPwd(String id) throws Exception{
        userService.resetUserPwd(id);
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
    * @Param: [ajaxPutPage, dealerCondition] 
    * @return: com.zl.util.AjaxResultPage<com.zl.pojo.DealerDO> 
    * @Author: ZhuLin
    * @Date: 2019/1/22 
    */ 
    @RequestMapping("/getDealerList")
    @ResponseBody
    public AjaxResultPage<DealerDO> getDealerList(AjaxPutPage<DealerDO> ajaxPutPage, DealerDO dealerCondition){
        System.out.println(dealerCondition.toString());
        AjaxResultPage<DealerDO> result = new AjaxResultPage<DealerDO>();
        ajaxPutPage.setCondition(dealerCondition);
        List<DealerDO> list = dealerService.listDealer(ajaxPutPage);
        result.setData(list);
        result.setCount(list.size());
        return result;
    }

    /*** 
    * @Description: 删除零售商
    * @Param: [id] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/21 
    */
    @SystemControllerLog(description = "删除零售商")
    @RequestMapping("/deleteDealer")
    @ResponseBody
    public MessageBean deleteDealer(String id) throws Exception{
        dealerService.deleteDealer(id);
        return new MessageBean(true,Constants.SUCCESS_DELETE);
    }

    /** 
    * @Description: 批量删除零售商
    * @Param: [deleteId] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/21 
    */
    @SystemControllerLog(description = "批量删除零售商")
    @RequestMapping("/batchesDelDealer")
    @ResponseBody
    public MessageBean batchesDelDealer(@RequestParam("deleteId[]")List<String> deleteId) throws Exception{
        dealerService.batchesDelPeasant(deleteId);
        return new MessageBean(true,Constants.SUCCESS_DELETE);
    }

    /** 
    * @Description: 添加零售商
    * @Param: [userDO, dealerDO] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/21 
    */
    @SystemControllerLog(description = "添加零售商")
    @RequestMapping("/addDealer")
    @ResponseBody
    public MessageBean addDealer(UserDO userDO,DealerDO dealerDO) throws Exception{
        String uuid = UuidUtils.creatUUID();
        userDO.setUserid(uuid);
        userDO.setRole(Constants.ROLE_DEALER);
        dealerDO.setDealerId(uuid);
        userService.insertUser(userDO);
        dealerService.insertDealer(dealerDO);
        return new MessageBean(true,Constants.SUCCESS_INSERT);
    }

    /** 
    * @Description: 修改零售商
    * @Param: [dealerDO] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/22 
    */
    @SystemControllerLog(description = "修改零售商")
    @RequestMapping("/updateDealer")
    @ResponseBody
    public MessageBean updateDealer(DealerDO dealerDO) throws Exception{
        dealerService.updateDealer(dealerDO);
        return new MessageBean(true,Constants.SUCCESS_UPDATE);
    }

    /**
     * @Description: 跳转果蔬列表
     * @Param: []
     * @return: java.lang.String
     * @date: 2019/1/19 23:01
     */
    @RequestMapping("/gotoGardenStuffList")
    public String gotoGardenStuffList(){
        return "admin/gardenstuffList";
    }

    /** 
    * @Description: 获取果蔬列表
    * @Param: [ajaxPutPage, GardenStuffCondition] 
    * @return: com.zl.util.AjaxResultPage<com.zl.pojo.GardenStuffDTO> 
    * @Author: ZhuLin
    * @Date: 2019/1/22 
    */ 
    @RequestMapping("/getGardenStuffList")
    @ResponseBody
    public AjaxResultPage<GardenStuffDTO> getGardenStuffList(AjaxPutPage<GardenStuffDTO> ajaxPutPage, GardenStuffDTO GardenStuffCondition){
        System.out.println(GardenStuffCondition.toString());
        AjaxResultPage<GardenStuffDTO> result = new AjaxResultPage<GardenStuffDTO>();
        ajaxPutPage.setCondition(GardenStuffCondition);
        List<GardenStuffDTO> list = gardenStuffService.listGardenStuff(ajaxPutPage);
        result.setData(list);
        result.setCount(list.size());
        return result;
    }

    /**
    * @Description: 获取果蔬类别
    * @Param: []
    * @return: com.zl.util.AjaxResultPage<com.zl.pojo.CategoryDO>
    * @Author: ZhuLin
    * @Date: 2019/1/22
    */
    @RequestMapping("/getCategoryList")
    @ResponseBody
    public AjaxResultPage<CategoryDO> getCategoryList(){
        AjaxResultPage<CategoryDO> result = new AjaxResultPage<CategoryDO>();
        result.setData(gardenStuffService.listCategory());
        result.setCount(gardenStuffService.listCategory().size());
        return result;
    }


    /**
     * @Description: 添加果蔬
     * @Param: [gardenStuffDTO]
     * @return: com.zl.util.MessageBean
     * @date: 2019/1/27 20:09 
     */
    @SystemControllerLog(description = "添加果蔬")
    @RequestMapping("/addGardenStuff")
    @ResponseBody
    public MessageBean addGardenStuff(GardenStuffDO gardenStuffDO) throws Exception{
        gardenStuffService.insertGardenStuff(gardenStuffDO);
        return new MessageBean(true,Constants.SUCCESS_MESSAGE);
    }

    /** 
    * @Description: 修改果蔬信息
    * @Param: [gardenStuffDO] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/29 
    */ 
    @SystemControllerLog(description = "修改果蔬信息")
    @RequestMapping("/updateGardenStuff")
    @ResponseBody
    public MessageBean updateGardenStuff(GardenStuffDO gardenStuffDO) throws Exception{
        gardenStuffService.updateGardenStuff(gardenStuffDO);
        return new MessageBean(true,Constants.SUCCESS_UPDATE);
    }


    /** 
    * @Description: 删除果蔬
    * @Param: [id] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/29 
    */ 
    @SystemControllerLog(description = "删除果蔬")
    @RequestMapping("/deleteGardenStuff")
    @ResponseBody
    public MessageBean deleteGardenStuff(String id){
        System.out.println("删除：" + id);
        gardenStuffService.deleteGardenStuff(id);
        return new MessageBean(true,Constants.SUCCESS_DELETE);
    }

    /**
     * @Description: 跳转果蔬类别列表
     * @Param: []
     * @return: java.lang.String
     * @date: 2019/1/19 23:01
     */
    @RequestMapping("/gotoCategoryList")
    public String gotoCategoryList(){
        return "admin/CategoryList";
    }

    /** 
    * @Description: 修改果蔬类别信息
    * @Param: [categoryDO] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/29 
    */
    @SystemControllerLog(description = "修改果蔬类别信息")
    @RequestMapping("/updateCategory")
    @ResponseBody
    public MessageBean updateCategory(CategoryDO categoryDO){
        gardenStuffService.updateCategory(categoryDO);
        return new MessageBean(true,Constants.SUCCESS_UPDATE);
    }

}
