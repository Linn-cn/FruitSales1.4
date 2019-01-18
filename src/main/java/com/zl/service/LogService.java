package com.zl.service;


import com.zl.pojo.LogDO;
import com.zl.util.AjaxPutPage;

import java.util.List;

public interface LogService {

    /** 
    * @Description: 记录日志
    * @Param: [logDO] 
    * @return: int 
    * @Author: ZhuLin
    * @Date: 2019/1/10 
    */ 
    int insertLog(LogDO logDO);

    /** 
    * @Description: 修改日志
    * @Param: [logDO] 
    * @return: int 
    * @Author: ZhuLin
    * @Date: 2019/1/10 
    */ 
    int updateLog(LogDO logDO);

    /** 
    * @Description: 返回所有日志记录
    * @Param: [ajaxPutPage] 
    * @return: java.util.List<com.zl.pojo.LogDO> 
    * @Author: ZhuLin
    * @Date: 2019/1/10 
    */ 
    List<LogDO> listLogDO(AjaxPutPage<LogDO> ajaxPutPage);

    /** 
    * @Description: 返回日志记录总条数
    * @Param: [] 
    * @return: int 
    * @Author: ZhuLin
    * @Date: 2019/1/10 
    */ 
    Long getLogCount();

}
