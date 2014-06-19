package com.ramkumar.timer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Startpage extends Activity {

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startpage);
		Thread t = new Thread()
		{
			public void run()
			{
				try{
				sleep(4000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally{
					startActivity(new Intent("com.ramkumar.timer.STARTTIMER"));	
				}
			}
		};
		t.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_startpage, menu);
		return true;
	}

}
