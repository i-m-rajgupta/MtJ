package library.members;

public class Member {
    String name;
    static int count = 101;
    int memberId;

    public Member(String name){
      this.name = name;
      this.memberId = count++;
    }
     public void display(){
        System.out.println(name+" and Member ID : "+memberId);
    }
}
