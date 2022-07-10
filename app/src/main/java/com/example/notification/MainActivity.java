package com.example.notification;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	Button mBtnNavigateScreen2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mBtnNavigateScreen2 = findViewById(R.id.buttonNavigateScreen2);

		mBtnNavigateScreen2.setOnClickListener(v -> {
			Intent intent = new Intent(MainActivity.this, MainActivity2.class);
			startActivity(intent);
		});
	}
}