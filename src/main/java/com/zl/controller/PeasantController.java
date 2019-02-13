package com.zl.controller;

import com.zl.aop.SystemControllerLog;
import com.zl.pojo.PeasantDO;
import com.zl.service.*;
import com.zl.util.Constants;
import com.zl.util.MessageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: FruitSales
 * @description:
 * @author: ZhuLlin
 * @create: 2019-01-13 17:55
 **/
@Controller
@RequestMapping("peasant")
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
        peasantService.updatePeasant(peasantInfo);
        return new MessageBean(true,Constants.SUCCESS_UPDATE);
    }
}
