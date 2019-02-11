package com.zl.service;

import com.zl.pojo.DealerDO;
import com.zl.pojo.UserDO;
import com.zl.util.AjaxPutPage;
import com.zl.util.MessageException;

import java.util.List;

/**
 * @program: FruitSales
 * @classname: DealerService
 * @description:
 * @author: 朱林
 * @create: 2019-01-19 23:06
 **/
public interface DealerService {

    /**
     * @Description: 返回零售商列表[可带条件]
     * @Param: [ajaxPutPage]
     * @return: java.util.List<com.zl.pojo.PeasantDO>
     * @Author: ZhuLin
     * @Date: 2019/1/13
     */
    List<DealerDO> listDealer(AjaxPutPage<DealerDO> ajaxPutPage);

    /**
     * @Description: 获取返回的零售商总数
     * @Param: []
     * @return: java.lang.Integer
     * @Author: ZhuLin
     * @Date: 2019/1/13
     */
    Long getDealerCount(AjaxPutPage<DealerDO> ajaxPutPage);

    /*** 
    * @Description: 删除零售商
    * @Param: [id] 
    * @return: void 
    * @Author: ZhuLin
    * @Date: 2019/1/21 
    */ 
    void deleteDealer(String id) throws MessageException;

    /** 
    * @Description: 批量删除零售商
    * @Param: [deleteId] 
    * @return: void 
    * @Author: ZhuLin
    * @Date: 2019/1/21 
    */ 
    void batchesDelPeasant(List<String> deleteId) throws MessageException;

    /** 
    * @Description: 添加零售商
    * @Param: [dealerDO] 
    * @return: void 
    * @Author: ZhuLin
    * @Date: 2019/1/21 
    */ 
    void insertDealer(UserDO userDO, DealerDO dealerDO) throws MessageException;

    /** 
    * @Description: 修改零售商
    * @Param: [dealerDO] 
    * @return: void 
    * @Author: ZhuLin
    * @Date: 2019/1/22 
    */ 
    void updateDealer(DealerDO dealerDO) throws MessageException;
}
