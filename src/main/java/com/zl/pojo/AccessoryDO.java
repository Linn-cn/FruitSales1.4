package com.zl.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class AccessoryDO {
    private String accessoryId;

    private String gardenstuffId;

    private String accessoryName;

    private BigDecimal accessoryPrice;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")    //将String转换成Date,一般前台给后台传值时用
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")    //将Date转换成String,一般后台传值给前台时
    private Date accessoryTime;

    public String getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(String accessoryId) {
        this.accessoryId = accessoryId == null ? null : accessoryId.trim();
    }

    public String getGardenstuffId() {
        return gardenstuffId;
    }

    public void setGardenstuffId(String gardenstuffId) {
        this.gardenstuffId = gardenstuffId == null ? null : gardenstuffId.trim();
    }

    public String getAccessoryName() {
        return accessoryName;
    }

    public void setAccessoryName(String accessoryName) {
        this.accessoryName = accessoryName == null ? null : accessoryName.trim();
    }

    public BigDecimal getAccessoryPrice() {
        return accessoryPrice;
    }

    public void setAccessoryPrice(BigDecimal accessoryPrice) {
        this.accessoryPrice = accessoryPrice;
    }

    public Date getAccessoryTime() {
        return accessoryTime;
    }

    public void setAccessoryTime(Date accessoryTime) {
        this.accessoryTime = accessoryTime;
    }
}