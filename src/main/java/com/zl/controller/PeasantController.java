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
 * @description:
 * @author: ZhuLlin
 * @create: 2019-01-13 17:55
 **/
@Controller
@RequestMapping("/peasant")
public class PeasantController {

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

    /**
     * @Description: 跳转果蔬列表
     * @Param: []
     * @return: java.lang.String
     * @date: 2019/1/19 23:01
     */
    @RequestMapping("/gotoGardenStuffList")
    public String gotoGardenStuffList(){
        return "peasant/gardenstuffList";
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
        AjaxResultPage<GardenStuffDTO> result = new AjaxResultPage<GardenStuffDTO>();
        GardenStuffCondition.setGardenstuffPeasantid(BaseController.getSessionUser().getUserid());
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
        gardenStuffDO.setGardenstuffPeasantid(BaseController.getSessionUser().getUserid());
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
}
