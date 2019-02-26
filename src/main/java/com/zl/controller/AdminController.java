package com.zl.controller;

import com.zl.aop.SystemControllerLog;
import com.zl.pojo.*;
import com.zl.service.*;
import com.zl.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;
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

    @Autowired
    private AccessoryService accessoryService;

    @Autowired
    private ContractService contractService;

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
        ajaxPutPage.setCondition(peasantCondition);
        AjaxResultPage<PeasantDO> result = peasantService.listPeasant(ajaxPutPage);
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
        // 优化用户插入，防止出现错误导致事务不回滚
        peasantService.insertPeasant(userDO,peasantDO);
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
        // 优化农民删除，防止出现错误导致事务不回滚
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
        ajaxPutPage.setCondition(dealerCondition);
        AjaxResultPage<DealerDO> result = dealerService.listDealer(ajaxPutPage);
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
        // 优化添加零售商，防止出现错误导致事务不回滚
        dealerService.insertDealer(userDO,dealerDO);
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
    public AjaxResultPage<CategoryDO> getCategoryList(AjaxPutPage<CategoryDO> ajaxPutPage){
        AjaxResultPage<CategoryDO> result = new AjaxResultPage<CategoryDO>();
        List<CategoryDO> list = gardenStuffService.listCategory(ajaxPutPage);
        result.setData(list);
        result.setCount(list.size());
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
     * @Description: 批量删除果蔬类别
     * @Param: [deleteId]
     * @return: com.zl.util.MessageBean
     * @date: 2019/2/4 13:38
     */
    @SystemControllerLog(description = "批量删除果蔬类别")
    @RequestMapping("/batchesDelCategory")
    @ResponseBody
    public MessageBean batchesDelCategory(@RequestParam("deleteId[]")List<Integer> deleteId) throws Exception{
        gardenStuffService.batchesDelCategoey(deleteId);
        return new MessageBean(true,Constants.SUCCESS_DELETE);
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
    public MessageBean deleteGardenStuff(String id) throws Exception{
        gardenStuffService.deleteGardenStuff(id);
        return new MessageBean(true,Constants.SUCCESS_DELETE);
    }

    /**
     * @Description: 批量删除果蔬
     * @Param: [deleteId]
     * @return: com.zl.util.MessageBean
     * @date: 2019/2/4 13:38 
     */
    @SystemControllerLog(description = "批量删除果蔬")
    @RequestMapping("/batchesDelGardenStuff")
    @ResponseBody
    public MessageBean batchesDelGardenStuff(@RequestParam("deleteId[]")List<String> deleteId) throws Exception{
        gardenStuffService.batchesDelGardenStuff(deleteId);
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
        return "admin/categoryList";
    }

    /** 
    * @Description: 修改果蔬类别信息[同时修改果蔬类别信息记录]
    * @Param: [categoryDO] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/29 
    */
    @SystemControllerLog(description = "修改果蔬类别信息")
    @RequestMapping("/updateCategory")
    @ResponseBody
    public MessageBean updateCategory(CategoryDO categoryDO) throws Exception{
        gardenStuffService.updateCategory(categoryDO);
        return new MessageBean(true,Constants.SUCCESS_UPDATE);
    }

    /** 
    * @Description: 添加果蔬类别
    * @Param: [categoryDO]
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/30 
    */ 
    @SystemControllerLog(description = "添加果蔬类别")
    @RequestMapping("/addCategory")
    @ResponseBody
    public MessageBean addCategory(CategoryDO categoryDO) throws Exception{
        gardenStuffService.insertCategory(categoryDO);
        return new MessageBean(true,Constants.SUCCESS_MESSAGE);
    }

    /** 
    * @Description: 返回和果蔬对应的附属品
    * @Param: [gardenstuffId] 
    * @return: com.zl.util.AjaxResultPage<com.zl.pojo.AccessoryDO> 
    * @Author: ZhuLin
    * @Date: 2019/1/31 
    */ 
    @RequestMapping("/getAccessoryList")
    @ResponseBody
    public AjaxResultPage<AccessoryDO> getAccessoryList(AjaxPutPage<AccessoryDO> ajaxPutPage,AccessoryDO accessoryDO){
        AjaxResultPage<AccessoryDO> result = new AjaxResultPage<AccessoryDO>();
        ajaxPutPage.setCondition(accessoryDO);
        List<AccessoryDO> list = accessoryService.listAccessoryByGardenId(ajaxPutPage);
        result.setCount(list.size());
        result.setData(list);
        return result;
    }
    
    /** 
    * @Description: 修改附属品信息 
    * @Param: [accessoryDO] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/31 
    */ 
    @SystemControllerLog(description = "修改附属品信息")
    @RequestMapping("/updateAccessory")
    @ResponseBody
    public MessageBean updateAccessory(AccessoryDO accessoryDO) throws Exception{
        accessoryService.updateAccessory(accessoryDO);
        return new MessageBean(true,Constants.SUCCESS_UPDATE);
    }

    /** 
    * @Description: 删除附属品 
    * @Param: [id] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/31 
    */ 
    @SystemControllerLog(description = "删除附属品")
    @RequestMapping("/deleteAccessory")
    @ResponseBody
    public MessageBean deleteAccessory(String id) throws Exception{
        accessoryService.deleteAccessory(id);
        return new MessageBean(true,Constants.SUCCESS_DELETE);
    }

    /** 
    * @Description: 添加附属品 
    * @Param: [accessoryDO] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/31 
    */ 
    @SystemControllerLog(description = "添加附属品")
    @RequestMapping("/addAccessory")
    @ResponseBody
    public MessageBean addAccessory(AccessoryDO accessoryDO) throws Exception{
        accessoryDO.setAccessoryId(UuidUtils.creatUUID());
        accessoryDO.setAccessoryTime(new Timestamp(new Date().getTime()));
        accessoryService.insertAccessory(accessoryDO);
        return new MessageBean(true,Constants.SUCCESS_MESSAGE);
    }

    /**
     * @Description: 跳转合同列表界面
     * @Param: []
     * @return: java.lang.String
     * @date: 2019/2/5 20:12 
     */
    @RequestMapping("/gotoContractList")
    public String gotoContractList(){
        return "admin/contractList";
    }

    /**
     * @Description: 返回合同列表信息
     * @Param: [ajaxPutPage, contractCondition]
     * @return: com.zl.util.AjaxResultPage<com.zl.pojo.ContractDO>
     * @date: 2019/2/5 15:41 
     */
    @RequestMapping("/getContractList")
    @ResponseBody
    public AjaxResultPage<ContractDTO> getContractList(AjaxPutPage<ContractDTO> ajaxPutPage, ContractDTO contractCondition){
        AjaxResultPage<ContractDTO> result = new AjaxResultPage<ContractDTO>();
        ajaxPutPage.setCondition(contractCondition);
        List<ContractDTO> list = contractService.listContract(ajaxPutPage);
        result.setData(list);
        result.setCount(list.size());
        return result;
    }

    /**
     * @Description: 返回合同详情
     * @Param: [contractId]
     * @return: com.zl.pojo.ContractVO
     * @date: 2019/2/8 12:23 
     */
    @RequestMapping("/getContractInfo")
    @ResponseBody
    public MessageBean getContractInfo(String contractId){
        ContractVO contractVO = contractService.getContractInfo(contractId);
        return new MessageBean(true,null,contractVO);
    }

    /** 
    * @Description: 返回合同的果蔬和附属品信息
    * @Param: [contractId] 
    * @return: com.zl.util.AjaxResultPage<com.zl.pojo.GardenStuffVO> 
    * @Author: ZhuLin
    * @Date: 2019/2/12 
    */ 
    @RequestMapping("/getGardenStuffInfoList")
    @ResponseBody
    public AjaxResultPage<GardenStuffVO> getGardenStuffInfoList(String contractId){
        AjaxResultPage<GardenStuffVO> result = new AjaxResultPage<GardenStuffVO>();
        List<GardenStuffVO> list = contractService.listGardenStuffInfoByContractID(contractId);
        result.setData(list);
        result.setCount(list.size());
        return result;
    }

    /** 
    * @Description: 删除合同
    * @Param: [id] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/2/13 
    */
    @SystemControllerLog(description = "删除合同")
    @RequestMapping("/deleteContract")
    @ResponseBody
    public MessageBean deleteContract(String id) throws Exception{
        contractService.deleteContractByKey(id);
        return new MessageBean(true,Constants.SUCCESS_DELETE);
    }

}
