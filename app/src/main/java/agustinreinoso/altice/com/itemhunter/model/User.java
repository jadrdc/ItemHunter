package agustinreinoso.altice.com.itemhunter.model;

public class User {
private String username;
private String url;

    public User(String username, String url) {
        this.username = username;
        this.url = url;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
