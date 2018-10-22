package agustinreinoso.altice.com.itemhunter.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import agustinreinoso.altice.com.itemhunter.dao.ProductFireBaseRepository;
import agustinreinoso.altice.com.itemhunter.dto.ProductDTO;
import agustinreinoso.altice.com.itemhunter.model.Product;
import agustinreinoso.altice.com.itemhunter.interfaces.ProductRepository;

public class ProductViewModel extends ViewModel {
    private MutableLiveData<List<Product>> mProducts;
    private ProductRepository mRepostory;

    public MutableLiveData<List<Product>> getProducts() {

        if (mProducts == null) {
            mProducts = new MutableLiveData<>();
        }
        mRepostory.getProductsByCategories(new String[0]);
        mProducts.postValue(null);

        return mProducts;
    }

    public ProductViewModel() {
        mRepostory = new ProductFireBaseRepository();
    }


    public void addProduct(final ProductDTO product) {
        mRepostory.saveProduct(product.getmUri(), product.getmProduct());

    }


}
