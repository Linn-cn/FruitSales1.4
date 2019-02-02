package com.zl.mapper;

import com.zl.pojo.AccessoryDO;
import com.zl.pojo.AccessoryDOExample;
import java.util.List;
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
}