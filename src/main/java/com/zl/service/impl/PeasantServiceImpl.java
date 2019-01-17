package com.zl.service.impl;

import com.zl.mapper.PeasantMapper;
import com.zl.pojo.PeasantDO;
import com.zl.service.PeasantService;
import com.zl.util.AjaxPutPage;
import com.zl.util.MessageException;
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

    @Override
    public List<PeasantDO> listPeasant(AjaxPutPage<PeasantDO> ajaxPutPage) {
        return peasantMapper.listPeasant(ajaxPutPage);
    }

    @Override
    public Integer getPeasantCount(AjaxPutPage<PeasantDO> ajaxPutPage) {
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


}