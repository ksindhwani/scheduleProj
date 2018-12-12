package com.expedia.chilka.models;

public class ReportMetricRecord {

    private MetricRecord currentWeekMetric;

    private MetricRecord previousWeekMetric;

    private MetricRecord lastToLastWeekMetric;

    public ReportMetricRecord() {
    }

    public MetricRecord getCurrentWeekMetric() {
        return currentWeekMetric;
    }

    public MetricRecord getPreviousWeekMetric() {
        return previousWeekMetric;
    }

    public MetricRecord getLastToLastWeekMetric() {
        return lastToLastWeekMetric;
    }

    public void setCurrentWeekMetric(MetricRecord currentWeekMetric) {
        this.currentWeekMetric = currentWeekMetric;
    }

    public void setPreviousWeekMetric(MetricRecord previousWeekMetric) {
        this.previousWeekMetric = previousWeekMetric;
    }

    public void setLastToLastWeekMetric(MetricRecord lastToLastWeekMetric) {
        this.lastToLastWeekMetric = lastToLastWeekMetric;
    }

    @Override
    public String toString() {
        return "ReportMetricRecord{" +
                "currentWeekMetric=" + currentWeekMetric +
                ", previousWeekMetric=" + previousWeekMetric +
                ", lastToLastWeekMetric=" + lastToLastWeekMetric +
                '}';
    }
}
