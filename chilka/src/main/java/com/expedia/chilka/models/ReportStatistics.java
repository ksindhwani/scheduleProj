package com.expedia.chilka.models;

public class ReportStatistics {

    private DisputeMatchingStatistics disputeMatchingStatistics;

    private AutoImportStatistics autoImportStatistics;

    public ReportStatistics() {
    }

    public DisputeMatchingStatistics getDisputeMatchingStatistics() {
        return disputeMatchingStatistics;
    }

    public void setDisputeMatchingStatistics(DisputeMatchingStatistics disputeMatchingStatistics) {
        this.disputeMatchingStatistics = disputeMatchingStatistics;
    }

    public AutoImportStatistics getAutoImportStatistics() {
        return autoImportStatistics;
    }

    public void setAutoImportStatistics(AutoImportStatistics autoImportStatistics) {
        this.autoImportStatistics = autoImportStatistics;
    }

    @Override
    public String toString() {
        return "ReportStatistics{" +
                "disputeMatchingStatistics=" + disputeMatchingStatistics +
                ", autoImportStatistics=" + autoImportStatistics +
                '}';
    }
}
