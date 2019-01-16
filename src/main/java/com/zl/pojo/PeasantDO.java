package com.zl.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PeasantDO {
    private String peasantId;

    private String peasantName;

    private String peasantIdentity;

    private String peasantPhone;

    private String peasantAddress;

    private Integer peasantStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date peasantTime;

    public String getPeasantId() {
        return peasantId;
    }

    public void setPeasantId(String peasantId) {
        this.peasantId = peasantId == null ? null : peasantId.trim();
    }

    public String getPeasantName() {
        return peasantName;
    }

    public void setPeasantName(String peasantName) {
        this.peasantName = peasantName == null ? null : peasantName.trim();
    }

    public String getPeasantIdentity() {
        return peasantIdentity;
    }

    public void setPeasantIdentity(String peasantIdentity) {
        this.peasantIdentity = peasantIdentity == null ? null : peasantIdentity.trim();
    }

    public String getPeasantPhone() {
        return peasantPhone;
    }

    public void setPeasantPhone(String peasantPhone) {
        this.peasantPhone = peasantPhone == null ? null : peasantPhone.trim();
    }

    public String getPeasantAddress() {
        return peasantAddress;
    }

    public void setPeasantAddress(String peasantAddress) {
        this.peasantAddress = peasantAddress == null ? null : peasantAddress.trim();
    }

    public Integer getPeasantStatus() {
        return peasantStatus;
    }

    public void setPeasantStatus(Integer peasantStatus) {
        this.peasantStatus = peasantStatus;
    }

    public Date getPeasantTime() {
        return peasantTime;
    }

    public void setPeasantTime(Date peasantTime) {
        this.peasantTime = peasantTime;
    }

    @Override
    public String toString() {
        return "PeasantDO{" +
                "peasantId='" + peasantId + '\'' +
                ", peasantName='" + peasantName + '\'' +
                ", peasantIdentity='" + peasantIdentity + '\'' +
                ", peasantPhone='" + peasantPhone + '\'' +
                ", peasantAddress='" + peasantAddress + '\'' +
                ", peasantStatus=" + peasantStatus +
                ", peasantTime=" + peasantTime +
                '}';
    }
}