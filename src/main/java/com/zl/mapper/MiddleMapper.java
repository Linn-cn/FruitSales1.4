package com.zl.mapper;

import com.zl.pojo.MiddleDO;
import com.zl.pojo.MiddleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MiddleMapper {
    int countByExample(MiddleDOExample example);

    int deleteByExample(MiddleDOExample example);

    int deleteByPrimaryKey(String middleId);

    int insert(MiddleDO record);

    int insertSelective(MiddleDO record);

    List<MiddleDO> selectByExample(MiddleDOExample example);

    MiddleDO selectByPrimaryKey(String middleId);

    int updateByExampleSelective(@Param("record") MiddleDO record, @Param("example") MiddleDOExample example);

    int updateByExample(@Param("record") MiddleDO record, @Param("example") MiddleDOExample example);

    int updateByPrimaryKeySelective(MiddleDO record);

    int updateByPrimaryKey(MiddleDO record);
}