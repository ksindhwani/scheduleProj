package com.expedia.chilka.services;

import com.expedia.chilka.models.Report;
import com.expedia.chilka.models.ReportStatistics;
import com.expedia.chilka.utils.DateRangeUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportService.class);

    private final DisputeStatisticService disputeStatisticService;

    private final AutoImportStatisticsService autoImportStatisticsService;

    private final ObjectMapper objectMapper;

    @Autowired
    public ReportService(DisputeStatisticService disputeStatisticService, AutoImportStatisticsService autoImportStatisticsService, ObjectMapper objectMapper) {
        this.disputeStatisticService = disputeStatisticService;
        this.autoImportStatisticsService = autoImportStatisticsService;
        this.objectMapper = objectMapper;
    }

    @Scheduled(cron = "00 10 00 * * MON")
    public void buildReport() throws JsonProcessingException {
        List<Pair<Date, Date>> weekDateRanges = DateRangeUtils.weekDateRanges();
        Report report = buildReportWithWeeks(weekDateRanges);
        String reportJson = objectMapper.writeValueAsString(report);
    }

    public Report buildReportWithWeeks(List<Pair<Date, Date>> weekDateRanges) throws JsonProcessingException {
        ReportStatistics reportStatistics = new ReportStatistics();
        reportStatistics.setDisputeMatchingStatistics(disputeStatisticService.build(weekDateRanges));
        reportStatistics.setAutoImportStatistics(autoImportStatisticsService.build(weekDateRanges));
        Report report = new Report(reportStatistics);
        LOGGER.info(objectMapper.writeValueAsString(report));
        return report;
    }
}
