package com.example.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity2 extends AppCompatActivity {

	Button mBtnOpen, mBtnClose;
	String CHANNEL_ID = "My_channel";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		mBtnOpen = findViewById(R.id.buttonOpenNotification);
		mBtnClose = findViewById(R.id.buttonCloseNotification);

		mBtnOpen.setOnClickListener(v -> {
			Intent intent = new Intent(MainActivity2.this, MainActivity2.class);

			PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity2.this, 0, intent, 0);

			TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity2.this);
			stackBuilder.addNextIntentWithParentStack(intent);

			PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
					PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

			NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
					builder.setSmallIcon(R.drawable.ic_launcher_foreground);
					builder.setContentTitle("Thông Báo");
					builder.setContentText("Bạn có muốn đóng ứng dụng không?");
					builder.setShowWhen(true);
					builder.setVibrate(new long[]{1000, 200, 2000, 200});
					builder.setLights(0xFF00FF00, 1000, 1000);
					builder.setStyle(new NotificationCompat.BigTextStyle().bigText("Bạn có muốn đóng ứng dụng không?"));
//					builder.setContentIntent(pendingIntent);
					builder.addAction(R.drawable.ic_launcher_foreground, "Đồng ý", resultPendingIntent);
					builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

					NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

					if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
						NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Admob",
								NotificationManager.IMPORTANCE_DEFAULT);
						notificationChannel.setImportance(NotificationManager.IMPORTANCE_HIGH);
						notificationManager.createNotificationChannel(notificationChannel);
					}

					notificationManager.notify(1, builder.build());
		});
	}
}