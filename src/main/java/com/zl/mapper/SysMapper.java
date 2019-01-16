package com.zl.mapper;

import com.zl.pojo.SysDO;
import com.zl.pojo.SysDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMapper {
    int countByExample(SysDOExample example);

    int deleteByExample(SysDOExample example);

    int deleteByPrimaryKey(Integer sysId);

    int insert(SysDO record);

    int insertSelective(SysDO record);

    List<SysDO> selectByExample(SysDOExample example);

    SysDO selectByPrimaryKey(Integer sysId);

    int updateByExampleSelective(@Param("record") SysDO record, @Param("example") SysDOExample example);

    int updateByExample(@Param("record") SysDO record, @Param("example") SysDOExample example);

    int updateByPrimaryKeySelective(SysDO record);

    int updateByPrimaryKey(SysDO record);
}