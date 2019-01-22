package com.zl.pojo;

/**
 * @program: FruitSales
 * @description:
 * @author: ZhuLlin
 * @create: 2019-01-22 14:26
 **/
public class GardenStuffDTO extends GardenStuffDO {

    private String peasantName;

    public String getPeasantName() {
        return peasantName;
    }

    public void setPeasantName(String peasantName) {
        this.peasantName = peasantName;
    }

    @Override
    public String toString() {
        return "GardenStuffDTO{" +
                "peasantName='" + peasantName + '\'' +
                "} " + super.toString();
    }
}
