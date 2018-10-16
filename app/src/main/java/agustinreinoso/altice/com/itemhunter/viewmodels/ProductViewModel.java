package agustinreinoso.altice.com.itemhunter.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import agustinreinoso.altice.com.itemhunter.model.Product;

public class ProductViewModel extends ViewModel {
    private MutableLiveData<Product> mProducts;

    public MutableLiveData<Product> getProducts() {
        return mProducts;
    }

    public void setProducts(MutableLiveData<Product> products) {
        this.mProducts = products;
    }
}
