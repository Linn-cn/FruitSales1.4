package com.zl.service;

import com.zl.pojo.AccessoryDO;
import com.zl.util.AjaxPutPage;
import com.zl.util.AjaxResultPage;
import com.zl.util.MessageException;

import java.util.List;

public interface AccessoryService {

    /** 
    * @Description: 根据果蔬id返回对应的附属品 
    * @Param: [gardenstuffId] 
    * @return: java.util.List<com.zl.pojo.AccessoryDO> 
    * @Author: ZhuLin
    * @Date: 2019/1/31 
    */
    AjaxResultPage<AccessoryDO> listAccessoryByGardenId(AjaxPutPage<AccessoryDO> ajaxPutPage);

    /** 
    * @Description: 修改附属品 
    * @Param: [accessoryDO] 
    * @return: void 
    * @Author: ZhuLin
    * @Date: 2019/1/31 
    */ 
    void updateAccessory(AccessoryDO accessoryDO) throws MessageException;
    
    /** 
    * @Description: 删除附属品 
    * @Param: [id] 
    * @return: void 
    * @Author: ZhuLin
    * @Date: 2019/1/31 
    */ 
    void deleteAccessory(String id) throws MessageException;

    /**
     * @Description: 添加附属品
     * @Param: [accessoryDO]
     * @return: void
     * @date: 2019/2/2 21:09 
     */
    void insertAccessory(AccessoryDO accessoryDO) throws MessageException;
}
