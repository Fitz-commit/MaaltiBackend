import Postgres.PostgresUserManager;
import Testing.YTAPICall;
import User.User;
import User.UserManager;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws GeneralSecurityException, IOException {
        UserManager Usermanager = new UserManager();
        User Testuser = new User("Test","Test123");

        Usermanager.addUser(Testuser);
        //YTAPICall.channelListUsername("Gronkh");

    }
}
