import entity.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class DbUtil {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/workshop2";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "coderslab";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    public static String hashPassword(String passwordToHash) {
        String hashed = BCrypt.hashpw(passwordToHash, BCrypt.gensalt());
        return hashed;
    }

    public static User[] addToArray(User u, User[] users) {
        User[] tmpUsers = Arrays.copyOf(users, users.length + 1);
        tmpUsers[users.length] = u;
        return tmpUsers;
    }
}
