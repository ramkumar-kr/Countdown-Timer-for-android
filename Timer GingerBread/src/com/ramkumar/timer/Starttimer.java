package com.ramkumar.timer;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Starttimer extends Activity {

	Button b1,b2;
	 static Timer t1 ;
	static	TimerTask runtimer ;
	
	int min,sec;
	String s1;
	boolean stoptimer=false;
	public EditText e1,e2,e3;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starttimer);
		b1 = (Button) findViewById(R.id.b1);//exit button
		b2 = (Button) findViewById(R.id.b2);//Go button
		e1 = (EditText) findViewById(R.id.et1);
		e2 = (EditText) findViewById(R.id.et2);
		e3 = (EditText) findViewById(R.id.et3);
		
		
		b1.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(b2.getText().equals("Invalid Hours or Minutes Entered\nTouch the button to continue") || b2.getText().equals("Timer Canceled\nTouch the button to continue"))
				{
					b2.setText("Set Timer");
					return;
				}
				else if(b2.getText().equals("Timer has started\nTouch to stop timer"))
				{
									
					stoptimer=true;
					runtimer.cancel();
					t1.cancel();
					runtimer=null;
					t1=null;
					b2.setText("Timer Canceled\nTouch the button to continue");
					return;
				}
				try{
					min = Integer.parseInt(e1.getText().toString().trim());
					}
					catch(Exception e)
					{
						min = 0;
					}
					try{
					sec = Integer.parseInt(e2.getText().toString().trim());
					}
					catch(Exception e)
					{
						sec = 0;  
					}
					if(min<0 || sec<0 || sec>59 || min >99)
					{
						b2.setText("Invalid Hours or Minutes Entered\nTouch the button to continue");
						return;
					}
					
						s1 = e3.getText().toString();
					long total = ((((min%100)*3600)+((sec%60)*60))*1000);
					b2.setText("Timer has started\nTouch to stop timer");
					
					t1=new Timer();
					runtimer  = new TimerTask() {
						
						@Override
						public void run() {
							Activity a1 = new Activity();
							// TODO Auto-generated method stub
					if(stoptimer == true)
					{
						a1.stopService(getIntent());
					}
						Intent newintent =new Intent("com.ramkumar.timer.PLAYALARM");
							newintent.putExtra("Description", s1);
							a1.startService(newintent);
							
							
						}		
						
					};
					t1.schedule(runtimer, total);
			}
			
		});
		
	}
	
}
					
				

			
		


