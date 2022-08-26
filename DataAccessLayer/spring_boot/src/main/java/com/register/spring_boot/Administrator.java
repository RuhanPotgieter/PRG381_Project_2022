package com.register.spring_boot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrator {
    private long Admin_id;
    private  String Admin_name, password, contact;


    public Administrator() {
    }

    public Administrator(long Admin_id, String Admin_name, String password, String contact) {
        this.Admin_id = Admin_id;
        this.Admin_name = Admin_name;
        this.password = password;
        this.contact = contact;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getAdmin_id() {
        return this.Admin_id;
    }

    public void setAdmin_id(long Admin_id) {
        this.Admin_id = Admin_id;
    }

    public String getAdmin_name() {
        return this.Admin_name;
    }

    public void setAdmin_name(String Admin_name) {
        this.Admin_name = Admin_name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Administrator Admin_id(long Admin_id) {
        setAdmin_id(Admin_id);
        return this;
    }

    public Administrator Admin_name(String Admin_name) {
        setAdmin_name(Admin_name);
        return this;
    }

    public Administrator password(String password) {
        setPassword(password);
        return this;
    }

    public Administrator contact(String contact) {
        setContact(contact);
        return this;
    }
}
