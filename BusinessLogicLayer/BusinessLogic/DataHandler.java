package BusinessLogic;
import java.util.*;
public class DataHandler{
    public Integer student_id;
    public String student_name; 
    public String student_surname;
    public String student_address;
    public String email;
    public String password;
    public String student_course;
    
    public DataHandler() {
    }
    public DataHandler(Integer student_id, String student_name, String student_surname, String student_address,
            String email, String password, String student_course) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_surname = student_surname;
        this.student_address = student_address;
        this.email = email;
        this.password = password;
        this.student_course = student_course;
    }
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

}