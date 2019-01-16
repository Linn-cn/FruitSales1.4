package com.zl.mapper;

import com.zl.pojo.RoleDO;
import com.zl.pojo.RoleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int countByExample(RoleDOExample example);

    int deleteByExample(RoleDOExample example);

    int deleteByPrimaryKey(Integer roleid);

    int insert(RoleDO record);

    int insertSelective(RoleDO record);

    List<RoleDO> selectByExample(RoleDOExample example);

    RoleDO selectByPrimaryKey(Integer roleid);

    int updateByExampleSelective(@Param("record") RoleDO record, @Param("example") RoleDOExample example);

    int updateByExample(@Param("record") RoleDO record, @Param("example") RoleDOExample example);

    int updateByPrimaryKeySelective(RoleDO record);

    int updateByPrimaryKey(RoleDO record);
}