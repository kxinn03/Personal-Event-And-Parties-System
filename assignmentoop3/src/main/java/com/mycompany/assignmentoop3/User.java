/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.assignmentoop3;

/**
 *
 * @author user
 */
public class User {
    private String name;
    private char gender;
    private String email;
    private String telNo;
    private String username;
    private String password;


    // Getters and Setters for common attributes
    public User(String name, char gender, String email, String telNo, String username, String password) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.telNo = telNo;
        this.username = username;
        this.password = password;
    }
    public User(){
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
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

}