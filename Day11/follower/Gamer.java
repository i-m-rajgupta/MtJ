package follower;
import user.GameCharacter;

public class Gamer extends GameCharacter{
   public Gamer(String name){
    super(name);
   }

  public void details(){
     System.out.println(super.name);
     System.out.println("Attack Power "+super.attackPower);
   }
}