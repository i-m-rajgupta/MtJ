package student;

import java.util.List;
import java.util.ArrayList;

public class LoginSystem {
    private   String name;
    private int roll;
   private int password;
   static List<LoginSystem> members = new ArrayList<>();

    public LoginSystem(String name,int roll,int password){
        this.name = name;
        this.password = password;
        this.roll = roll;
        addMembers(this);
    }

    void addMembers(LoginSystem m ){
        members.add(m);
    }
    
    public void changePassword(int currentPassword,int newPassword){
       if(currentPassword == this.password){
        this.password = newPassword;
        System.out.println("Your password changed successfully !!");
       }else{
        System.out.println("Please enter correct Older Password");
       }
    }
   public static void login(String name,int password){
        if(members == null){
          System.out.println("No Members have registered .");
        }

        boolean isFound = false;
        for(LoginSystem m : members){
            if(  !isFound && m.name == name ){
                isFound = true;
                if( m.password == password){
                 System.out.println("You have login successfully !! ");
                }else{
                    System.out.println("Enter correct password !!");
                }
                break;
            }
        }
        if(!isFound){
            System.out.println("Details are not found ,Enter correct details or ensure that you have register to us .");
        }
    }

      protected void login1(){
         System.out.println("This is protected login");
        }

        public void login2(){
         System.out.println("This is public  login");
        }
}
