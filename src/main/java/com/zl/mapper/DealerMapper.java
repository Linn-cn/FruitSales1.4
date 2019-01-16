package com.zl.mapper;

import com.zl.pojo.DealerDO;
import com.zl.pojo.DealerDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DealerMapper {
    int countByExample(DealerDOExample example);

    int deleteByExample(DealerDOExample example);

    int deleteByPrimaryKey(String dealerId);

    int insert(DealerDO record);

    int insertSelective(DealerDO record);

    List<DealerDO> selectByExample(DealerDOExample example);

    DealerDO selectByPrimaryKey(String dealerId);

    int updateByExampleSelective(@Param("record") DealerDO record, @Param("example") DealerDOExample example);

    int updateByExample(@Param("record") DealerDO record, @Param("example") DealerDOExample example);

    int updateByPrimaryKeySelective(DealerDO record);

    int updateByPrimaryKey(DealerDO record);
}