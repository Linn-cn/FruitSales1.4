package com.zl.pojo;

public class MiddleDO {
    private String middleId;

    private String contractId;

    private String gardenstuffId;

    private Integer number;

    public String getMiddleId() {
        return middleId;
    }

    public void setMiddleId(String middleId) {
        this.middleId = middleId == null ? null : middleId.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getGardenstuffId() {
        return gardenstuffId;
    }

    public void setGardenstuffId(String gardenstuffId) {
        this.gardenstuffId = gardenstuffId == null ? null : gardenstuffId.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "MiddleDO{" +
                "middleId='" + middleId + '\'' +
                ", contractId='" + contractId + '\'' +
                ", gardenstuffId='" + gardenstuffId + '\'' +
                ", number=" + number +
                '}';
    }
}