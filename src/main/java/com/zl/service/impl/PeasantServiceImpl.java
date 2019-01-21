package com.zl.service.impl;

import com.zl.mapper.PeasantMapper;
import com.zl.mapper.UserMapper;
import com.zl.pojo.PeasantDO;
import com.zl.pojo.PeasantDOExample;
import com.zl.pojo.UserDOExample;
import com.zl.service.PeasantService;
import com.zl.util.AjaxPutPage;
import com.zl.util.MessageException;
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
 * @create: 2019-01-13 18:06
 **/
@Service
public class PeasantServiceImpl implements PeasantService {

    @Autowired
    private PeasantMapper peasantMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<PeasantDO> listPeasant(AjaxPutPage<PeasantDO> ajaxPutPage) {
        return peasantMapper.listPeasant(ajaxPutPage);
    }

    @Override
    public Long getPeasantCount(AjaxPutPage<PeasantDO> ajaxPutPage) {
        return peasantMapper.getPeasantCount(ajaxPutPage);
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
    public void insertPeasant(PeasantDO peasantDO) throws MessageException {
        peasantDO.setPeasantTime(new Timestamp(new Date().getTime()));
        peasantMapper.insertSelective(peasantDO);
    }

    @Override
    public void deletePeasant(String id) throws MessageException {
        peasantMapper.deleteByPrimaryKey(id);
        userMapper.deleteByPrimaryKey(id);
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
