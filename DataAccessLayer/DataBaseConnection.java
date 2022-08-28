package DataAccessLayer;

import java.sql.*;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.sql.ResultSet;
// import java.sql.Statement;
import java.util.List;

public class DataBaseConnection {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/Student_Portal";
    private String username = "root";    //This should be default
    private String password = "{ENTER PASSWORD HERE}"; //Use the password for your local mySql root'

    public DataBaseConnection() {
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String addStudent(String Name, String Surname, String Address, String Email, String Password, int courseID){
        try {
            String sql = String.format("insert into Student(student_name,student_surname,student_address,student_Email,student_Password,student_course)"+
             "values('%s','%s','%s','%s','%s',%d)",Name,Surname,Address,Email,Password,courseID);
            stmt.execute(sql);
            return "success";
        }
        catch (Exception e) {
          System.out.println(e);
        };
        return "failure";
    }
    public String editStudent(int studentId, String Name, String Surname, String Address, String Email, String Password, int courseID){
        try {
            String sql = String.format("Update Student SET "+
            "student_name = '%s',student_surname = '%s',student_address = '%s',student_Email = '%s',student_Password = '%s',student_course = %d Where student_id = '%d'"
            ,Name,Surname,Address,Email,Password,courseID,studentId);
            stmt.execute(sql);
            return "success";
        }
        catch (Exception e) {
          System.out.println(e);
        };
        return "failure";
    }

    public String DeleteStudent(int studentId){
        try {
            String sql = String.format("Delete from Student where student_id = %d",studentId);
            stmt.execute(sql);
            return "success";
        }
        catch (Exception e) {
          System.out.println(e);
        };
        return "failure";
    }

    public ResultSet AllStudents(){
        try {
            String sql = String.format("Select * from Student");
            rs = stmt.executeQuery(sql);
            return rs;
        }
        catch (Exception e) {
          System.out.println(e);
        };
        return null;
    }
    
    public void closeConnection(){
        try {
            con.close();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }  



    //For local testing Purpose only
    public static void main(String[] args) {
        DataBaseConnection dat = new DataBaseConnection();
        try {
            ResultSet temp;
            temp = dat.AllStudents();
            while(temp.next())  
                System.out.println(temp.getInt(1)+"  "+temp.getString(2)+"  "+temp.getString(3));
           
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("we here");
        dat.closeConnection();
    }
}
