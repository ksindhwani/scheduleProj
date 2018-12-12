package com.expedia.chilka.services;

import com.expedia.chilka.models.DisputeMatchingStatistics;
import com.expedia.chilka.models.MetricRecord;
import com.expedia.chilka.models.ReportMetricRecord;
import com.expedia.chilka.repositories.DebitMemoChargebackRepository;
import com.expedia.chilka.repositories.MerchantChargebackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DisputeStatisticService {

    private final MerchantChargebackRepository merchantChargebackRepository;

    private final DebitMemoChargebackRepository debitMemoChargebackRepository;

    @Autowired
    public DisputeStatisticService(MerchantChargebackRepository merchantChargebackRepository, DebitMemoChargebackRepository debitMemoChargebackRepository) {
        this.merchantChargebackRepository = merchantChargebackRepository;
        this.debitMemoChargebackRepository = debitMemoChargebackRepository;
    }

    public DisputeMatchingStatistics build(List<Pair<Date, Date>> weekDateRanges) {
        DisputeMatchingStatistics disputeMatchingStatistics = new DisputeMatchingStatistics();
        disputeMatchingStatistics.setMerchantChargebacks(merchantChargebackReportMetricRecord(weekDateRanges));
        disputeMatchingStatistics.setAllDebitMemoChargebacks(allDebitMemoReportMetricRecord(weekDateRanges));
        disputeMatchingStatistics.setGsoDebitMemoChargebacks(gsoDebitMemoChargebackReportMetricRecord(weekDateRanges));
        disputeMatchingStatistics.setDebitMemoChargebacks(debitMemoChargebackReportMetricRecord(weekDateRanges));
        return disputeMatchingStatistics;
    }

    public ReportMetricRecord merchantChargebackReportMetricRecord(List<Pair<Date, Date>> weekDateRanges) {
        Pair<Date, Date> currentWeekRange = weekDateRanges.get(0);
        Pair<Date, Date> previousWeekRange = weekDateRanges.get(1);
        Pair<Date, Date> lastToLastWeekRange = weekDateRanges.get(2);
        ReportMetricRecord reportMetricRecord = new ReportMetricRecord();
        reportMetricRecord.setCurrentWeekMetric(metricRecordMerchantChargebackForWeek(currentWeekRange));
        reportMetricRecord.setPreviousWeekMetric(metricRecordMerchantChargebackForWeek(previousWeekRange));
        reportMetricRecord.setLastToLastWeekMetric(metricRecordMerchantChargebackForWeek(lastToLastWeekRange));
        return reportMetricRecord;
    }


    public ReportMetricRecord allDebitMemoReportMetricRecord(List<Pair<Date, Date>> weekDateRanges) {
        Pair<Date, Date> currentWeekRange = weekDateRanges.get(0);
        Pair<Date, Date> previousWeekRange = weekDateRanges.get(1);
        Pair<Date, Date> lastToLastWeekRange = weekDateRanges.get(2);
        ReportMetricRecord reportMetricRecord = new ReportMetricRecord();
        reportMetricRecord.setCurrentWeekMetric(metricRecordAllDebitMemoForWeek(currentWeekRange));
        reportMetricRecord.setPreviousWeekMetric(metricRecordAllDebitMemoForWeek(previousWeekRange));
        reportMetricRecord.setLastToLastWeekMetric(metricRecordAllDebitMemoForWeek(lastToLastWeekRange));
        return reportMetricRecord;
    }

    public ReportMetricRecord gsoDebitMemoChargebackReportMetricRecord(List<Pair<Date, Date>> weekDateRanges) {
        Pair<Date, Date> currentWeekRange = weekDateRanges.get(0);
        Pair<Date, Date> previousWeekRange = weekDateRanges.get(1);
        Pair<Date, Date> lastToLastWeekRange = weekDateRanges.get(2);
        ReportMetricRecord reportMetricRecord = new ReportMetricRecord();
        reportMetricRecord.setCurrentWeekMetric(metricRecordGsoDebitMemoForWeek(currentWeekRange));
        reportMetricRecord.setPreviousWeekMetric(metricRecordGsoDebitMemoForWeek(previousWeekRange));
        reportMetricRecord.setLastToLastWeekMetric(metricRecordGsoDebitMemoForWeek(lastToLastWeekRange));
        return reportMetricRecord;
    }

    public ReportMetricRecord debitMemoChargebackReportMetricRecord(List<Pair<Date, Date>> weekDateRanges) {
        Pair<Date, Date> currentWeekRange = weekDateRanges.get(0);
        Pair<Date, Date> previousWeekRange = weekDateRanges.get(1);
        Pair<Date, Date> lastToLastWeekRange = weekDateRanges.get(2);
        ReportMetricRecord reportMetricRecord = new ReportMetricRecord();
        reportMetricRecord.setCurrentWeekMetric(metricRecordDebitMemoForWeek(currentWeekRange));
        reportMetricRecord.setPreviousWeekMetric(metricRecordDebitMemoForWeek(previousWeekRange));
        reportMetricRecord.setLastToLastWeekMetric(metricRecordDebitMemoForWeek(lastToLastWeekRange));
        return reportMetricRecord;
    }

    private MetricRecord metricRecordMerchantChargebackForWeek(Pair<Date, Date> week) {
        Integer unmatched = merchantChargebackRepository.countAllByCreateDateBetweenAndDisputeClientIdAndMatchingSourceId(week.getFirst(), week.getSecond(), 0, 0);
        Integer matched = merchantChargebackRepository.countAllByCreateDateBetweenAndDisputeClientIdAndMatchingSourceId(week.getFirst(), week.getSecond(), 0, 2);
        return new MetricRecord(matched, unmatched + matched);
    }

    private MetricRecord metricRecordGsoDebitMemoForWeek(Pair<Date, Date> week) {
        Integer unmatched = debitMemoChargebackRepository.countAllByCreateDateBetweenAndDebitMemoTypeIdAndMatchingSourceId(week.getFirst(), week.getSecond(), 2, 0);
        Integer matched = debitMemoChargebackRepository.countAllByCreateDateBetweenAndDebitMemoTypeIdAndMatchingSourceId(week.getFirst(), week.getSecond(), 2, 2);
        return new MetricRecord(matched, unmatched + matched);
    }

    private MetricRecord metricRecordDebitMemoForWeek(Pair<Date, Date> week) {
        Integer unmatched = debitMemoChargebackRepository.countAllByCreateDateBetweenAndDebitMemoTypeIdAndMatchingSourceId(week.getFirst(), week.getSecond(), 1, 0);
        Integer matched = debitMemoChargebackRepository.countAllByCreateDateBetweenAndDebitMemoTypeIdAndMatchingSourceId(week.getFirst(), week.getSecond(), 1, 2);
        return new MetricRecord(matched, unmatched + matched);
    }

    private MetricRecord metricRecordAllDebitMemoForWeek(Pair<Date, Date> week) {
        Integer unmatched = debitMemoChargebackRepository.countAllByCreateDateBetweenAndMatchingSourceId(week.getFirst(), week.getSecond(), 0);
        Integer matched = debitMemoChargebackRepository.countAllByCreateDateBetweenAndMatchingSourceId(week.getFirst(), week.getSecond(), 2);
        return new MetricRecord(matched, unmatched + matched);
    }
}
