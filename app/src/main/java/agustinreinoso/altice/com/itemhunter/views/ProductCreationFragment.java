package agustinreinoso.altice.com.itemhunter.views;

import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import agustinreinoso.altice.com.itemhunter.R;
import agustinreinoso.altice.com.itemhunter.model.Product;
import agustinreinoso.altice.com.itemhunter.viewmodels.ProductViewModel;

import static agustinreinoso.altice.com.itemhunter.utils.Utility.getPictureName;
import static android.widget.Toast.makeText;


public class ProductCreationFragment extends Fragment implements View.OnClickListener {

    private ProductViewModel mProductViewModel;

    private TextView mTxtName;
    private TextView mTxtDescr;
    private Spinner mSpnCategory;
    private RatingBar mRating;
    private File mOutput;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    /*
        private File file;
        private Uri fileUri;
    */
    public ProductCreationFragment() {
        // Required empty public constructor

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mProductViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_creation, container, false);
        this.setHasOptionsMenu(true);
        mTxtName = view.findViewById(R.id.product_name);
        mTxtDescr = view.findViewById(R.id.product_description);
        mSpnCategory = view.findViewById(R.id.product_cat);
        mRating = view.findViewById(R.id.product_stars);
        return view;

    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.option_take_picture: {
                StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                StrictMode.setVmPolicy(builder.build());
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                    mOutput = new File(file, new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".png");
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }

                return true;
            }
            case R.id.optiosave: {
                if (mTxtName.getText().toString().equals("") || mTxtDescr.getText().toString().equals("") || mOutput == null) {
                    makeText(getContext(), "Debes de Completar todos los campos para poder guardar la photo", Toast.LENGTH_LONG).show();
                } else {
                    Product product = new Product();
                    product.setmName(mTxtName.getText().toString());
                    product.setmDescription(mTxtDescr.getText().toString());
                    product.setmRatings(mRating.getNumStars());
                    product.setmCategory(mSpnCategory.getSelectedItem().toString());
                    product.setmImageUrl(Uri.fromFile(mOutput).toString());
                    product.setmAuthor("Jadrdc");
                    product.setmUri(Uri.fromFile(mOutput));
                    mProductViewModel.addProduct(product);

                }
                return true;
            }


        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }


}


