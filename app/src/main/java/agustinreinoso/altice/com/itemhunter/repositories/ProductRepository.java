package agustinreinoso.altice.com.itemhunter.repositories;

import java.util.List;

import agustinreinoso.altice.com.itemhunter.model.Product;

public interface ProductRepository {

    boolean addProduct(Product product);
    List<Product> getProductsByCategories(String [] category);

}
