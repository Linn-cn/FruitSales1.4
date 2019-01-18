package com.zl.mapper;

import com.zl.pojo.LogDO;
import com.zl.pojo.logDOExample;
import java.util.List;

import com.zl.util.AjaxPutPage;
import org.apache.ibatis.annotations.Param;

public interface LogMapper {
    int countByExample(logDOExample example);

    int deleteByExample(logDOExample example);

    int deleteByPrimaryKey(String logId);

    int insert(LogDO record);

    int insertSelective(LogDO record);

    List<LogDO> selectByExample(logDOExample example);

    LogDO selectByPrimaryKey(String logId);

    int updateByExampleSelective(@Param("record") LogDO record, @Param("example") logDOExample example);

    int updateByExample(@Param("record") LogDO record, @Param("example") logDOExample example);

    int updateByPrimaryKeySelective(LogDO record);

    int updateByPrimaryKey(LogDO record);

    /** 
    * @Description: 分页获取所有日志记录
    * @Param: [ajaxPutPage]
    * @return: java.util.List<com.zl.pojo.LogDO> 
    * @Author: ZhuLin
    * @Date: 2019/1/10 
    */ 
    List<LogDO> listLogDO(AjaxPutPage<LogDO> ajaxPutPage);

    /** 
    * @Description: 返回日志表总条数 
    * @Param: [] 
    * @return: java.lang.Long 
    * @Author: ZhuLin
    * @Date: 2019/1/18 
    */ 
    Long getLogCount();
}