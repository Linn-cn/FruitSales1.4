package com.zl.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class GardenStuffDO {
    private String gardenstuffId;

    private String gardenstuffPeasantid;

    private String gardenstuffName;

    private BigDecimal gardenstuffPrice;

    private String gardenstuffCategory;

    private String gardenstuffCategoryname;

    private Integer gardenstuffNumber;

    private String gardenstuffAddress;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gardenstuffTime;

    public String getGardenstuffId() {
        return gardenstuffId;
    }

    public void setGardenstuffId(String gardenstuffId) {
        this.gardenstuffId = gardenstuffId == null ? null : gardenstuffId.trim();
    }

    public String getGardenstuffPeasantid() {
        return gardenstuffPeasantid;
    }

    public void setGardenstuffPeasantid(String gardenstuffPeasantid) {
        this.gardenstuffPeasantid = gardenstuffPeasantid == null ? null : gardenstuffPeasantid.trim();
    }

    public String getGardenstuffName() {
        return gardenstuffName;
    }

    public void setGardenstuffName(String gardenstuffName) {
        this.gardenstuffName = gardenstuffName == null ? null : gardenstuffName.trim();
    }

    public BigDecimal getGardenstuffPrice() {
        return gardenstuffPrice;
    }

    public void setGardenstuffPrice(BigDecimal gardenstuffPrice) {
        this.gardenstuffPrice = gardenstuffPrice;
    }

    public String getGardenstuffCategory() {
        return gardenstuffCategory;
    }

    public void setGardenstuffCategory(String gardenstuffCategory) {
        this.gardenstuffCategory = gardenstuffCategory == null ? null : gardenstuffCategory.trim();
    }

    public String getGardenstuffCategoryname() {
        return gardenstuffCategoryname;
    }

    public void setGardenstuffCategoryname(String gardenstuffCategoryname) {
        this.gardenstuffCategoryname = gardenstuffCategoryname == null ? null : gardenstuffCategoryname.trim();
    }

    public Integer getGardenstuffNumber() {
        return gardenstuffNumber;
    }

    public void setGardenstuffNumber(Integer gardenstuffNumber) {
        this.gardenstuffNumber = gardenstuffNumber;
    }

    public String getGardenstuffAddress() {
        return gardenstuffAddress;
    }

    public void setGardenstuffAddress(String gardenstuffAddress) {
        this.gardenstuffAddress = gardenstuffAddress == null ? null : gardenstuffAddress.trim();
    }

    public Date getGardenstuffTime() {
        return gardenstuffTime;
    }

    public void setGardenstuffTime(Date gardenstuffTime) {
        this.gardenstuffTime = gardenstuffTime;
    }

    @Override
    public String toString() {
        return "GardenStuffDO{" +
                "gardenstuffId='" + gardenstuffId + '\'' +
                ", gardenstuffPeasantid='" + gardenstuffPeasantid + '\'' +
                ", gardenstuffName='" + gardenstuffName + '\'' +
                ", gardenstuffPrice=" + gardenstuffPrice +
                ", gardenstuffCategory='" + gardenstuffCategory + '\'' +
                ", gardenstuffCategoryname='" + gardenstuffCategoryname + '\'' +
                ", gardenstuffNumber=" + gardenstuffNumber +
                ", gardenstuffAddress='" + gardenstuffAddress + '\'' +
                ", gardenstuffTime=" + gardenstuffTime +
                '}';
    }
}