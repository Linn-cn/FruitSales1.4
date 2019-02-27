package com.zl.mapper;

import com.zl.pojo.AccessoryDO;
import com.zl.pojo.AccessoryDOExample;
import java.util.List;

import com.zl.util.AjaxPutPage;
import org.apache.ibatis.annotations.Param;

public interface AccessoryMapper {
    int countByExample(AccessoryDOExample example);

    int deleteByExample(AccessoryDOExample example);

    int deleteByPrimaryKey(String accessoryId);

    int insert(AccessoryDO record);

    int insertSelective(AccessoryDO record);

    List<AccessoryDO> selectByExample(AccessoryDOExample example);

    AccessoryDO selectByPrimaryKey(String accessoryId);

    int updateByExampleSelective(@Param("record") AccessoryDO record, @Param("example") AccessoryDOExample example);

    int updateByExample(@Param("record") AccessoryDO record, @Param("example") AccessoryDOExample example);

    int updateByPrimaryKeySelective(AccessoryDO record);

    int updateByPrimaryKey(AccessoryDO record);

    /** 
    * @Description: 分页查询对应果蔬的附属品
    * @Param: [ajaxPutPage] 
    * @return: java.util.List<com.zl.pojo.AccessoryDO> 
    * @Author: ZhuLin
    * @Date: 2019/2/13 
    */ 
    List<AccessoryDO> listAccessoryByGardenId(AjaxPutPage<AccessoryDO> ajaxPutPage);

    /**
    * @Description: 返回分页查询对应果蔬的附属品的总行数
    * @Param: [ajaxPutPage] 
    * @return: java.lang.Integer 
    * @Author: ZhuLin
    * @Date: 2019/2/27 
    */ 
    Integer listAccessoryByGardenIdCount(AjaxPutPage<AccessoryDO> ajaxPutPage);
}