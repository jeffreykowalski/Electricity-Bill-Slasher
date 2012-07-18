package com.jeffkowalski.electricitybillslasher;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends Activity{
	 /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        TextView day = (TextView) findViewById(R.id.rowDay);
        TextView week = (TextView) findViewById(R.id.rowWeek);
        TextView month = (TextView) findViewById(R.id.rowMonth);
        TextView year = (TextView) findViewById(R.id.rowYear);

        try {
        day.setText(getIntent().getStringExtra("day"));
        week.setText(getIntent().getStringExtra("week"));
        month.setText(getIntent().getStringExtra("month"));
        year.setText(getIntent().getStringExtra("year"));       
        } catch (NullPointerException e) {
        	
        }
    }
}
