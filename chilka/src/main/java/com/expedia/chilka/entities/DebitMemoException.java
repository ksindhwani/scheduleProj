package com.expedia.chilka.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Date;

@Entity
public class DebitMemoException {

    @Id
    @Column(name = "DMExceptionId")
    private BigInteger debitMemoExceptionId;

    @Column(name = "DebitMemoNumber")
    private String debitMemoNumber;

    @Column(name = "CarrierNumber")
    private Integer carrierNumber;

    @Column(name = "TicketNumber")
    private String ticketNumber;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ImportRunDate")
    private Date importRunDate;

    @Column(name = "AirSettlementProvider")
    private String airSettlementProvider;

    @Column(name = "dmDisputeId")
    private BigInteger debitMemoId;

    @Column(name = "debitMemoReason")
    private String debitMemoReason;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "IATA")
    private String iata;

    @Column(name = "DebitMemoTypeId")
    private Integer debitMemoTypeId;

    public DebitMemoException() {
    }

    public BigInteger getDebitMemoExceptionId() {
        return debitMemoExceptionId;
    }

    public void setDebitMemoExceptionId(BigInteger debitMemoExceptionId) {
        this.debitMemoExceptionId = debitMemoExceptionId;
    }

    public String getDebitMemoNumber() {
        return debitMemoNumber;
    }

    public void setDebitMemoNumber(String debitMemoNumber) {
        this.debitMemoNumber = debitMemoNumber;
    }

    public Integer getCarrierNumber() {
        return carrierNumber;
    }

    public void setCarrierNumber(Integer carrierNumber) {
        this.carrierNumber = carrierNumber;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
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

    public String getAirSettlementProvider() {
        return airSettlementProvider;
    }

    public void setAirSettlementProvider(String airSettlementProvider) {
        this.airSettlementProvider = airSettlementProvider;
    }

    public BigInteger getDebitMemoId() {
        return debitMemoId;
    }

    public void setDebitMemoId(BigInteger debitMemoId) {
        this.debitMemoId = debitMemoId;
    }

    public String getDebitMemoReason() {
        return debitMemoReason;
    }

    public void setDebitMemoReason(String debitMemoReason) {
        this.debitMemoReason = debitMemoReason;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public Integer getDebitMemoTypeId() {
        return debitMemoTypeId;
    }

    public void setDebitMemoTypeId(Integer debitMemoTypeId) {
        this.debitMemoTypeId = debitMemoTypeId;
    }
}
