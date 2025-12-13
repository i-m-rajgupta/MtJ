package user;

public class GameCharacter {
    protected int attackPower =500;
    int health = 100;
    private String stamina = "GOOD";
    public String name;

    public GameCharacter(String name){
        this.name = name;
    }

    public void details(){
        System.out.println(name+" has "+stamina+" stamina, "+health+" health and "+attackPower+" attackpower ");
    }
}
