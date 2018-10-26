package agustinreinoso.altice.com.itemhunter.viewmodels;

import android.arch.lifecycle.ViewModel;

import agustinreinoso.altice.com.itemhunter.dao.ProductFireBaseRepository;
import agustinreinoso.altice.com.itemhunter.dto.ProductDTO;
import agustinreinoso.altice.com.itemhunter.interfaces.ProductRepository;

public class ProductViewModel extends ViewModel {
    private ProductRepository mRepostory;


    public ProductViewModel() {
        mRepostory = new ProductFireBaseRepository();
    }


    public void addProduct(final ProductDTO product) {
        mRepostory.saveProduct(product.getmUri(), product.getmProduct());

    }


}
