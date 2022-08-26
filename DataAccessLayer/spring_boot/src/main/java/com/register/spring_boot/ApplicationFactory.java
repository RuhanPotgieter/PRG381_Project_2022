package com.register.spring_boot;

public class ApplicationFactory {
    public Object CRUD(String str){
        switch (str.toLowerCase()) {
            case "student":
                return new StudentController();
            case "register":
                return new RegisterController();
            case "administrator":
                return new AdministratorController();
            case "course":
                return new CourseController();
            case "subject":
                return new SubjectController();
            default:
                return null;
        }
    }
}
