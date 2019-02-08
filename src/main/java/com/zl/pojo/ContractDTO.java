package com.zl.pojo;

/**
 * @program: FruitSales
 * @classname: ContractDTO
 * @description: 合同列表展示类
 * @author: 朱林
 * @create: 2019-02-05 15:51
 **/
public class ContractDTO extends ContractDO {

    private String dealerName;

    private String peasantName;

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getPeasantName() {
        return peasantName;
    }

    public void setPeasantName(String peasantName) {
        this.peasantName = peasantName;
    }

    @Override
    public String toString() {
        return "ContractDTO{" +
                "dealerName='" + dealerName + '\'' +
                ", peasantName='" + peasantName + '\'' +
                "} " + super.toString();
    }
}
