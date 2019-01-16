package com.zl.util;

import com.zl.pojo.DealerDO;
import com.zl.pojo.PeasantDO;
import com.zl.pojo.UserDTO;

/**
 * @program: FruitSales
 * @description: 类copy工具类
 * @author: ZhuLlin
 * @create: 2019-01-08 16:41
 **/
public class BeanCopyPropertiesUtil {

    /** 
    * @Description: 农民信息用户类Copy
    * @Param: [peasant, userinfo]
    * @return: void 
    * @Author: ZhuLin
    * @Date: 2019/1/8 
    */ 
    public static void peasantCopyProperties(PeasantDO peasant, UserDTO userinfo){
        userinfo.setName(peasant.getPeasantName());
        userinfo.setAddress(peasant.getPeasantAddress());
        userinfo.setIdentity(peasant.getPeasantIdentity());
        userinfo.setPhone(peasant.getPeasantPhone());
        userinfo.setStatus(peasant.getPeasantStatus());
        userinfo.setTime(peasant.getPeasantTime());
    }

    /**
     * @Description: 零售商信息用户类Copy
     * @Param: [DealerDO, userinfo]
     * @return: void
     * @Author: ZhuLin
     * @Date: 2019/1/8
     */
    public static void dealerCopyProperties(DealerDO dealer, UserDTO userinfo){
        userinfo.setName(dealer.getDealerName());
        userinfo.setAddress(dealer.getDealerAddress());
        userinfo.setPhone(dealer.getDealerPhone());
        userinfo.setStatus(dealer.getDealerStatus());
        userinfo.setTime(dealer.getDealerTime());
    }
}
