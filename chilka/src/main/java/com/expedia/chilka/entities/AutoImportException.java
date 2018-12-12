package com.expedia.chilka.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class AutoImportException {

    @Id
    @Column(name = "AutoImportExceptionID")
    private Integer autoImportExceptionId;

    @Column(name =  "AcquiringBankID")
    private Integer acquiringBankId;

    @Column(name =  "OrderCode")
    private String orderCode;

    @Column(name =  "BankCaseNum")
    private String bankCaseNum;

    @Column(name =  "CreateDate")
    private Date createDate;

    @Column(name =  "ImportRunDate")
    private Date importRunDate;

    @Column(name =  "BankReason")
    private String bankReason;

    @Column(name =  "MerchantID")
    private String merchantId;

    public AutoImportException() {
    }

    public Integer getAutoImportExceptionId() {
        return autoImportExceptionId;
    }

    public void setAutoImportExceptionId(Integer autoImportExceptionId) {
        this.autoImportExceptionId = autoImportExceptionId;
    }

    public Integer getAcquiringBankId() {
        return acquiringBankId;
    }

    public void setAcquiringBankId(Integer acquiringBankId) {
        this.acquiringBankId = acquiringBankId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getBankCaseNum() {
        return bankCaseNum;
    }

    public void setBankCaseNum(String bankCaseNum) {
        this.bankCaseNum = bankCaseNum;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getImportRunDate() {
        return importRunDate;
    }

    public void setImportRunDate(Date importRunDate) {
        this.importRunDate = importRunDate;
    }

    public String getBankReason() {
        return bankReason;
    }

    public void setBankReason(String bankReason) {
        this.bankReason = bankReason;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
}
