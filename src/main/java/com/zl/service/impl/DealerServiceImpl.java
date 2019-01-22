package com.zl.service.impl;

import com.zl.mapper.DealerMapper;
import com.zl.mapper.UserMapper;
import com.zl.pojo.DealerDO;
import com.zl.pojo.DealerDOExample;
import com.zl.pojo.UserDOExample;
import com.zl.service.DealerService;
import com.zl.util.AjaxPutPage;
import com.zl.util.MessageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @program: FruitSales
 * @classname: DealerServiceImpl
 * @description:
 * @author: 朱林
 * @create: 2019-01-19 23:08
 **/
@Service
public class DealerServiceImpl implements DealerService {

    @Autowired
    private DealerMapper dealerMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<DealerDO> listDealer(AjaxPutPage<DealerDO> ajaxPutPage) {
        return dealerMapper.listDealer(ajaxPutPage);
    }

    @Override
    public Long getDealerCount(AjaxPutPage<DealerDO> ajaxPutPage) {
        return dealerMapper.getDealerCount(ajaxPutPage);
    }

    @Override
    public void deleteDealer(String id) throws MessageException {
        dealerMapper.deleteByPrimaryKey(id);
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchesDelPeasant(List<String> deleteId) throws MessageException {
        DealerDOExample dealerDOExample = new DealerDOExample();
        dealerDOExample.createCriteria().andDealerIdIn(deleteId);
        dealerMapper.deleteByExample(dealerDOExample);
        UserDOExample userDOExample = new UserDOExample();
        userDOExample.createCriteria().andUseridIn(deleteId);
        userMapper.deleteByExample(userDOExample);
    }

    @Override
    public void insertDealer(DealerDO dealerDO) throws MessageException {
        dealerDO.setDealerTime(new Timestamp(new Date().getTime()));
        dealerMapper.insertSelective(dealerDO);
    }

    @Override
    public void updateDealer(DealerDO dealerDO) throws MessageException {
        dealerMapper.updateByPrimaryKeySelective(dealerDO);
    }
}
