package agustinreinoso.altice.com.itemhunter.views;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import agustinreinoso.altice.com.itemhunter.R;
import agustinreinoso.altice.com.itemhunter.model.Product;
import agustinreinoso.altice.com.itemhunter.viewmodels.ProductViewModel;


public class ProductCreationFragment extends Fragment implements View.OnClickListener {

    private ProductViewModel mProductViewModel;
    private ImageView imageView;

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
        imageView = view.findViewById(R.id.product_image);
        return view;
    }


    @Override
    public void onClick(View v) {

    }
}
