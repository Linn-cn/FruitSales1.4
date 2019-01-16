package com.zl.service;


import com.zl.pojo.SysDO;
import com.zl.util.MessageException;

public interface SysService {

    /** 
    * @Description: 获取系统信息 
    * @Param: [] 
    * @return: com.zl.pojo.SysDO 
    * @Author: ZhuLin
    * @Date: 2019/1/8 
    */ 
    SysDO getSysInfo();

    /** 
    * @Description: 修改系统信息 
    * @Param: [sysDO] 
    * @return: boolean 
    * @Author: ZhuLin
    * @Date: 2019/1/8 
    */ 
    boolean updateSysInfo(SysDO sysDO) throws MessageException;
}
