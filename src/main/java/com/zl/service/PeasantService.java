package com.zl.service;

import com.zl.pojo.PeasantDO;
import com.zl.pojo.UserDO;
import com.zl.util.AjaxPutPage;
import com.zl.util.AjaxResultPage;
import com.zl.util.MessageException;

import java.util.List;

public interface PeasantService {

    /**
     * @Description: 返回农民列表[可带条件]
     * @Param: [ajaxPutPage]
     * @return: java.util.List<com.zl.pojo.PeasantDO>
     * @Author: ZhuLin
     * @Date: 2019/1/13
     */
    AjaxResultPage<PeasantDO> listPeasant(AjaxPutPage<PeasantDO> ajaxPutPage);

    /** 
    * @Description: 获取返回的农民总数
    * @Param: [] 
    * @return: java.lang.Integer 
    * @Author: ZhuLin
    * @Date: 2019/1/13 
    */ 
    Integer getPeasantCount();

    /** 
    * @Description: 修改农民资料
    * @Param: [peasantInfo] 
    * @return: void 
    * @Author: ZhuLin
    * @Date: 2019/1/17 
    */ 
    void updatePeasant(PeasantDO peasantInfo) throws MessageException;

    /*** 
    * @Description: 添加农民资料 
    * @Param: [peasantDO] 
    * @return: void 
    * @Author: ZhuLin
    * @Date: 2019/1/21 
    */ 
    void insertPeasant(UserDO userDO, PeasantDO peasantDO) throws MessageException;

    /** 
    * @Description: 删除农民
    * @Param: [id]
    * @return: void 
    * @Author: ZhuLin
    * @Date: 2019/1/18 
    */ 
    void deletePeasant(String id) throws MessageException;

    /**
     * @Description: 批量删除农民
     * @Param: [deleteId]
     * @return: void
     * @date: 2019/1/19 13:53 
     */
    void batchesDelPeasant(List<String> deleteId) throws MessageException;
}
