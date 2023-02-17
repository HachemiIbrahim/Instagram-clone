package Model;

public class Post {
    private String imageurl;
    private String postid;
    private String publisher;

    public Post(){
    }
    public Post(String imageurl ,String postid, String publisher){
        this.imageurl = imageurl;
        this.postid = postid;
        this.publisher = publisher;
    }
    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}
