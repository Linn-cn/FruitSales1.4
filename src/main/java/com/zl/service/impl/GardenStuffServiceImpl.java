package com.zl.service.impl;

import com.zl.mapper.CategoryMapper;
import com.zl.mapper.GardenStuffMapper;
import com.zl.pojo.CategoryDO;
import com.zl.pojo.GardenStuffDTO;
import com.zl.service.GardenStuffService;
import com.zl.util.AjaxPutPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: FruitSales
 * @description:
 * @author: ZhuLlin
 * @create: 2019-01-22 15:14
 **/
@Service
public class GardenStuffServiceImpl implements GardenStuffService {

    @Autowired
    private GardenStuffMapper gardenStuffMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<GardenStuffDTO> listGardenStuff(AjaxPutPage<GardenStuffDTO> ajaxPutPage) {
        return gardenStuffMapper.listGardenStuff(ajaxPutPage);
    }

    @Override
    public List<CategoryDO> listCategory() {
        return categoryMapper.selectByExample(null);
    }


}
