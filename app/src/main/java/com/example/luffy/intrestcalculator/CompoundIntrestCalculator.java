package com.example.luffy.intrestcalculator;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Luffy on 12/13/2017.
 */

public class CompoundIntrestCalculator {
    public static void main(String[] args)
    {
        double p = 100; // principal amount
        double r = 1.75/100; // rate
        int ci = 12;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date startDate = df.parse("10/04/2007"); //startDateString
            Date endDate = df.parse("1/05/2009"); //endDateString
            // while start date + ci < end date , calcluate si , pi = si + pi;
            Date newStartDate = df.parse(df.format(startDate));
            Date newEndDate = df.parse(df.format(startDate));
            newEndDate.setMonth(ci + newEndDate.getMonth());
            while(newEndDate.before(endDate))
            {
                System.out.println("for start =  " + df.format(newStartDate) + " , " + df.format(newEndDate));
                p = p + SimpleIntrestCalculator.calcluateSimpleIntrest(p, r, newStartDate, newEndDate);
                newStartDate = df.parse(df.format(newEndDate));
                newEndDate.setMonth(ci + newEndDate.getMonth());
                System.out.println(" next p = " + p);
            }
        } catch (ParseException ex) {
            Logger.getLogger(CompoundIntrestCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static double calculateCompoundIntrest(double p, double r, int ci, String startDateStr, String endDateStr)
    {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date startDate = df.parse(startDateStr); //startDateString
            Date endDate = df.parse(endDateStr); //endDateString
            // while start date + ci < end date , calcluate si , pi = si + pi;
            Date newStartDate = df.parse(df.format(startDate));
            Date newEndDate = df.parse(df.format(startDate));
            newEndDate.setMonth(ci + newEndDate.getMonth());
            while(newEndDate.before(endDate))
            {
                Log.d("haha", "for start =  " + df.format(newStartDate) + " , " + df.format(newEndDate));
                p = p + SimpleIntrestCalculator.calcluateSimpleIntrest(p, r, newStartDate, newEndDate);
                newStartDate = df.parse(df.format(newEndDate));
                newEndDate.setMonth(ci + newEndDate.getMonth());
                Log.d("haha", " next p = " + p);
            }
            Log.d("haha", "for start =  " +  p + "  " + df.format(newStartDate) + " , " + df.format(endDate));
            p = p + SimpleIntrestCalculator.calcluateSimpleIntrest(p, r, newStartDate, endDate);
            Log.d("haha", " ans = " + p);
        } catch (ParseException ex) {
            Logger.getLogger(CompoundIntrestCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

}


