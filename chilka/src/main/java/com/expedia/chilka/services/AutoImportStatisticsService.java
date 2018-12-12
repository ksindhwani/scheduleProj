package com.expedia.chilka.services;

import com.expedia.chilka.entities.AutoImportException;
import com.expedia.chilka.entities.Dispute;
import com.expedia.chilka.models.AutoImportStatistics;
import com.expedia.chilka.models.MetricRecord;
import com.expedia.chilka.models.ReportMetricRecord;
import com.expedia.chilka.repositories.AutoImportExceptionRepository;
import com.expedia.chilka.repositories.DebitMemoChargebackRepository;
import com.expedia.chilka.repositories.DebitMemoExceptionRepository;
import com.expedia.chilka.repositories.MerchantChargebackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class AutoImportStatisticsService {

    private final DebitMemoChargebackRepository debitMemoChargebackRepository;

    private final DebitMemoExceptionRepository debitMemoExceptionRepository;

    private final MerchantChargebackRepository merchantChargebackRepository;

    private final AutoImportExceptionRepository autoImportExceptionRepository;

    @Autowired
    public AutoImportStatisticsService(DebitMemoChargebackRepository debitMemoChargebackRepository,
                                       DebitMemoExceptionRepository debitMemoExceptionRepository,
                                       MerchantChargebackRepository merchantChargebackRepository,
                                       AutoImportExceptionRepository autoImportExceptionRepository) {
        this.debitMemoChargebackRepository = debitMemoChargebackRepository;
        this.debitMemoExceptionRepository = debitMemoExceptionRepository;
        this.merchantChargebackRepository = merchantChargebackRepository;
        this.autoImportExceptionRepository = autoImportExceptionRepository;
    }

    public AutoImportStatistics build(List<Pair<Date, Date>> weekDateRanges) {
        AutoImportStatistics autoImportStatistics = new AutoImportStatistics();
        autoImportStatistics.setPaypal(getReportMetricRecordByAcquiringBankId(weekDateRanges, 10));
        autoImportStatistics.setPaymenttech(getReportMetricRecordByAcquiringBankId(weekDateRanges, 5));
        autoImportStatistics.setWorldPay(getReportMetricRecordByAcquiringBankId(weekDateRanges, 4));
        autoImportStatistics.setAmericanExpress(getReportMetricRecordByAcquiringBankId(weekDateRanges, 1));
        autoImportStatistics.setOverAllAutoImportStatus(overAllReportMetricRecord(weekDateRanges));
        autoImportStatistics.setAllDebitMemos(allDebitMemosReportMetricRecord(weekDateRanges));
        return autoImportStatistics;
    }

    private ReportMetricRecord allDebitMemosReportMetricRecord(List<Pair<Date, Date>> weekDateRanges) {
        Pair<Date, Date> currentWeekRange = weekDateRanges.get(0);
        Pair<Date, Date> previousWeekRange = weekDateRanges.get(1);
        Pair<Date, Date> lastToLastWeekRange = weekDateRanges.get(2);
        ReportMetricRecord reportMetricRecord = new ReportMetricRecord();
        reportMetricRecord.setCurrentWeekMetric(allDebitMemosMetricRecord(currentWeekRange));
        reportMetricRecord.setPreviousWeekMetric(overAllMetricRecordForWeek(previousWeekRange));
        reportMetricRecord.setLastToLastWeekMetric(overAllMetricRecordForWeek(lastToLastWeekRange));
        return reportMetricRecord;
    }

    private MetricRecord allDebitMemosMetricRecord(Pair<Date, Date> week) {
        Integer debitMemoCount = debitMemoChargebackRepository.countAllByCreateDateBetween(week.getFirst(), week.getSecond());
        Integer exceptions = debitMemoExceptionRepository.countAllByCreateDateBetween(week.getFirst(), week.getSecond());
        return new MetricRecord(debitMemoCount, debitMemoCount + exceptions);
    }

    private ReportMetricRecord overAllReportMetricRecord(List<Pair<Date, Date>> weekDateRanges) {
        Pair<Date, Date> currentWeekRange = weekDateRanges.get(0);
        Pair<Date, Date> previousWeekRange = weekDateRanges.get(1);
        Pair<Date, Date> lastToLastWeekRange = weekDateRanges.get(2);
        ReportMetricRecord reportMetricRecord = new ReportMetricRecord();
        reportMetricRecord.setCurrentWeekMetric(overAllMetricRecordForWeek(currentWeekRange));
        reportMetricRecord.setPreviousWeekMetric(overAllMetricRecordForWeek(previousWeekRange));
        reportMetricRecord.setLastToLastWeekMetric(overAllMetricRecordForWeek(lastToLastWeekRange));
        return reportMetricRecord;
    }


    private ReportMetricRecord getReportMetricRecordByAcquiringBankId(List<Pair<Date, Date>> weekDateRanges, Integer acquiringBankId) {
        Pair<Date, Date> currentWeekRange = weekDateRanges.get(0);
        Pair<Date, Date> previousWeekRange = weekDateRanges.get(1);
        Pair<Date, Date> lastToLastWeekRange = weekDateRanges.get(2);
        ReportMetricRecord reportMetricRecord = new ReportMetricRecord();
        reportMetricRecord.setCurrentWeekMetric(findMetricRecordForWeekByAcquiringBankId(currentWeekRange, acquiringBankId));
        reportMetricRecord.setPreviousWeekMetric(findMetricRecordForWeekByAcquiringBankId(previousWeekRange, acquiringBankId));
        reportMetricRecord.setLastToLastWeekMetric(findMetricRecordForWeekByAcquiringBankId(lastToLastWeekRange, acquiringBankId));
        return reportMetricRecord;
    }

    private MetricRecord findMetricRecordForWeekByAcquiringBankId(Pair<Date, Date> week, Integer acquiringBankId) {
        Integer disputeCount = merchantChargebackRepository.countAllByCreateDateBetweenAndAcquiringBankId(week.getFirst(), week.getSecond(), acquiringBankId);
        Integer exceptions = autoImportExceptionRepository.countAllByCreateDateBetweenAndAcquiringBankId(week.getFirst(), week.getSecond(), acquiringBankId);
        return new MetricRecord(disputeCount, exceptions + disputeCount);
    }

    private MetricRecord overAllMetricRecordForWeek(Pair<Date, Date> week) {
        HashSet<Integer> acquiringBanks = new HashSet<>(Arrays.asList(1, 4, 5, 10));
        List<Dispute> successCreatedDisputes = merchantChargebackRepository.findAllByCreateDateBetween(week.getFirst(), week.getSecond());
        List<AutoImportException> disputeExceptions = autoImportExceptionRepository.findAllByCreateDateBetween(week.getFirst(), week.getSecond());
        Long disputeCount = successCreatedDisputes
                .stream()
                .filter(dispute -> acquiringBanks.contains(dispute.getAcquiringBankId()))
                .count();
        Long exceptions = disputeExceptions
                .stream()
                .filter(autoImportException -> acquiringBanks.contains(autoImportException.getAcquiringBankId()))
                .count();

        Integer debitMemoCount = debitMemoChargebackRepository.countAllByCreateDateBetween(week.getFirst(), week.getSecond());
        Integer debitMemoExceptionCount = debitMemoExceptionRepository.countAllByCreateDateBetween(week.getFirst(), week.getSecond());
        Integer success = disputeCount.intValue() + debitMemoCount;
        Integer failure = exceptions.intValue() + debitMemoExceptionCount;
        return new MetricRecord(success, success + failure);
    }
}
