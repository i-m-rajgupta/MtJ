package admin;
import student.LoginSystem;

public class Admin {
    int adminID;
    String name;

   public Admin(String name,int adminID){
        this.name = name;
        this.adminID = adminID;
    }
   void details(){
    System.out.println("Admin : "+name);
   }

   public static void main(String[] args) {
     LoginSystem l = new LoginSystem("mahesh",552,566);
      l.login2();//this is public; 
    //   l.login1(); this is protected so it is showing error while calling
    LoginSystem.login("mahesh", 566);
   } 
}
