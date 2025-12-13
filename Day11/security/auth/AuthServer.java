package security.auth;

public class AuthServer {
    private int key = 8855;
    
    protected void encrypt(){
        System.out.println("This is encryption method ");
    }

    public void authenticate(){
        System.out.println("This is auhtenticate method ");
    }
}
