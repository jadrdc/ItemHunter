package agustinreinoso.altice.com.itemhunter.interfaces;

import android.net.Uri;

import agustinreinoso.altice.com.itemhunter.model.Product;

public interface ProductRepository {
    public void saveProduct(Uri uri, final Product product);

    void addProduct(Product product);

    void getProductsByCategories(String[] category);

    void deleteProduct(Product product);
}
