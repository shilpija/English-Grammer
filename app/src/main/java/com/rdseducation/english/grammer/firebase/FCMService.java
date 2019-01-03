package com.rdseducation.english.grammer.firebase;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.rdseducation.english.grammer.Activity_Splash;
import com.rdseducation.english.grammer.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FCMService extends FirebaseMessagingService {

    String title = "English Grammer";

//    @Override
//    public void onNewToken(String s) {
//        Log.e("NEW_TOKEN", s);
//    }

    @Override
    public void onCreate() {
        super.onCreate();

//      ShortcutBadger.applyCount(FCMService.this, PrefHelper.getInt(PrefHelper.KEY_NOTIFICATION_COUNT, 0));
//        ShortcutBadger.applyCount(FCMService.this, BaseConstant.NOTIFICATION_COUNT);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

//        Note newBotw=new Note();
//        newBotw.setNote("yes");
//        newBotw.setTimestamp("yes");

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d("Token1", "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d("Token2", "Message data payload: " + remoteMessage.getData());
//            MyNotification notification = gson.fromJson(new JSONObject(remoteMessage.getData()).toString(), MyNotification.class);
//            BaseConstant.NOTIFICATION_COUNT=notification.getBadgcount();
            try {
                title = remoteMessage.getData().get("title");
            } catch (Exception ex) {
                title = getApplicationContext().getResources().getString(R.string.app_name);
            }
            generateNotification(remoteMessage.getData().get("body"));
//            sendNotification(remoteMessage.getNotification().getBody().toString());
        }
        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d("Token3", "Message Notification Body: " + remoteMessage.getNotification().getBody());
            generateNotification(remoteMessage.getNotification().getBody().toString());
//            sendNotification(remoteMessage.getNotification().getBody().toString());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }


    private void generateNotification(String message) {
        PendingIntent pendingIntent;

//              notificationIntent.putExtra(Ba
        Date now = new Date();
        int notid = Integer.parseInt(new SimpleDateFormat("ddHHmmss", Locale.US).format(now));


        NotificationCompat.Builder mBuilder;
        Intent notificationIntent = null;
        notificationIntent = new Intent(this, Activity_Splash.class);

//        if (Util.isAppRunning(getApplicationContext(),getPackageName()))
//        if (MyLifecycleHandler.isApplicationVisible())
//        {
//
//            notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK );
//            notificationIntent.putExtra(BaseConstants.NOTIFICATION_CLICK, true);
//            notificationIntent.setAction(""+notid);
//            Intent intent = new Intent("com.pinpoint.appointment.broadcast1");
////                intent.putExtra(BaseConstants.EXTRA_LOCATION, BaseConstants.NOTIFICATION_COUNT);
//            intent.putExtra(ApiList.KEY_MESSAGE,message);
//            intent.putExtra(ApiList.KEY_TITLE,title);
////                if(PrefHelper.getBoolean(BaseConstants.NOTIFICATION_RECEIVED,false))
////                {
//            PrefHelper.setBoolean(BaseConstants.NOTIFICATION_RECEIVED,false);
//
//            // LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
//            sendBroadcast(intent);
////                }
//        }
//        else {
//            notificationIntent = new Intent(this, SplashActivity.class);
//            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            notificationIntent.putExtra(BaseConstants.NOTIFICA  TION_CLICK, true);
//            notificationIntent.setAction("" + notid);
////          notificationIntent.putExtra(BaseConstants.KEY_FROM, "notification");
//
//        }

        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, notid, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String messageToDisplay = message.replace("<br/>", "");
            mBuilder = new NotificationCompat.Builder(this, "1")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(title)
                    .setWhen(Calendar.getInstance().getTimeInMillis())
                    .setContentText(messageToDisplay)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(messageToDisplay))
                    .setPriority(Notification.PRIORITY_HIGH)
                    .setContentIntent(resultPendingIntent)
                    .setAutoCancel(true);
        } else {
            String messageToDisplay = message.replace("<br/>", "");
            mBuilder = new NotificationCompat.Builder(this, "1")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(title)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(messageToDisplay))
                    .setWhen(Calendar.getInstance().getTimeInMillis())
                    .setPriority(Notification.PRIORITY_HIGH)
                    .setContentText(messageToDisplay)
                    .setAutoCancel(true)
                    .setContentIntent(resultPendingIntent);
        }

//        PrefHelper.setBoolean("isnotification",true);
//            SharedPreferences sp = getSharedPreferences("notification", Context.MODE_PRIVATE);
//            SharedPreferences.Editor editor=sp.edit();
//            editor.clear();
//            editor.putBoolean("isnotification",true);
//            editor.commit();

        Notification notification = mBuilder.build();
//            NotificationCompat.Builder notification = new NotificationCompat.Builder(this, CHANNEL_ID);
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_VIBRATE;
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        int mNotificationId = (int) System.currentTimeMillis();
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        assert mNotifyMgr != null;
        mNotifyMgr.notify(notid, notification);

    }


}

