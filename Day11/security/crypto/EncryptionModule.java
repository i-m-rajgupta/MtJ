package security.crypto;
import security.auth.*;

public class EncryptionModule {
    public void access(){
        AuthServer a = new AuthServer();
        a.authenticate();
        // a.encrypt() this is not available as this is protected and we call this in different package without extending the class
    }
}
