package com.zl.service;

import com.zl.pojo.CategoryDO;
import com.zl.pojo.GardenStuffDTO;
import com.zl.util.AjaxPutPage;

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
}
