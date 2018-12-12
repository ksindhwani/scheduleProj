package com.expedia.chilka.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Dispute")
public class Dispute {

    @Id
    @Column(name = "DisputeID")
    private Integer disputeId;

    @Column(name = "MatchingSourceID")
    private Integer matchingSourceId;

    @Column(name = "AcquiringBankID")
    private Integer acquiringBankId;

    @Column(name = "DisputeClientID")
    private Integer disputeClientId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreateDate")
    private Date createDate;

    public Dispute() {
    }

    public Integer getDisputeId() {
        return disputeId;
    }

    public void setDisputeId(Integer disputeId) {
        this.disputeId = disputeId;
    }

    public Integer getMatchingSourceId() {
        return matchingSourceId;
    }

    public void setMatchingSourceId(Integer matchingSourceId) {
        this.matchingSourceId = matchingSourceId;
    }

    public Integer getAcquiringBankId() {
        return acquiringBankId;
    }

    public void setAcquiringBankId(Integer acquiringBankId) {
        this.acquiringBankId = acquiringBankId;
    }

    public Integer getDisputeClientId() {
        return disputeClientId;
    }

    public void setDisputeClientId(Integer disputeClientId) {
        this.disputeClientId = disputeClientId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
