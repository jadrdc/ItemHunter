package agustinreinoso.altice.com.itemhunter.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import agustinreinoso.altice.com.itemhunter.utils.NotificationHelper;

public class UserViewModel extends ViewModel {
    private NotificationHelper mNotificationHelper;

    public UserViewModel() {
        mNotificationHelper = new NotificationHelper();
    }

    public void manageSubscriptionTopic(String topic, boolean subscribe) {
        if (subscribe == true) {
            mNotificationHelper.subscribeTopic(topic);
        } else {
            mNotificationHelper.unSubscribeTopic(topic);
        }
    }
}
