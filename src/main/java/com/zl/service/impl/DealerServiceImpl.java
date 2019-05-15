package com.zl.service.impl;

import com.zl.mapper.ContractMapper;
import com.zl.mapper.DealerMapper;
import com.zl.mapper.UserMapper;
import com.zl.pojo.*;
import com.zl.service.DealerService;
import com.zl.util.*;
import org.apache.shiro.crypto.hash.Md5Hash;
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

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public AjaxResultPage<DealerDO> listDealer(AjaxPutPage<DealerDO> ajaxPutPage) {
        AjaxResultPage<DealerDO> result = new AjaxResultPage<DealerDO>();
        List<DealerDO> list = dealerMapper.listDealer(ajaxPutPage);
        result.setData(list);
        result.setCount(dealerMapper.listDealerCount(ajaxPutPage));
        return result;
    }

    @Override
    public Integer getDealerCount() {
        return dealerMapper.getDealerCount();
    }

    @Override
    public void deleteDealer(String id) throws MessageException {
        ContractDOExample contractDOExample = new ContractDOExample();
        contractDOExample.createCriteria().andDealerIdEqualTo(id);
        List<ContractDO> list = contractMapper.selectByExample(contractDOExample);
        if(list.size() <= 0){
            dealerMapper.deleteByPrimaryKey(id);
            userMapper.deleteByPrimaryKey(id);
        }else{
            throw new MessageException(Constants.ERROR_CODE,Constants.ERROR_DELETE);
        }
    }

    @Override
    public void batchesDelPeasant(List<String> deleteId) throws MessageException {
        //验证删除的零售商是否有绑定合同
        for (String id : deleteId){
            ContractDOExample contractDOExample = new ContractDOExample();
            contractDOExample.createCriteria().andDealerIdEqualTo(id);
            List<ContractDO> list = contractMapper.selectByExample(contractDOExample);
            if(list.size() > 0){
                throw new MessageException(dealerMapper.selectByPrimaryKey(id).getDealerName(),Constants.ERROR_DELETE);
            }
        }
        DealerDOExample dealerDOExample = new DealerDOExample();
        dealerDOExample.createCriteria().andDealerIdIn(deleteId);
        dealerMapper.deleteByExample(dealerDOExample);
        UserDOExample userDOExample = new UserDOExample();
        userDOExample.createCriteria().andUseridIn(deleteId);
        userMapper.deleteByExample(userDOExample);
    }

    @Override
    public void insertDealer(UserDO userDO, DealerDO dealerDO) throws MessageException {
        String uuid = UuidUtils.creatUUID();
        userDO.setUserid(uuid);
        userDO.setRole(Constants.ROLE_DEALER);
        String password = new Md5Hash(Constants.PASSWORD,userDO.getUsername(),Constants.HASHITERATIONS).toString();
        userDO.setPassword(password);
        userMapper.insertSelective(userDO);
        dealerDO.setDealerId(uuid);
        dealerDO.setDealerTime(new Timestamp(new Date().getTime()));
        dealerMapper.insertSelective(dealerDO);
    }

    @Override
    public void updateDealer(DealerDO dealerDO) throws MessageException {
        dealerMapper.updateByPrimaryKeySelective(dealerDO);
    }
}
