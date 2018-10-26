package agustinreinoso.altice.com.itemhunter.dao;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import agustinreinoso.altice.com.itemhunter.utils.ConfigSetting;
import agustinreinoso.altice.com.itemhunter.model.Product;
import agustinreinoso.altice.com.itemhunter.interfaces.ProductRepository;

public class ProductFireBaseRepository implements ProductRepository {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private StorageReference mStorageReference;

    public ProductFireBaseRepository() {
        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference(ConfigSetting.PRODUCT_ROOT);
        mStorageReference = FirebaseStorage.getInstance().getReference();
    }



    @Override
    public void deleteProduct(Product product) {
    }

    public void saveProduct(final Uri uri, final Product product) {
        StorageReference storage = mStorageReference.child("Images/").child(uri.getLastPathSegment());
        storage.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                taskSnapshot.getMetadata().getReference().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {

                        Uri uri1 = task.getResult();
                        product.setmImageUrl(uri1.toString());
                        addProduct(product);
                    }
                });
            }
        });

        /*   product.setmImageUrl(taskSnapshot.getStorage().getDownloadUrl().toString());
                addProduct(product);
*/
    }

    @Override
    public void addProduct(final Product product) {
        DatabaseReference newProduct = mReference.push();
        newProduct.setValue(product).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });
    }


    @Override
    public void getProductsByCategories(String[] category) {
        final List<Product> productsList = new ArrayList<>();

        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Iterator<DataSnapshot> iterable = dataSnapshot.getChildren().iterator();
                while (iterable.hasNext()) {
                    DataSnapshot snapshot = iterable.next();
                    Product product = snapshot.getValue(Product.class);
                    productsList.add(product);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}