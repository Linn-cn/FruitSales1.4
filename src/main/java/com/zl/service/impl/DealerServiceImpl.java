package com.zl.service.impl;

import com.zl.mapper.DealerMapper;
import com.zl.pojo.DealerDO;
import com.zl.service.DealerService;
import com.zl.util.AjaxPutPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<DealerDO> listDealer(AjaxPutPage<DealerDO> ajaxPutPage) {
        return dealerMapper.listDealer(ajaxPutPage);
    }

    @Override
    public Long getDealerCount(AjaxPutPage<DealerDO> ajaxPutPage) {
        return dealerMapper.getDealerCount(ajaxPutPage);
    }
}
