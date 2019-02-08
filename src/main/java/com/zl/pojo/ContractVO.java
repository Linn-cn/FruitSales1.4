package com.zl.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @program: FruitSales
 * @classname: ContractVO
 * @description: 合同详情POJO
 * @author: 朱林
 * @create: 2019-02-08 11:06
 **/
public class ContractVO implements Serializable {

    private String contractId;

    private String barcode;

    private Integer type;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")    //将String转换成Date,一般前台给后台传值时用
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")    //将Date转换成String,一般后台传值给前台时
    private Date createtime;

    private Integer check;

    private BigDecimal contractPrice;

    // 零售商
    private DealerDO dealer;

    // 农民
    private PeasantDO peasant;

    // 果蔬信息
    private List<GardenStuffVO> gardenStuffList;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }

    public BigDecimal getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(BigDecimal contractPrice) {
        this.contractPrice = contractPrice;
    }

    public DealerDO getDealer() {
        return dealer;
    }

    public void setDealer(DealerDO dealer) {
        this.dealer = dealer;
    }

    public PeasantDO getPeasant() {
        return peasant;
    }

    public void setPeasant(PeasantDO peasant) {
        this.peasant = peasant;
    }

    public List<GardenStuffVO> getGardenStuffList() {
        return gardenStuffList;
    }

    public void setGardenStuffList(List<GardenStuffVO> gardenStuffList) {
        this.gardenStuffList = gardenStuffList;
    }
}
