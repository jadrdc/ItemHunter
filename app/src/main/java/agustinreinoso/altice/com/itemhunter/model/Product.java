package agustinreinoso.altice.com.itemhunter.model;
public class Product {
    private String name;
    private String description;
    private String imageUrl;
    private String author;
    private String category;
    private String lat;
    private String lng;

    public Product(String name, String description, String imageUrl, String author, String category, String lat, String lng) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.author = author;
        this.category = category;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
