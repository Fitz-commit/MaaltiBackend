package User;

import Postgres.PostgresUserManager;

public class UserManager {

    public void addUser(User user){
        PostgresUserManager.getPostgresUserManager().addUser(user);

    }


}
