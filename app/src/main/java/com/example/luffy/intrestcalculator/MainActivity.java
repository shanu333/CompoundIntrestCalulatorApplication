package com.example.luffy.intrestcalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext(); // bad practice
        final TextView amountTv = (TextView)findViewById(R.id.amount);
        final TextView rateTv = (TextView)findViewById(R.id.rate);
        final TextView ciTv = (TextView)findViewById(R.id.ci);
        final TextView resultTv = (TextView)findViewById(R.id.result);
        final TextView startDateTv = (TextView)findViewById(R.id.start_date);
        final TextView endDateTv = (TextView)findViewById(R.id.end_date);
        endDateTv.setText(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()) + "");
        Button calcButton= (Button)findViewById(R.id.calculate);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double ans = -1;
                try {
                    double amount = Float.valueOf(amountTv.getText() + "");
                    double rate = Float.valueOf(rateTv.getText() + "");
                    rate = rate/100;
                    int ci = Integer.valueOf(ciTv.getText() + "");
                    String startDate = startDateTv.getText() + "";
                    String endDate = endDateTv.getText() + "";
                    Log.d("haha", " amount = " + amount + " , rate = " + rate + " " + startDate + " " + endDate);
                    ans = CompoundIntrestCalculator.calculateCompoundIntrest(amount, rate, ci, startDate, endDate);
                    resultTv.setText(ans + "");
                }
                catch (Exception e)
                {

                }
            }
        });

    }

    public static  void displayToast(String string)
    {
        Toast.makeText(context, string, Toast.LENGTH_LONG).show();
    }
}
