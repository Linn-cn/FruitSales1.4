package com.zl.service.impl;

import com.zl.mapper.CategoryMapper;
import com.zl.mapper.GardenStuffMapper;
import com.zl.pojo.CategoryDO;
import com.zl.pojo.GardenStuffDO;
import com.zl.pojo.GardenStuffDOExample;
import com.zl.pojo.GardenStuffDTO;
import com.zl.service.GardenStuffService;
import com.zl.util.AjaxPutPage;
import com.zl.util.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
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

    @Override
    public void insertGardenStuff(GardenStuffDO gardenStuffDO) {
        gardenStuffDO.setGardenstuffId(UuidUtils.creatUUID());
        gardenStuffDO.setGardenstuffTime(new Timestamp(new Date().getTime()));
        gardenStuffMapper.insertSelective(gardenStuffDO);
    }

    @Override
    public void deleteGardenStuffByPeasantid(String id) {
        GardenStuffDOExample example = new GardenStuffDOExample();
        example.createCriteria().andGardenstuffPeasantidEqualTo(id);
        gardenStuffMapper.deleteByExample(example);
    }

    @Override
    public void updateGardenStuff(GardenStuffDO gardenStuffDO) {
        gardenStuffMapper.updateByPrimaryKeySelective(gardenStuffDO);
    }

    @Override
    public void deleteGardenStuff(String id) {
        gardenStuffMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateCategory(CategoryDO categoryDO) {
        categoryMapper.updateByPrimaryKeySelective(categoryDO);
    }

    @Override
    public void insertCategory(CategoryDO categoryDO) {
        categoryMapper.insertSelective(categoryDO);
    }


}
