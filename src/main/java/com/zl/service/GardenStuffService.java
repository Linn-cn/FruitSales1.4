package com.zl.service;

import com.zl.pojo.CategoryDO;
import com.zl.pojo.GardenStuffDO;
import com.zl.pojo.GardenStuffDTO;
import com.zl.util.AjaxPutPage;
import com.zl.util.MessageException;

import java.util.List;

public interface GardenStuffService {

    /** 
    * @Description: 返回果蔬列表[可带条件]
    * @Param: [ajaxPutPage] 
    * @return: java.util.List<com.zl.pojo.GardenStuffDTO> 
    * @Author: ZhuLin
    * @Date: 2019/1/22 
    */ 
    List<GardenStuffDTO> listGardenStuff(AjaxPutPage<GardenStuffDTO> ajaxPutPage);

    /** 
    * @Description: 返回所有果蔬类别 
    * @Param: [] 
    * @return: java.util.List<com.zl.pojo.CategoryDO> 
    * @Author: ZhuLin
    * @Date: 2019/1/22 
    */ 
    List<CategoryDO> listCategory();

    /**
     * @Description: 添加果蔬
     * @Param: [gardenStuffDO]
     * @return: void
     * @date: 2019/1/27 20:19 
     */
    void insertGardenStuff(GardenStuffDO gardenStuffDO) throws MessageException;

    /**
     * @Description: 根据农民id删除所属农民的所有果蔬[删除农民时执行]
     * @Param: [id]
     * @return: void
     * @date: 2019/1/27 20:35 
     */
    void deleteGardenStuffByPeasantid(String id) throws MessageException;

    /** 
    * @Description: 修改果蔬信息
    * @Param: [gardenStuffDO] 
    * @return: void 
    * @Author: ZhuLin
    * @Date: 2019/1/29 
    */ 
    void updateGardenStuff(GardenStuffDO gardenStuffDO) throws MessageException;

    /** 
    * @Description: 删除果蔬信息
    * @Param: [gardenStuffDO] 
    * @return: void 
    * @Author: ZhuLin
    * @Date: 2019/1/29 
    */ 
    void deleteGardenStuff(String id) throws MessageException;

    /** 
    * @Description: 修改果蔬类别信息[同时修改果蔬类别信息记录]
    * @Param: [categoryDO] 
    * @return: void 
    * @Author: ZhuLin
    * @Date: 2019/1/29 
    */ 
    void updateCategory(CategoryDO categoryDO) throws MessageException;

    /** 
    * @Description: 添加果蔬类别 
    * @Param: [categoryDO] 
    * @return: void 
    * @Author: ZhuLin
    * @Date: 2019/1/30 
    */ 
    void insertCategory(CategoryDO categoryDO) throws MessageException;
}
