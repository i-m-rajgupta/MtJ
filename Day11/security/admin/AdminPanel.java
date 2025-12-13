package security.admin;
import security.auth.*;

public class AdminPanel extends AuthServer{
    public void access(){
        super.authenticate();
        super.encrypt();
    }

    @Override
    public void encrypt(){
        System.out.println("This is encrypt of admin");
    }
}
