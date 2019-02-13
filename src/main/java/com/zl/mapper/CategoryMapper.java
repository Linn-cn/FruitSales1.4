package com.zl.mapper;

import com.zl.pojo.CategoryDO;
import com.zl.pojo.CategoryDOExample;
import java.util.List;

import com.zl.util.AjaxPutPage;
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

    /** 
    * @Description: 分页返回所有类别信息 
    * @Param: [ajaxPutPage] 
    * @return: java.util.List<com.zl.pojo.CategoryDO> 
    * @Author: ZhuLin
    * @Date: 2019/2/13 
    */ 
    List<CategoryDO> listCategory(AjaxPutPage<CategoryDO> ajaxPutPage);

    /** 
    * @Description:
    * @Param: [categoryId] 
    * @return: int 
    * @Author: ZhuLin
    * @Date: 2019/2/12 
    */ 
    int batchesDelCategory(List<Integer> deleteId);
}