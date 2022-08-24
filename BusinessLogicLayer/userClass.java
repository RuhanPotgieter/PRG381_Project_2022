import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class userClass {
    public Integer student_id;
    public String student_name; 
    public String student_surname;
    public String student_address;
    public String email;
    public String password;
    public String student_course;
    public Integer getStudent_id() {
        return student_id;
    }
    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }
    public String getStudent_name() {
        return student_name;
    }
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
    public String getStudent_surname() {
        return student_surname;
    }
    public void setStudent_surname(String student_surname) {
        this.student_surname = student_surname;
    }
    public String getStudent_address() {
        return student_address;
    }
    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getStudent_course() {
        return student_course;
    }
    public void setStudent_course(String student_course) {
        this.student_course = student_course;
    }

    public static Collection<userClass> getUsers(){
        String con = "http://localhost:8080; Database=Student_Portal"; 
        String query = "SELECT * FROM Student";
        Collection<userClass> users = new ArrayList<userClass>();
        try{
            Connection conn = DriverManager.getConnection(con);
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                userClass user = new userClass();
                user.student_id = rs.getInt("student_id");
                user.student_name = rs.getString("student_name");
                user.student_surname= rs.getString("student_surname");
                user.email = rs.getString("student_email");
                user.password = rs.getString("student_password");
                user.student_course = rs.getString("student_course");
            }
            } catch (SQLException e) {
            userClass user = new userClass();
            user.student_id = 0;
            user.student_name = "";
            user.student_surname= "";
            user.email = "";
            user.password = "";
            user.student_course = "";
            }
        return users;
    }
    public static Boolean Login(String email, String password){ 
        Collection<userClass> users = new ArrayList<userClass>();
        users.addAll(getUsers());
        if  (email == users.email && password == users.password){return true;}
        else{return false;}
    }

    public static void RegisterStudent(String firstName, String lastName, String address,String email, String password, String courseName){
        String con = "http://localhost:3306; Database=Student_Portal"; 
        String query = "INSERT INTO Student (student_name, student_surname, student_address, email, password, student_course)";
        query += " VALUES (" + firstName + "," + lastName + "," +  address +"," + email + "," + password + "," + courseName + ")";

        try {
            Connection conn = DriverManager.getConnection(con);
            PreparedStatement statement = conn.prepareStatement(query);
            statement.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Failed to execute query");
        }
    }

}

