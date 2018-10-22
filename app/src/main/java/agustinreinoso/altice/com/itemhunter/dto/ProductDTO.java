package agustinreinoso.altice.com.itemhunter.dto;

import android.net.Uri;

import agustinreinoso.altice.com.itemhunter.model.Product;

public class ProductDTO {
    private Product mProduct;
    private Uri mUri;

    public Product getmProduct() {
        return mProduct;
    }

    public void setmProduct(Product mProduct) {
        this.mProduct = mProduct;
    }

    public Uri getmUri() {
        return mUri;
    }

    public void setmUri(Uri mUri) {
        this.mUri = mUri;
    }
}
