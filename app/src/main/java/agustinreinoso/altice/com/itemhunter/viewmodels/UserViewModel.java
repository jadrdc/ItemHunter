package agustinreinoso.altice.com.itemhunter.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import agustinreinoso.altice.com.itemhunter.utils.FireBaseAuthHelper;
import agustinreinoso.altice.com.itemhunter.utils.NotificationHelper;

public class UserViewModel extends ViewModel {
    private NotificationHelper mNotificationHelper;

    public LiveData<FireBaseAuthHelper> getMauthHelper() {
        return mauthHelper;
    }

    public void signUpUser(String email, String pass) {
        mauthHelper.getValue().createUser(email, pass);

    }

    public void setCreationListener(FireBaseAuthHelper.FireBaseUserCreation listener) {
        mauthHelper.getValue().setMcreationResponse(listener);
    }

    public void setLoginResponse(FireBaseAuthHelper.FireBaseLogin listener) {
        mauthHelper.getValue().setLoginResponse(listener);
    }

    private LiveData<FireBaseAuthHelper> mauthHelper;

    public UserViewModel() {
        mNotificationHelper = new NotificationHelper();
        mauthHelper = new MutableLiveData<FireBaseAuthHelper>();
        ((MutableLiveData<FireBaseAuthHelper>) mauthHelper).setValue(new FireBaseAuthHelper());
    }


    public void login(String email, String pass) {
        mauthHelper.getValue().loginEmail(email, pass);

    }

    public  void logOut()
    {
        mauthHelper.getValue().logOut();
    }

    public void manageSubscriptionTopic(String topic, boolean subscribe) {
        if (subscribe == true) {
            mNotificationHelper.subscribeTopic(topic);
        } else {
            mNotificationHelper.unSubscribeTopic(topic);
        }
    }
}
