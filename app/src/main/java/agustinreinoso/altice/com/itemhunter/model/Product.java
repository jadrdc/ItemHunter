package agustinreinoso.altice.com.itemhunter.model;

public class Product {
    private String mName;
    private String mDescription;
    private String mImageUrl;
    private String mAuthor;
    private int mRatings;
    private String mCategory;
    private String mLat;
    private String mLng;

    public Product(String mName, String mDescription, String mImageUrl, String mAuthor, int mRatings, String mCategory, String mLat, String mLng) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mImageUrl = mImageUrl;
        this.mAuthor = mAuthor;
        this.mRatings = mRatings;
        this.mCategory = mCategory;
        this.mLat = mLat;
        this.mLng = mLng;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public int getmRatings() {
        return mRatings;
    }

    public void setmRatings(int mRatings) {
        this.mRatings = mRatings;
    }

    public String getmCategory() {
        return mCategory;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public String getmLat() {
        return mLat;
    }

    public void setmLat(String mLat) {
        this.mLat = mLat;
    }

    public String getmLng() {
        return mLng;
    }

    public void setmLng(String mLng) {
        this.mLng = mLng;
    }
}
