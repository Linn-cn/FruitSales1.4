package com.zl.pojo;

import java.util.List;

/**
 * @program: FruitSales
 * @classname: GardenStuffVO
 * @description:
 * @author: 朱林
 * @create: 2019-02-08 11:14
 **/
public class GardenStuffVO extends GardenStuffDO {

    private List<AccessoryDO> accessoryList;

    public List<AccessoryDO> getAccessoryList() {
        return accessoryList;
    }

    public void setAccessoryList(List<AccessoryDO> accessoryList) {
        this.accessoryList = accessoryList;
    }

    @Override
    public String toString() {
        return "GardenStuffVO{" +
                "accessoryList=" + accessoryList +
                "} " + super.toString();
    }
}
