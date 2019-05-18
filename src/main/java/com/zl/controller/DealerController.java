package com.zl.controller;

import com.zl.aop.SystemControllerLog;
import com.zl.pojo.ContractDTO;
import com.zl.pojo.ContractVO;
import com.zl.pojo.GardenStuffDTO;
import com.zl.pojo.PeasantDO;
import com.zl.service.*;
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
 * @classname: DealerController
 * @description: 零售商特有权限Controlle
 * @author: 朱林
 * @create: 2019-05-16 11:55
 **/
@Controller
@RequestMapping("/dealer")
public class DealerController {

    @Autowired
    private PeasantService peasantService;

    @Autowired
    private GardenStuffService gardenStuffService;

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
        return "dealer/peasantList";
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
    public AjaxResultPage<PeasantDO> getPeasantList(AjaxPutPage<PeasantDO> ajaxPutPage, PeasantDO peasantCondition){
        ajaxPutPage.setCondition(peasantCondition);
        AjaxResultPage<PeasantDO> result = peasantService.listPeasant(ajaxPutPage);
        return result;
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
        ajaxPutPage.setCondition(GardenStuffCondition);
        AjaxResultPage<GardenStuffDTO> result = gardenStuffService.listGardenStuff(ajaxPutPage);
        return result;
    }

    /**
     * @Description: 跳转合同列表界面
     * @Param: []
     * @return: java.lang.String
     * @date: 2019/2/5 20:12
     */
    @RequestMapping("/gotoContractList")
    public String gotoContractList(){
        return "dealer/contractList";
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
        contractCondition.setDealerId(BaseController.getSessionUser().getUserid());
        ajaxPutPage.setCondition(contractCondition);
        AjaxResultPage<ContractDTO> result = contractService.listContract(ajaxPutPage);
        return result;
    }

    /**
     * @Description: 取消合同
     * @Param: [id]
     * @return: com.zl.util.MessageBean
     * @Author: ZhuLin
     * @Date: 2019/2/13
     */
    @SystemControllerLog(description = "删除合同")
    @RequestMapping("/cancelContract")
    @ResponseBody
    public MessageBean cancelContract(String id) throws Exception{
        contractService.updateContractByCheck(id,Constants.CONTRACT_CANCEL);
        return new MessageBean(true,Constants.SUCCESS_DELETE);
    }

    /**
     * @Description: 确认合同
     * @Param: [id]
     * @return: com.zl.util.MessageBean
     * @Author: ZhuLin
     * @Date: 2019/2/13
     */
    @SystemControllerLog(description = "确认合同")
    @RequestMapping("/confirmContract")
    @ResponseBody
    public MessageBean confirmContract(String id) throws Exception{
        contractService.updateContractByCheck(id,Constants.CONTRACT_CONFIRM);
        return new MessageBean(true,Constants.SUCCESS_DELETE);
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
}
