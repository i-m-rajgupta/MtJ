import student.LoginSystem;
import user.*;
import follower.*;
import loan.*;
import bank.*;
import security.admin.AdminPanel;
import security.auth.AuthServer;
import security.crypto.EncryptionModule;
public class Nov25 {
    public static void main(String[] args) {
        // Create two unrelated packages: student  and 	admin
// Create a public class LoginSystem in student package.
//  Try accessing it from admin package.Watch what happens when one method is made protected instead of public.
    LoginSystem s = new LoginSystem("Vijay", 522, 6666);
    LoginSystem.login("Vijay", 6666);
    s.changePassword(6666, 5555);
      LoginSystem.login("Vinay", 6666);
    LoginSystem.login("Vijay", 6666);
    LoginSystem.login("mahesh", 566);

    // Create class Post with:
// •	Private likes
// •	Protected shareCount
// •	Default commentCount
// •	Public postText
// Create classes in same and different packages:
// •	User and •	Follower
// Observe access levels for each.

    Post p1 = new Post("Nice Day!!");
    p1.Comment("Gorgeous");
    p1.Like();
    p1.share();
    Post p2 = new Post("Friendship is important !!");
    p2.Like();
    User u1 = new User("Kapil");
    User u2 = new User("Mahesh");
    u1.details();
    u1.addFollower(u2);
    u1.addFollowing();
    u1.PostDetails();
    u1.addPost(p2);
    u1.addPost(p1);
    u1.PostDetails();
    u1.details();
    u1.followersDetails();

    // Create a GameCharacter class:
// •	Default health variable
// •	Protected attackPower
// •	Private stamina
// •	Public name
// Create a subclass in another package and a normal class in another package.
//  Check which variables can be accessed.

    Member m1 = new Member();
    m1.display();

    Gamer m2 = new Gamer("MArvel");
    m2.details();

    GameCharacter g1 = new GameCharacter("Thanos");
    g1.details();

    // Create a class LoanAccount with: private interestRate ,default tenure 
// protected method calculateEMI() and  public method applyForLoan() 

// Inside LoanAccount, create an inner class LoanValidator that tries to access all members. 
// Then create: 
// A subclass in same package 
// A subclass in a different package 
// A non-subclass in different package 
// Check access from all of them. 

   LoanAccount l1 = new LoanAccount();
   LoanAccount.LoanValidator l2 = l1.new LoanValidator();
   l2.access();

   LoanDetails l3 = new LoanDetails();
   l3.access();

   ApplyLoan a1 = new ApplyLoan();
   a1.access();

   BankDetails b2 = new BankDetails();
   b2.access();

//    Create three classes across three different packages: AuthServer (package security.auth) 
// private key ,protected encrypt() and public authenticate() 

// EncryptionModule (package security.crypto) 
// Tries to use encrypt() without extending. 

// AdminPanel (package security.admin) 
// Extends AuthServer and overrides encrypt() 

// Task: Test which methods and variables can be accessed at each level and why. 
    AuthServer a2 = new AuthServer();
    a2.authenticate();
    
    EncryptionModule e1 = new EncryptionModule();
    e1.access();
    
    AdminPanel a3 = new AdminPanel();
    a3.access();
    a3.encrypt();

    }
}
