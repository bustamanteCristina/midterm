/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugstore;

import java.util.ArrayList;

/**
 *
 * @author 2ndyrGroupB
 */
public class Account {
    private String username;
    private String password;
    private String fname;
    private String lname;
    private int age;

    public Account() {
    }
    
    public Account(String username, String password, String fname, String lname, int age) {
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }
    
      
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
            
  
    @Override
    public String toString() {
        return String.format("%-20s %-20s %-20s %-20d", username, fname, lname, age);
    }
   
}
