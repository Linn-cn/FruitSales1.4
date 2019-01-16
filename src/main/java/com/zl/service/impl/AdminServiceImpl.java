package com.zl.service.impl;

import com.zl.mapper.PeasantMapper;
import com.zl.pojo.PeasantDO;
import com.zl.service.AdminService;
import com.zl.util.AjaxPutPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: FruitSales
 * @description:
 * @author: ZhuLlin
 * @create: 2019-01-13 18:06
 **/
@Service
public class AdminServiceImpl implements AdminService {

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


}
