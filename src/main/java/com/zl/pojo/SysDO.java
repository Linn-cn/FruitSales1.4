package com.zl.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SysDO {
    private Integer sysId;

    private String sysVersion;

    private String sysUrl;

    private String sysOperation;

    private String sysRuntime;

    private String sysJdk;

    private String sysMysql;

    private String sysItemsize;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date sysUpdatetime;

    private String sysCopyright;

    private String sysAuthor;

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public String getSysVersion() {
        return sysVersion;
    }

    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion == null ? null : sysVersion.trim();
    }

    public String getSysUrl() {
        return sysUrl;
    }

    public void setSysUrl(String sysUrl) {
        this.sysUrl = sysUrl == null ? null : sysUrl.trim();
    }

    public String getSysOperation() {
        return sysOperation;
    }

    public void setSysOperation(String sysOperation) {
        this.sysOperation = sysOperation == null ? null : sysOperation.trim();
    }

    public String getSysRuntime() {
        return sysRuntime;
    }

    public void setSysRuntime(String sysRuntime) {
        this.sysRuntime = sysRuntime == null ? null : sysRuntime.trim();
    }

    public String getSysJdk() {
        return sysJdk;
    }

    public void setSysJdk(String sysJdk) {
        this.sysJdk = sysJdk == null ? null : sysJdk.trim();
    }

    public String getSysMysql() {
        return sysMysql;
    }

    public void setSysMysql(String sysMysql) {
        this.sysMysql = sysMysql == null ? null : sysMysql.trim();
    }

    public String getSysItemsize() {
        return sysItemsize;
    }

    public void setSysItemsize(String sysItemsize) {
        this.sysItemsize = sysItemsize == null ? null : sysItemsize.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getSysUpdatetime() {
        return sysUpdatetime;
    }

    public void setSysUpdatetime(Date sysUpdatetime) {
        this.sysUpdatetime = sysUpdatetime;
    }

    public String getSysCopyright() {
        return sysCopyright;
    }

    public void setSysCopyright(String sysCopyright) {
        this.sysCopyright = sysCopyright == null ? null : sysCopyright.trim();
    }

    public String getSysAuthor() {
        return sysAuthor;
    }

    public void setSysAuthor(String sysAuthor) {
        this.sysAuthor = sysAuthor == null ? null : sysAuthor.trim();
    }

    @Override
    public String toString() {
        return "SysDO{" +
                "sysId=" + sysId +
                ", sysVersion='" + sysVersion + '\'' +
                ", sysUrl='" + sysUrl + '\'' +
                ", sysOperation='" + sysOperation + '\'' +
                ", sysRuntime='" + sysRuntime + '\'' +
                ", sysJdk='" + sysJdk + '\'' +
                ", sysMysql='" + sysMysql + '\'' +
                ", sysItemsize='" + sysItemsize + '\'' +
                ", sysUpdatetime=" + sysUpdatetime +
                ", sysCopyright='" + sysCopyright + '\'' +
                ", sysAuthor='" + sysAuthor + '\'' +
                '}';
    }
}