package com.zl.mapper;

import com.zl.pojo.DealerDO;
import com.zl.pojo.DealerDOExample;
import java.util.List;

import com.zl.util.AjaxPutPage;
import org.apache.ibatis.annotations.Param;

public interface DealerMapper {
    int countByExample(DealerDOExample example);

    int deleteByExample(DealerDOExample example);

    int deleteByPrimaryKey(String dealerId);

    int insert(DealerDO record);

    int insertSelective(DealerDO record);

    List<DealerDO> selectByExample(DealerDOExample example);

    DealerDO selectByPrimaryKey(String dealerId);

    int updateByExampleSelective(@Param("record") DealerDO record, @Param("example") DealerDOExample example);

    int updateByExample(@Param("record") DealerDO record, @Param("example") DealerDOExample example);

    int updateByPrimaryKeySelective(DealerDO record);

    int updateByPrimaryKey(DealerDO record);

    /**
     * @Description: 返回零售商列表[可带条件]
     * @Param: [ajaxPutPage]
     * @return: java.util.List<com.zl.pojo.PeasantDO>
     * @Author: ZhuLin
     * @Date: 2019/1/13
     */
    List<DealerDO> listDealer(AjaxPutPage<DealerDO> ajaxPutPage);

    /**
     * @Description: 返回零售商总条数
     * @Param: []
     * @return: java.lang.Long
     * @Author: ZhuLin
     * @Date: 2019/1/13
     */
    Integer getDealerCount();

    /**
     * @Description: 返回零售商列表[可带条件][总行数]
     * @Param: [ajaxPutPage]
     * @return: java.lang.Integer
     * @date: 2019/2/26 22:28 
     */
    Integer listDealerCount(AjaxPutPage<DealerDO> ajaxPutPage);
}