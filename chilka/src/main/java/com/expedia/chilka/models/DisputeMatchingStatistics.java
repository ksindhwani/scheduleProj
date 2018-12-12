package com.expedia.chilka.models;

public class DisputeMatchingStatistics {

    private ReportMetricRecord merchantChargebacks;

    private ReportMetricRecord gsoDebitMemoChargebacks;

    private ReportMetricRecord debitMemoChargebacks;

    private ReportMetricRecord allDebitMemoChargebacks;

    public DisputeMatchingStatistics() {
    }

    public ReportMetricRecord getMerchantChargebacks() {
        return merchantChargebacks;
    }

    public void setMerchantChargebacks(ReportMetricRecord merchantChargebacks) {
        this.merchantChargebacks = merchantChargebacks;
    }

    public ReportMetricRecord getGsoDebitMemoChargebacks() {
        return gsoDebitMemoChargebacks;
    }

    public void setGsoDebitMemoChargebacks(ReportMetricRecord gsoDebitMemoChargebacks) {
        this.gsoDebitMemoChargebacks = gsoDebitMemoChargebacks;
    }

    public ReportMetricRecord getDebitMemoChargebacks() {
        return debitMemoChargebacks;
    }

    public void setDebitMemoChargebacks(ReportMetricRecord debitMemoChargebacks) {
        this.debitMemoChargebacks = debitMemoChargebacks;
    }

    public ReportMetricRecord getAllDebitMemoChargebacks() {
        return allDebitMemoChargebacks;
    }

    public void setAllDebitMemoChargebacks(ReportMetricRecord allDebitMemoChargebacks) {
        this.allDebitMemoChargebacks = allDebitMemoChargebacks;
    }

    @Override
    public String toString() {
        return "DisputeMatchingStatistics{" +
                "merchantChargebacks=" + merchantChargebacks +
                ", gsoDebitMemoChargebacks=" + gsoDebitMemoChargebacks +
                ", debitMemoChargebacks=" + debitMemoChargebacks +
                ", allDebitMemoChargebacks=" + allDebitMemoChargebacks +
                '}';
    }
}
