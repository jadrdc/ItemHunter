package agustinreinoso.altice.com.itemhunter.viewholders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import agustinreinoso.altice.com.itemhunter.R;
import agustinreinoso.altice.com.itemhunter.adapters.FireBaseCustomAdapter;
import agustinreinoso.altice.com.itemhunter.model.Product;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    TextView mTxtName;
    ImageView mImageProduct;
    RatingBar mRatingProdct;
    ImageButton mLocation;
    ImageButton mShare;
    CardView mCardView;
    FireBaseCustomAdapter.OnItemClick onItemClickListener;

    public ProductViewHolder(View itemView) {
        super(itemView);
        mCardView = itemView.findViewById(R.id.card_view_list);
        mTxtName = itemView.findViewById(R.id.item_name);
        mImageProduct = itemView.findViewById(R.id.item_image);
        mRatingProdct = itemView.findViewById(R.id.item_stars);
        mShare = itemView.findViewById(R.id.btn_share);
        mLocation = itemView.findViewById(R.id.btn_location);
    }

    public void setMOnItemClickListener(FireBaseCustomAdapter.OnItemClick listener) {
        onItemClickListener = listener;
    }

    public void draw(final Product product) {

        mTxtName.setText(product.getmName());
        Picasso.get().load(product.getmImageUrl()).fit().into(mImageProduct);
        mRatingProdct.setRating(product.getmRatings());
        mRatingProdct.setEnabled(false);
        mLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.drawDirection(product);
            }
        });

        mShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.sharePicture(product.getmImageUrl());
            }
        });


    }


}
