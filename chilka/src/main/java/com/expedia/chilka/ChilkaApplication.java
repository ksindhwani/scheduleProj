package com.expedia.chilka;

import com.expedia.chilka.services.ReportService;
import com.expedia.chilka.utils.DateRangeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.util.Pair;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;
import java.util.List;

@EnableScheduling
@SpringBootApplication
public class ChilkaApplication implements CommandLineRunner  {

    @Autowired
    private ReportService reportService;


    public static void main(String[] args) {
        SpringApplication.run(ChilkaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Pair<Date, Date>> weekDateRanges = DateRangeUtils.weekDateRanges();
        reportService.buildReportWithWeeks(weekDateRanges);
    }
}
