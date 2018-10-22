package agustinreinoso.altice.com.itemhunter.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

import agustinreinoso.altice.com.itemhunter.R;
import agustinreinoso.altice.com.itemhunter.model.Product;
import agustinreinoso.altice.com.itemhunter.viewholders.ProductViewHolder;
import agustinreinoso.altice.com.itemhunter.viewmodels.ProductViewModel;

public class FireBaseCustomAdapter extends FirebaseRecyclerAdapter<Product, ProductViewHolder> {


    public FireBaseCustomAdapter(@NonNull FirebaseRecyclerOptions<Product> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull Product model) {

        holder.draw(model);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        ProductViewHolder viewHolder = new ProductViewHolder(view);
        return viewHolder;
    }
}
