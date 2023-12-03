package com.example.finalproject;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String username;
    private String password;
    private String name;
    private int age;

    private String email;

    public String getEmail() {
        return email;
    }

    private int AccountBalance;


    public ArrayList<Cars> cars = new ArrayList<>();

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

    public String getName() {
        return name;
    }

    public void setName(String fname, String lname) {
        name = fname + " " + lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = Integer.parseInt(age);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAccountBalance() {
        return AccountBalance;
    }

    public void addBalance(int i){
        this.AccountBalance += i;
    }
    public void subtractBalance(int i){
        this.AccountBalance -= i;
    }

    public User(String username, String password, String fname, String lname, String Age, String email) {
        setEmail(email);
        setUsername(username);
        setPassword(password);
        setName(fname, lname);
        setAge(Age);
        AccountBalance = 5000;
    }

    public boolean CheckPassword(String password) {
        if (this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public void addCar(Cars car) {
        if (car!= null)
            cars.add(car);
    }

    public String getCars(){
        return cars.toString();
    }

    @Override
    public String toString() {
        return "USERNAME : " + username + " " + "PASSWORD: " + password + " " + "NAME : " + name;
    }

}


