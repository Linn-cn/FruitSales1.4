package com.zl.mapper;

import com.zl.pojo.PeasantDO;
import com.zl.pojo.PeasantDOExample;
import java.util.List;

import com.zl.util.AjaxPutPage;
import org.apache.ibatis.annotations.Param;

public interface PeasantMapper {
    int countByExample(PeasantDOExample example);

    int deleteByExample(PeasantDOExample example);

    int deleteByPrimaryKey(String peasantId);

    int insert(PeasantDO record);

    int insertSelective(PeasantDO record);

    List<PeasantDO> selectByExample(PeasantDOExample example);

    PeasantDO selectByPrimaryKey(String peasantId);

    int updateByExampleSelective(@Param("record") PeasantDO record, @Param("example") PeasantDOExample example);

    int updateByExample(@Param("record") PeasantDO record, @Param("example") PeasantDOExample example);

    int updateByPrimaryKeySelective(PeasantDO record);

    int updateByPrimaryKey(PeasantDO record);

    /** 
    * @Description: 返回农民列表[可带条件]
    * @Param: [ajaxPutPage] 
    * @return: java.util.List<com.zl.pojo.PeasantDO> 
    * @Author: ZhuLin
    * @Date: 2019/1/13 
    */ 
    List<PeasantDO> listPeasant(AjaxPutPage<PeasantDO> ajaxPutPage);

    /** 
    * @Description:  返回农民总条数
    * @Param: [ajaxPutPage] 
    * @return: java.lang.Long 
    * @Author: ZhuLin
    * @Date: 2019/1/13 
    */ 
    Long getPeasantCount(AjaxPutPage<PeasantDO> ajaxPutPage);
}