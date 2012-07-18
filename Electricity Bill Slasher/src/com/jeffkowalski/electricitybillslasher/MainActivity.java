package com.jeffkowalski.electricitybillslasher;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setTheme(android.R.style.Theme_Holo);
        final Button calculate = (Button) findViewById(R.id.btnCalculate);
    	final EditText wattsfield = (EditText) findViewById(R.id.txtWatts);
    	final EditText hoursfield = (EditText) findViewById(R.id.txtHours);
    	final EditText costfield = (EditText) findViewById(R.id.txtCost);
        final Spinner feedbackSpinner = (Spinner) findViewById(R.id.SpinnerFeedbackType);    
        
        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	DecimalFormat df = new DecimalFormat("#.##");
              	int watts = 0;
            	int hours = 0;
            	double dcost = 0;
            	try {
            	    watts = Integer.parseInt(wattsfield.getText().toString());
            	    hours = Integer.parseInt(hoursfield.getText().toString());
            	    dcost = Double.parseDouble(costfield.getText().toString());
            	} catch(NumberFormatException nfe) {
            	   System.out.println("Could not parse " + nfe);
            	} 
            	
            	double kwh = watts * hours;
            	double cost = (kwh * dcost);
            	
            	//String.valueOf
            	Intent wordIntent = new Intent(getApplicationContext(), ResultsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("day", df.format(cost / 1000));
                bundle.putString("week", df.format((cost * 7) / 1000));
                bundle.putString("month", df.format((cost * 30) / 1000));
                bundle.putString("year", df.format((cost * 365) / 1000));
                wordIntent.putExtras(bundle);
                
                //Toast.makeText(getApplicationContext(), String.valueOf(kwh), Toast.LENGTH_LONG).show();
                startActivity(wordIntent);
            }
        });
  
        
        feedbackSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            	//Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_LONG).show();
            	switch(position) {
            	
                case 0:
                		wattsfield.setText("160");
                		hoursfield.setText("4");
                		costfield.setText("0.08");
                    break;
                case 1:
                		wattsfield.setText("340");
                		hoursfield.setText("4");
                		costfield.setText("0.08");
                    break;
               case 2:
               			wattsfield.setText("17");
               			hoursfield.setText("4");
               			costfield.setText("0.08");
                    break;
               case 3:
               			wattsfield.setText("1500");
               			hoursfield.setText("1");
               			costfield.setText("0.08");
                   break;
                   
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
