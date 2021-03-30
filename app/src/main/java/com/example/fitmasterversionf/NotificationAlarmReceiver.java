package com.example.fitmasterversionf;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import com.example.fitmasterversionf.R;

import java.util.Calendar;

public class NotificationAlarmReceiver extends BroadcastReceiver {
    public NotificationAlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println(" ");
        System.out.println("Hello world");
        System.out.println("Hello world");
        //creates and send the work
        WorkRequest notificationWorkRequest =
                new OneTimeWorkRequest.Builder(NotificationWorker.class).build();
        WorkManager.getInstance(context).enqueue(notificationWorkRequest);
        startSendingNotifications(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void createNotificationChannel(String id, String name, String desc, NotificationManager notificationManager) {
        NotificationChannel channel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription(desc);
        channel.setBypassDnd(false);
        channel.enableVibration(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        //register the channel
        notificationManager.createNotificationChannel(channel);
    }

    public static void startSendingNotifications(Context context){
        //create the notification channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(
                    context.getResources().getString(R.string.channel_id),
                    context.getResources().getString(R.string.channel_name),
                    context.getResources().getString(R.string.channel_description),
                    context.getSystemService(NotificationManager.class));
        }

        // Set the alarm to start at 8:30 a.m.
        Calendar calendar = Calendar.getInstance();
        /*code final :
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        if(calendar.before(Calendar.getInstance())){
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        }*/

        //creates the intent
        Intent intent = new Intent(context, NotificationAlarmReceiver.class);
        PendingIntent alarmIntent =
                PendingIntent.getBroadcast(context, 0,
                        intent, PendingIntent.FLAG_CANCEL_CURRENT);

        //gets the alarmManager
        AlarmManager alarmMgr =
                (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        alarmMgr.set(AlarmManager.RTC, calendar.getTimeInMillis() + 5000, alarmIntent);
    }

}