package com.example.sinki.bai58_broadcastreceiver_manifest;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Sinki on 9/4/2017.
 */

public class InternetReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager=
                (ConnectivityManager) context.getSystemService
                        (Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getActiveNetworkInfo()!=null)
        {
            xuLyMoThongBao(context);
        }

    }

    private void xuLyMoThongBao(Context context) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.alarm)
                        .setContentTitle("Có thông báo")
                        .setContentText("Mời bạn nhấn để cập nhật version");

        Intent resultIntent = new Intent(context, MainActivity.class);

        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        mBuilder.setContentIntent(resultPendingIntent);

//        Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        mBuilder.setSound(uri);
        Uri newSound= Uri.parse("android.resource://"
                + context.getPackageName() + "/" + R.raw.gaugau);
        mBuilder.setSound(newSound);



//        notificationId=113;

        NotificationManager mNotifyMgr =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyMgr.notify(115, mBuilder.build());
    }
}
