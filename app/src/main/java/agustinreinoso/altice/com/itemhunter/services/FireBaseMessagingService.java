package agustinreinoso.altice.com.itemhunter.services;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import agustinreinoso.altice.com.itemhunter.R;

public class FireBaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);


        sendNotification(remoteMessage.getNotification().getBody()
        );
    }


    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
    }

    public void sendNotification(String msg) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "jadrdc");

        builder.setSmallIcon(R.drawable.ic_launcher_background)
                .setContentText(msg)
                .setContentTitle("Nuevo Objeto Reportado").setChannelId("jadrdc").
                setPriority(NotificationCompat.PRIORITY_HIGH);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("jadrdc", "notif", importance);
            channel.setDescription(" NOTIFICATION CHANNEL ");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            notificationManager.notify(1, builder.build());
        } else {
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(1, builder.build());
        }
    }


}
