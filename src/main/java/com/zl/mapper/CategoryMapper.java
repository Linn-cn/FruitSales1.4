package com.zl.mapper;

import com.zl.pojo.CategoryDO;
import com.zl.pojo.CategoryDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
    int countByExample(CategoryDOExample example);

    int deleteByExample(CategoryDOExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(CategoryDO record);

    int insertSelective(CategoryDO record);

    List<CategoryDO> selectByExample(CategoryDOExample example);

    CategoryDO selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") CategoryDO record, @Param("example") CategoryDOExample example);

    int updateByExample(@Param("record") CategoryDO record, @Param("example") CategoryDOExample example);

    int updateByPrimaryKeySelective(CategoryDO record);

    int updateByPrimaryKey(CategoryDO record);
}