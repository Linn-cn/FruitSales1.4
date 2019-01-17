package com.zl.service;

import com.zl.pojo.PeasantDO;
import com.zl.util.AjaxPutPage;
import com.zl.util.MessageBean;
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
    List<PeasantDO> listPeasant(AjaxPutPage<PeasantDO> ajaxPutPage);

    /** 
    * @Description: 获取返回的农民总数
    * @Param: [] 
    * @return: java.lang.Integer 
    * @Author: ZhuLin
    * @Date: 2019/1/13 
    */ 
    Integer getPeasantCount(AjaxPutPage<PeasantDO> ajaxPutPage);

    /** 
    * @Description: 修改农民资料
    * @Param: [peasantInfo] 
    * @return: void 
    * @Author: ZhuLin
    * @Date: 2019/1/17 
    */ 
    void updatePeasant(PeasantDO peasantInfo) throws MessageException;
}
