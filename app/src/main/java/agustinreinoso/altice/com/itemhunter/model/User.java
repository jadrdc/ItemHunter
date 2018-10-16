package agustinreinoso.altice.com.itemhunter.model;

public class User {
private String mUsername;
private String mUrl;


    public User(String mUsername, String mUrl) {
        this.mUsername = mUsername;
        this.mUrl = mUrl;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
