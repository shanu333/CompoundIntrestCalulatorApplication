package com.example.luffy.intrestcalculator;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Luffy on 12/13/2017.
 */

public class SimpleIntrestCalculator {
    public static void main(String[] args) {
        double p = 100; // principal amount
        double r = 1.75/100; // rate
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date startDate = df.parse("10/04/2007"); //startDateString
            Date endDate = df.parse("1/05/2008"); //endDateString
            calcluateSimpleIntrest(p, r, startDate, endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    static double calclulateDiffInMonths(Date d1, Date d2)
    {
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(d1);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(d2);
        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        int diffDays = endCalendar.get(Calendar.DAY_OF_MONTH) - startCalendar.get(Calendar.DAY_OF_MONTH);
        if(diffDays < 0)
        {
            // subtract on month
            diffMonth--;
        }
        System.out.println("final diff month " + diffMonth);
        return diffMonth;
    }
    static double calcSimpleIntrest(double p, double r, double t)
    {
        return p*r*t;
    }

    private static double calclulateDiffInDays(Date d1, Date d2){
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(d1);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(d2);
        int diffDays = endCalendar.get(Calendar.DAY_OF_MONTH) - startCalendar.get(Calendar.DAY_OF_MONTH);
        if(diffDays < 0)
        {
            diffDays = 30 + diffDays;
        }
        System.out.println("final diff day " + diffDays);
        return diffDays;
    }

    public static double calcluateSimpleIntrest(double p, double r, Date startDate, Date endDate) {

        double tMonths = calclulateDiffInMonths(startDate, endDate);
        double si = calcSimpleIntrest(p,r,tMonths); // first calc for months
        double tDays = calclulateDiffInDays(startDate, endDate);
        si = si + calcSimpleIntrest(p,r,tDays); // first calc for months
        Log.d("haha", " month diff = " + tMonths + " day diff = " + tDays);
        return si;
    }
}
