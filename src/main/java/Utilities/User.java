package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Anthony Emerson on 5/22/2017.
 */
public class User {

    private Properties user = new Properties();
    public  String email;
    public String passwd;
    public String name;
    public String name2;

    public User() {
        try (InputStream input = new FileInputStream("src/main/resources/user.properties")) {
            user.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        email = user.getProperty("email");
        passwd = user.getProperty("passwd");
        name = user.getProperty("name");
        name2 = user.getProperty("name2");
    }
}
