package user;

import java.util.List;
import java.util.ArrayList;
import follower.*;

public class User {
    String name;
    public static int followerCount;
    int followingCount;
    List<Post> posts = new ArrayList<>();
    Follower f = new Follower();

    public User(String name){
        this.name = name;
    }

   public  void addFollower(User u1){
        f.addFollower(u1);
    }

    public void followersDetails(){
        f.details();
    }

  public  void addFollowing(){
        followingCount++;
    }

   public void addPost(Post p){
      posts.add(p);
    }

    public void details(){
        System.out.println("--- User Details ----");
        System.out.println("User name : "+name);
        System.out.println("Followers : "+followerCount);
        System.out.println("Following : "+followingCount);
        System.out.println("Posts "+posts.size());
    }
   public  void PostDetails(){
        if(posts.size() != 0){
            System.out.println("--- Post Details ----");
        for(Post p : posts){
            System.out.println("Post "+p.postText);
            System.out.println("Likes : "+p.getLike());
           System.out.println("Comments : "+p.commentCount);
           System.out.println("Shared by : "+p.shareCount);
        }
    }else{
        System.out.println("Create post first and to your account ");
    }
    }
}
