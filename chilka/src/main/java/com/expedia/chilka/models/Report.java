package com.expedia.chilka.models;

public class Report {

    private final ReportStatistics reportStatistics;

    public Report(ReportStatistics reportStatistics) {
        this.reportStatistics = reportStatistics;
    }

    public ReportStatistics getReportStatistics() {
        return reportStatistics;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportStatistics=" + reportStatistics +
                '}';
    }
}
