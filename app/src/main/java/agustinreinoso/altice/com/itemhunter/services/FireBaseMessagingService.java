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


        sendNotification(remoteMessage.getFrom().substring(8), remoteMessage.getNotification().getBody(),
                remoteMessage.getNotification().getTitle()
        );
    }


    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
    }

    public void sendNotification(String topic, String msg,String description) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "jadrdc");
        int icon;

        if (topic.equals("Comida")) {
            icon = R.drawable.food;
        } else if (topic.equals("Bebida")) {
            icon = R.drawable.drink;

        } else if (topic.equals("Tecnologia")) {
            icon = R.drawable.tech;

        } else {
            icon = R.drawable.cloth;

        }

        builder.setSmallIcon(icon)
                .setContentText(msg)
                .setContentTitle("Nuevo Objeto Reportado").setChannelId("jadrdc").
                setPriority(NotificationCompat.PRIORITY_HIGH).setStyle(new NotificationCompat.BigTextStyle().bigText(description));

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
