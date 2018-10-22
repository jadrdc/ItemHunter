package agustinreinoso.altice.com.itemhunter.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import agustinreinoso.altice.com.itemhunter.R;
import agustinreinoso.altice.com.itemhunter.model.Product;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    TextView mTxtName;
    TextView mTxtDescrip;
    ImageView mImageProduct;
    RatingBar mRatingProdct;

    public ProductViewHolder(View itemView) {
        super(itemView);
        mTxtName = itemView.findViewById(R.id.item_name);
        mTxtDescrip = itemView.findViewById(R.id.item_descrip);
        mImageProduct = itemView.findViewById(R.id.item_image);
        mRatingProdct = itemView.findViewById(R.id.item_stars);


    }


    public void draw(Product product) {

        mTxtName.setText(product.getmName());
        mTxtDescrip.setText(product.getmDescription());
        Picasso.get().load(product.getmImageUrl()).into(mImageProduct);
        mRatingProdct.setNumStars(product.getmRatings());

    }




}
