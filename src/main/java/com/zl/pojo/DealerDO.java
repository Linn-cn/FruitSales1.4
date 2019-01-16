package com.zl.pojo;

import java.util.Date;

public class DealerDO {
    private String dealerId;

    private String dealerName;

    private String dealerPhone;

    private String dealerAddress;

    private Integer dealerStatus;

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
}