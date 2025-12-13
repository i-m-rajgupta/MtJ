package follower;
import java.util.List;
import java.util.ArrayList;

import user.*;

public class Follower {
    List<User> followers = new ArrayList<>();
    
   public void addFollower(User u){
        followers.add(u);
        User.followerCount++;
    }

    public void details(){
        if(followers.size() != 0){
    System.out.println("--- Followers Details ---");
    for(User u :followers){
     u.details();
    }
     }
    }

    public void access(){
        Post p = new Post("Mahesh");
        System.out.println(p.postText);  // This is only visible as it is public other fields produce error while calling 
        // System.out.println(p.shareCount);
        // System.out.println(p.likes);   
        // System.out.println(p.commentCount);
    }
}
