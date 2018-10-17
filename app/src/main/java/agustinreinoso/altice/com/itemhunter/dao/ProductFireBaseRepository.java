package agustinreinoso.altice.com.itemhunter.dao;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

import agustinreinoso.altice.com.itemhunter.utils.ConfigSetting;
import agustinreinoso.altice.com.itemhunter.model.Product;
import agustinreinoso.altice.com.itemhunter.repositories.ProductRepository;
import agustinreinoso.altice.com.itemhunter.utils.ConfigSetting;

import static agustinreinoso.altice.com.itemhunter.utils.ConfigSetting.PRODUCT_IMAGE_ROOT;

public class ProductFireBaseRepository implements ProductRepository {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private StorageReference mStorageReference;

    public ProductFireBaseRepository() {
        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference(ConfigSetting.PRODUCT_ROOT);
        mStorageReference = FirebaseStorage.getInstance().getReference(PRODUCT_IMAGE_ROOT);
    }

    @Override
    public boolean deleteProduct(Product product) {
        return false;
    }

    @Override
    public boolean addProduct(Product product) {
        DatabaseReference newProduct = mReference.push();
        newProduct.setValue(product);
        return true;
    }

    @Override
    public List<Product> getProductsByCategories(String[] category) {
        return null;
    }
}
