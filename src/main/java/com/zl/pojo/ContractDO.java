package com.zl.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ContractDO {
    private String contractId;

    private String peasantId;

    private String dealerId;

    private String barcode;

    private Integer type;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")    //将String转换成Date,一般前台给后台传值时用
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")    //将Date转换成String,一般后台传值给前台时
    private Date createtime;

    private Integer check;

    private BigDecimal contractPrice;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getPeasantId() {
        return peasantId;
    }

    public void setPeasantId(String peasantId) {
        this.peasantId = peasantId == null ? null : peasantId.trim();
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId == null ? null : dealerId.trim();
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
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

    @Override
    public String toString() {
        return "ContractDO{" +
                "contractId='" + contractId + '\'' +
                ", peasantId='" + peasantId + '\'' +
                ", dealerId='" + dealerId + '\'' +
                ", barcode='" + barcode + '\'' +
                ", type=" + type +
                ", createtime=" + createtime +
                ", check=" + check +
                ", contractPrice=" + contractPrice +
                '}';
    }
}