import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import BusinessLogic.DataHandler;

public class userClass {
    public boolean Login(String email, String password){
        String correct = "";
        Collection<DataHandler> users = new ArrayList<DataHandler>();
        for(DataHandler u : users){
            if  (email == u.getEmail() && password == u.getPassword())
            {
                correct = "yes";
            }
            else
            {
                correct = "no";
            }
        }
        if (correct.equals("yes")) {
            return true;
        }else{
            return false;
        }
    }

}

