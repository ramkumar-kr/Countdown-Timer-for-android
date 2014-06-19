package com.ramkumar.timer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PlayAlarm extends Activity {

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		m1.pause();
		finish();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		m1.start();
	}

	Button b1;
	MediaPlayer m1;
	TextView t1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playalarm);
		m1 = MediaPlayer.create(getApplicationContext(), R.raw.alarmtune);
		try {
			m1.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		b1 = (Button) findViewById(R.id.b10);
		t1 = (TextView) findViewById(R.id.t120);
		t1.setText(getIntent().getStringExtra("Description"));
		
		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				m1.stop();
				finish();
			}
		});
	}
}
