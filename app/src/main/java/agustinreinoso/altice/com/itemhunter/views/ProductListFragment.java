package agustinreinoso.altice.com.itemhunter.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;

import agustinreinoso.altice.com.itemhunter.R;
import agustinreinoso.altice.com.itemhunter.adapters.FireBaseCustomAdapter;
import agustinreinoso.altice.com.itemhunter.model.Product;
import agustinreinoso.altice.com.itemhunter.viewholders.ProductViewHolder;
import agustinreinoso.altice.com.itemhunter.viewmodels.ProductViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProductListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ProductListFragment extends Fragment {

    private ProductViewModel mProductViewModel;
    private RecyclerView mRecyclerView;
    private FireBaseCustomAdapter mAdapter;

    public ProductListFragment() {
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
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        mRecyclerView = view.findViewById(R.id.recycle_products);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }
}
