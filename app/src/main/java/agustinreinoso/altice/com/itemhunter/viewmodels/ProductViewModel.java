package agustinreinoso.altice.com.itemhunter.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import agustinreinoso.altice.com.itemhunter.model.Product;
import agustinreinoso.altice.com.itemhunter.repositories.ProductRepository;

public class ProductViewModel extends ViewModel {
    private MutableLiveData<Product> mProducts;
    private ProductRepository mRepostory;

    public MutableLiveData<Product> getProducts() {
        return mProducts;
    }


    public void setProducts(MutableLiveData<Product> products) {
        this.mProducts = products;
    }


    public void addProduct(final Product product) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mRepostory.addProduct(product);
            }
        }).start();

    }
}
