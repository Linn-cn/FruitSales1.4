package com.zl.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DealerDO {
    private String dealerId;

    private String dealerName;

    private String dealerPhone;

    private String dealerAddress;

    private Integer dealerStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")    //将String转换成Date,一般前台给后台传值时用
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")    //将Date转换成String,一般后台传值给前台时
    private Date dealerTime;

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId == null ? null : dealerId.trim();
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName == null ? null : dealerName.trim();
    }

    public String getDealerPhone() {
        return dealerPhone;
    }

    public void setDealerPhone(String dealerPhone) {
        this.dealerPhone = dealerPhone == null ? null : dealerPhone.trim();
    }

    public String getDealerAddress() {
        return dealerAddress;
    }

    public void setDealerAddress(String dealerAddress) {
        this.dealerAddress = dealerAddress == null ? null : dealerAddress.trim();
    }

    public Integer getDealerStatus() {
        return dealerStatus;
    }

    public void setDealerStatus(Integer dealerStatus) {
        this.dealerStatus = dealerStatus;
    }

    public Date getDealerTime() {
        return dealerTime;
    }

    public void setDealerTime(Date dealerTime) {
        this.dealerTime = dealerTime;
    }

    @Override
    public String toString() {
        return "DealerDO{" +
                "dealerId='" + dealerId + '\'' +
                ", dealerName='" + dealerName + '\'' +
                ", dealerPhone='" + dealerPhone + '\'' +
                ", dealerAddress='" + dealerAddress + '\'' +
                ", dealerStatus=" + dealerStatus +
                ", dealerTime=" + dealerTime +
                '}';
    }
}