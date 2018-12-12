package com.expedia.chilka.utils;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateRangeUtils {

    public static List<Pair<Date, Date>> weekDateRanges() {
        Date currentWeek = new Date();
        List<Pair<Date, Date>> dateRanges = new ArrayList<>();
        Pair<Date, Date> currentWeekRange = weekRange(currentWeek);
        Pair<Date, Date> previousWeekRange = weekRange(currentWeekRange.getFirst());
        Pair<Date, Date> lastToLastWeekRange = weekRange(previousWeekRange.getFirst());
        dateRanges.add(currentWeekRange);
        dateRanges.add(previousWeekRange);
        dateRanges.add(lastToLastWeekRange);
        return dateRanges;
    }

    private static Pair<Date,Date> weekRange(Date currentWeek) {
        return Pair.of(DateUtils.addDays(currentWeek, -7), currentWeek);
    }
}
