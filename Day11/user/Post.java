package user;

public class Post {
    private int likes;
    protected int shareCount;
    int commentCount;
    public String postText;

    public Post(String postText){
        this.postText = postText;
    }

    public void Like(){
        likes++;
    }

    public void Comment(String comment){
       commentCount++;
    }

     int getLike(){
        return likes;
    }
    public void share(){
        shareCount++;
    }
}