package com.zl.service.impl;

import com.zl.mapper.GardenStuffMapper;
import com.zl.mapper.PeasantMapper;
import com.zl.mapper.UserMapper;
import com.zl.pojo.*;
import com.zl.service.PeasantService;
import com.zl.util.AjaxPutPage;
import com.zl.util.Constants;
import com.zl.util.MessageException;
import com.zl.util.UuidUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @program: FruitSales
 * @description:
 * @author: ZhuLlin
 * @create: 2019-01-13 18:06
 **/
@Service
public class PeasantServiceImpl implements PeasantService {

    @Autowired
    private PeasantMapper peasantMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GardenStuffMapper gardenStuffMapper;

    @Override
    public List<PeasantDO> listPeasant(AjaxPutPage<PeasantDO> ajaxPutPage) {
        return peasantMapper.listPeasant(ajaxPutPage);
    }

    @Override
    public Integer getPeasantCount() {
        return peasantMapper.getPeasantCount();
    }

    @Override
    public void updatePeasant(PeasantDO peasantInfo) throws MessageException {
        //用于插入时间
/*        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        peasantInfo.setPeasantTime(timestamp);*/
        peasantMapper.updateByPrimaryKeySelective(peasantInfo);
    }

    @Override
    public void insertPeasant(UserDO userDO, PeasantDO peasantDO) throws MessageException {
        String uuid = UuidUtils.creatUUID();
        userDO.setUserid(uuid);
        userDO.setRole(Constants.ROLE_DEALER);
        String password = new Md5Hash(Constants.PASSWORD,userDO.getUsername(),Constants.HASHITERATIONS).toString();
        userDO.setPassword(password);
        userMapper.insertSelective(userDO);
        peasantDO.setPeasantId(uuid);
        peasantDO.setPeasantTime(new Timestamp(new Date().getTime()));
        peasantMapper.insertSelective(peasantDO);
    }

    @Override
    public void deletePeasant(String id) throws MessageException {
        peasantMapper.deleteByPrimaryKey(id);
        userMapper.deleteByPrimaryKey(id);
        GardenStuffDOExample example = new GardenStuffDOExample();
        example.createCriteria().andGardenstuffPeasantidEqualTo(id);
        gardenStuffMapper.deleteByExample(example);
    }

    @Override
    public void batchesDelPeasant(List<String> deleteId) throws MessageException {
        PeasantDOExample peasantDOExample = new PeasantDOExample();
        peasantDOExample.createCriteria().andPeasantIdIn(deleteId);
        peasantMapper.deleteByExample(peasantDOExample);
        UserDOExample userDOExample = new UserDOExample();
        userDOExample.createCriteria().andUseridIn(deleteId);
        userMapper.deleteByExample(userDOExample);
    }

}
