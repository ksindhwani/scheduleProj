package com.expedia.chilka.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
public class DebitMemo {

    @Id
    @Column(name = "DMDisputeID")
    private BigInteger debitMemoId;

    @Column(name = "MatchingSourceID")
    private Integer matchingSourceId;

    @Column(name = "DebitMemoTypeID")
    private Integer debitMemoTypeId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreateDate")
    private Date createDate;

    public DebitMemo() {
    }

    public BigInteger getDebitMemoId() {
        return debitMemoId;
    }

    public void setDebitMemoId(BigInteger debitMemoId) {
        this.debitMemoId = debitMemoId;
    }

    public Integer getMatchingSourceId() {
        return matchingSourceId;
    }

    public void setMatchingSourceId(Integer matchingSourceId) {
        this.matchingSourceId = matchingSourceId;
    }

    public Integer getDebitMemoTypeId() {
        return debitMemoTypeId;
    }

    public void setDebitMemoTypeId(Integer debitMemoTypeId) {
        this.debitMemoTypeId = debitMemoTypeId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
