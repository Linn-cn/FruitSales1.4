package com.zl.service.impl;

import com.zl.mapper.AccessoryMapper;
import com.zl.pojo.AccessoryDO;
import com.zl.pojo.AccessoryDOExample;
import com.zl.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: FruitSales
 * @description:
 * @author: ZhuLlin
 * @create: 2019-01-31 14:12
 **/
@Service
public class AccessoryServiceImpl implements AccessoryService {

    @Autowired
    private AccessoryMapper accessoryMapper;

    @Override
    public List<AccessoryDO> listAccessoryByGardenId(String gardenstuffId) {
        AccessoryDOExample example = new AccessoryDOExample();
        example.createCriteria().andGardenstuffIdEqualTo(gardenstuffId);
        return accessoryMapper.selectByExample(example);
    }

    @Override
    public void updateAccessory(AccessoryDO accessoryDO) {
        accessoryMapper.updateByPrimaryKeySelective(accessoryDO);
    }

    @Override
    public void deleteAccessory(String id) {
        accessoryMapper.deleteByPrimaryKey(id);
    }
}
