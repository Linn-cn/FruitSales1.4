package com.zl.service;

import com.zl.pojo.DealerDO;
import com.zl.util.AjaxPutPage;

import java.util.List;

/**
 * @program: FruitSales
 * @classname: DealerService
 * @description:
 * @author: 朱林
 * @create: 2019-01-19 23:06
 **/
public interface DealerService {

    /**
     * @Description: 返回零售商列表[可带条件]
     * @Param: [ajaxPutPage]
     * @return: java.util.List<com.zl.pojo.PeasantDO>
     * @Author: ZhuLin
     * @Date: 2019/1/13
     */
    List<DealerDO> listDealer(AjaxPutPage<DealerDO> ajaxPutPage);

    /**
     * @Description: 获取返回的零售商总数
     * @Param: []
     * @return: java.lang.Integer
     * @Author: ZhuLin
     * @Date: 2019/1/13
     */
    Long getDealerCount(AjaxPutPage<DealerDO> ajaxPutPage);
}
