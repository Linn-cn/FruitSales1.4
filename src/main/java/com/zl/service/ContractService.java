package com.zl.service;

import com.zl.pojo.ContractDO;
import com.zl.pojo.ContractDTO;
import com.zl.pojo.ContractVO;
import com.zl.pojo.GardenStuffVO;
import com.zl.util.AjaxPutPage;
import com.zl.util.AjaxResultPage;
import com.zl.util.MessageException;

import java.util.List;

/**
 * @program: FruitSales
 * @classname: ContractService
 * @description:
 * @author: 朱林
 * @create: 2019-02-05 15:39
 **/
public interface ContractService {

    /**
     * @Description: 返回所有合同信息
     * @Param: [ajaxPutPage]
     * @return: java.util.List<com.zl.pojo.ContractDO>
     * @date: 2019/2/5 15:40 
     */
    AjaxResultPage<ContractDTO> listContract(AjaxPutPage<ContractDTO> ajaxPutPage);

    /** 
    * @Description: 返回合同总数量
    * @Param: [] 
    * @return: java.lang.Integer 
    * @Author: ZhuLin
    * @Date: 2019/2/13 
    */ 
    Integer getContractCount();

    /**
     * @Description: 返回合同详情
     * @Param: [contractId]
     * @return: com.zl.pojo.ContractVO
     * @date: 2019/2/8 11:43
     */
    ContractVO getContractInfo(String contractId);

    /**
     * @Description: 返回单个合同的果蔬详情
     * @Param: [contractId]
     * @return: java.util.List<com.zl.pojo.GardenStuffVO>
     * @Author: ZhuLin
     * @Date: 2019/2/12
     */
    List<GardenStuffVO> listGardenStuffInfoByContractID(String contractId);

    /** 
    * @Description: 删除合同[级联删除合同中间表]
    * @Param: [id] 
    * @return: void 
    * @Author: ZhuLin
    * @Date: 2019/2/13 
    */ 
    void deleteContractByKey(String id) throws MessageException;

    /** 
    * @Description: 返回零售商对应的合同数 
    * @Param: [dealerid] 
    * @return: java.lang.Integer 
    * @Author: ZhuLin
    * @Date: 2019/2/15 
    */ 
    Integer contractCountByDealerID(String dealerid);
}
