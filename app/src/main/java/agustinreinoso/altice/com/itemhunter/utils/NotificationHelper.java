package agustinreinoso.altice.com.itemhunter.utils;

import com.google.firebase.messaging.FirebaseMessaging;

public class NotificationHelper {


    public void subscribeTopic(String topic) {
        FirebaseMessaging.getInstance().subscribeToTopic(topic);

    }

    public void unSubscribeTopic(String topic) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic(topic);

    }




}
