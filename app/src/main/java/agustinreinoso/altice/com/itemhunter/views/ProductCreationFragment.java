package agustinreinoso.altice.com.itemhunter.views;

import android.Manifest;
import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import agustinreinoso.altice.com.itemhunter.R;
import agustinreinoso.altice.com.itemhunter.model.Product;
import agustinreinoso.altice.com.itemhunter.viewmodels.ProductViewModel;

import static android.widget.Toast.makeText;


public class ProductCreationFragment extends Fragment {

    private ProductViewModel mProductViewModel;
    private FusedLocationProviderClient mFusedLocationClient;
    private TextView mTxtName;
    private TextView mTxtDescr;
    private Spinner mSpnCategory;
    private RatingBar mRating;
    private File mOutput;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private double mLng;
    private double mLat;

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
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getActivity().getApplicationContext());


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
                    final Product product = new Product();
                    product.setmName(mTxtName.getText().toString());
                    product.setmDescription(mTxtDescr.getText().toString());
                    product.setmRatings(mRating.getNumStars());
                    product.setmCategory(mSpnCategory.getSelectedItem().toString());
                    product.setmImageUrl(Uri.fromFile(mOutput).toString());
                    product.setmAuthor("Jadrdc");
                    product.setmUri(Uri.fromFile(mOutput));

                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) !=
                            PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                1);

                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                                1);

                    }
                    mFusedLocationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            product.setmLat(String.valueOf(location.getLatitude()));
                            product.setmLng(String.valueOf(location.getLongitude()));
                            mProductViewModel.addProduct(product);

                        }
                    });


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


