package com.example.finalproject;

public class LoggedInUser {
    private static User loggedInUser;

    private static String loggedInDate;


    public static String getLoggedInDate(){
        return loggedInDate;
    }

    public  static void setDate(String date){
        loggedInDate = date;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User user) {
        loggedInUser = user;
    }
}
