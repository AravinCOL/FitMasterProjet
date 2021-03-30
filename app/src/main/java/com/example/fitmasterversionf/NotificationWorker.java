package com.example.fitmasterversionf;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

//
//ajouter dans dependencies {
//  def work_version = "2.5.0"
//
//          // (Java only)
//          implementation "androidx.work:work-runtime:$work_version"
//
public class NotificationWorker extends Worker {

    public NotificationWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Notification notif = createNotification(getApplicationContext(), getApplicationContext().getResources().getString(R.string.channel_id));
        notify(notif, 413);
        return Result.success();
    }

    public void notify(Notification notification, int notificationId){
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
        notificationManager.cancel(notificationId);
        notificationManager.notify(notificationId, notification);
    }

    public Notification createNotification(Context context, String channelId){
        // Create an explicit intent for an Activity in your app
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        // Create the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_stat_notification)
                .setContentTitle(getApplicationContext().getResources().getString(R.string.notification_name))
                .setContentText(getApplicationContext().getResources().getString(R.string.notification_desc))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        builder.setChannelId(channelId);
        return builder.build();
    }
}
