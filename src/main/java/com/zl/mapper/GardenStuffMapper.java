package com.zl.mapper;

import com.zl.pojo.GardenStuffDO;
import com.zl.pojo.GardenStuffDOExample;
import com.zl.pojo.GardenStuffDTO;
import com.zl.util.AjaxPutPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GardenStuffMapper {
    int countByExample(GardenStuffDOExample example);

    int deleteByExample(GardenStuffDOExample example);

    int deleteByPrimaryKey(String gardenstuffId);

    int insert(GardenStuffDO record);

    int insertSelective(GardenStuffDO record);

    List<GardenStuffDO> selectByExample(GardenStuffDOExample example);

    GardenStuffDO selectByPrimaryKey(String gardenstuffId);

    int updateByExampleSelective(@Param("record") GardenStuffDO record, @Param("example") GardenStuffDOExample example);

    int updateByExample(@Param("record") GardenStuffDO record, @Param("example") GardenStuffDOExample example);

    int updateByPrimaryKeySelective(GardenStuffDO record);

    int updateByPrimaryKey(GardenStuffDO record);

    /** 
    * @Description: 返回果蔬列表[可带条件] 
    * @Param: [ajaxPutPage] 
    * @return: java.util.List<com.zl.pojo.GardenStuffDTO> 
    * @Author: ZhuLin
    * @Date: 2019/1/22 
    */ 
    List<GardenStuffDTO> listGardenStuff(AjaxPutPage<GardenStuffDTO> ajaxPutPage);
}