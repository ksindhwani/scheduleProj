package com.expedia.chilka.models;

public class MetricRecord {

    private final Integer requestCount;

    private final Integer totalCount;

    private final Double percentage;

    public MetricRecord(Integer requestCount, Integer totalCount) {
        this.requestCount = requestCount;
        this.totalCount = totalCount;
        this.percentage = (requestCount * 100.0) / totalCount;
    }

    public Integer getRequestCount() {
        return requestCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public Double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return "MetricRecord{" +
                "requestCount=" + requestCount +
                ", totalCount=" + totalCount +
                ", percentage=" + percentage +
                '}';
    }
}
