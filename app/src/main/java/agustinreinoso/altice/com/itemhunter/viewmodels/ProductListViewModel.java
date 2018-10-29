package agustinreinoso.altice.com.itemhunter.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.google.firebase.database.DatabaseReference;

public class ProductListViewModel extends ViewModel {

    public MutableLiveData<DatabaseReference> mProductsLivedata;

    public LiveData<DatabaseReference> getmProductsLivedata() {
        if (mProductsLivedata == null) {
            mProductsLivedata = new MutableLiveData<DatabaseReference>();
        }


        return  mProductsLivedata;
    }
}
