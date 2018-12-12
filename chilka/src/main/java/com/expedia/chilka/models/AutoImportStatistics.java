package com.expedia.chilka.models;

public class AutoImportStatistics {

    private ReportMetricRecord overAllAutoImportStatus;
    private ReportMetricRecord allDebitMemos;
    private ReportMetricRecord americanExpress;
    private ReportMetricRecord worldPay;
    private ReportMetricRecord paymenttech;
    private ReportMetricRecord paypal;

    public AutoImportStatistics() {
    }

    public ReportMetricRecord getOverAllAutoImportStatus() {
        return overAllAutoImportStatus;
    }

    public void setOverAllAutoImportStatus(ReportMetricRecord overAllAutoImportStatus) {
        this.overAllAutoImportStatus = overAllAutoImportStatus;
    }

    public ReportMetricRecord getAllDebitMemos() {
        return allDebitMemos;
    }

    public void setAllDebitMemos(ReportMetricRecord allDebitMemos) {
        this.allDebitMemos = allDebitMemos;
    }

    public ReportMetricRecord getAmericanExpress() {
        return americanExpress;
    }

    public void setAmericanExpress(ReportMetricRecord americanExpress) {
        this.americanExpress = americanExpress;
    }

    public ReportMetricRecord getWorldPay() {
        return worldPay;
    }

    public void setWorldPay(ReportMetricRecord worldPay) {
        this.worldPay = worldPay;
    }

    public ReportMetricRecord getPaymenttech() {
        return paymenttech;
    }

    public void setPaymenttech(ReportMetricRecord paymenttech) {
        this.paymenttech = paymenttech;
    }

    public ReportMetricRecord getPaypal() {
        return paypal;
    }

    public void setPaypal(ReportMetricRecord paypal) {
        this.paypal = paypal;
    }

    @Override
    public String toString() {
        return "AutoImportStatistics{" +
                "overAllAutoImportStatus=" + overAllAutoImportStatus +
                ", allDebitMemos=" + allDebitMemos +
                ", americanExpress=" + americanExpress +
                ", worldPay=" + worldPay +
                ", paymenttech=" + paymenttech +
                ", paypal=" + paypal +
                '}';
    }
}
