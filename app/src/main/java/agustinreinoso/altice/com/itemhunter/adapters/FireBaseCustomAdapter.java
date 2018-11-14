package agustinreinoso.altice.com.itemhunter.adapters;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import agustinreinoso.altice.com.itemhunter.R;
import agustinreinoso.altice.com.itemhunter.model.Product;
import agustinreinoso.altice.com.itemhunter.viewholders.ProductViewHolder;

public class FireBaseCustomAdapter extends FirebaseRecyclerAdapter<Product, ProductViewHolder> {

    public FireBaseCustomAdapter.OnItemClick mListener;

    public FireBaseCustomAdapter(@NonNull FirebaseRecyclerOptions<Product> options) {
        super(options);
    }

    public  void setListener(FireBaseCustomAdapter.OnItemClick listener)
    {
        mListener=listener;

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
        viewHolder.setMOnItemClickListener(mListener);
        return viewHolder;
    }


    public  interface  OnItemClick
    {
        void drawDirection(Product product);
        void sharePicture(String path);

    }

}
