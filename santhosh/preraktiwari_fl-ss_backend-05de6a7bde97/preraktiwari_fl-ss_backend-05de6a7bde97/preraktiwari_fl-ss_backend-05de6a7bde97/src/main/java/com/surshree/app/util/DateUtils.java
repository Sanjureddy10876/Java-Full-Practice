package com.surshree.app.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public enum DateUtils {
    DU;

    //Convert Date to Calendar
    public static Calendar dateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * This method calculates the difference between two dates and returns the difference
     * Calendar,date2 Calendar
     * @return int
     * @throws Exception
     */
    public static int diffDays(Calendar fromDate, Calendar toDate) {
        int day2 = toDate.get(Calendar.DAY_OF_YEAR);
        int day1 = fromDate.get(Calendar.DAY_OF_YEAR);
        int year2 = toDate.get(Calendar.YEAR);
        int year1 = fromDate.get(Calendar.YEAR);

        int intNoOfDaysInTheYear = 0;
        int intTotalNoOfDays = 0;
        int intDiffInYears = 0;
        int diff = 0;
        GregorianCalendar gcal = new GregorianCalendar();
        intDiffInYears = year2 - year1;

        if (intDiffInYears >= 0) {
            for (int i = 1; i <= intDiffInYears; i++) {
                intNoOfDaysInTheYear = 365;

                if (gcal.isLeapYear(year2 - i)) {
                    intNoOfDaysInTheYear = 366;
                }
                intTotalNoOfDays += intNoOfDaysInTheYear;
            }
            diff = day2 - day1;
            diff += intTotalNoOfDays;
        } else {
            diff = -1;
        }

        return diff;
    }

    /**
     * This method calculates the difference between two dates and returns the difference
     *
     *            Date,date2 Date
     * @return int
     * @throws Exception
     */
    public static int diffDays(Date fromDate, Date toDate) {
        Calendar c1 = new GregorianCalendar();
        c1.setTime(fromDate);

        Calendar c2 = new GregorianCalendar();
        c2.setTime(toDate);

        return diffDays(c1, c2);
    }

    /**
     * This method adds days to date.
     *
     * @param date
     *            Calendar,days int
     * @return Calendar
     * @throws Exception
     */
    public static Calendar addDaysToDate(Calendar date, int days) {
        int day = date.get(Calendar.DAY_OF_YEAR);
        day = day + days;
        date.set(Calendar.DAY_OF_YEAR, day);

        return date;
    }

    public int getAge(Date dob){
        Calendar c1 = new GregorianCalendar();
        c1.setTime(dob);
        return LocalDate.now().minus(Period.of(c1.get(Calendar.YEAR), c1.get(Calendar.MONTH), c1.get(Calendar.DAY_OF_YEAR))).getYear();
    }


}
