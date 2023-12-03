package com.example.finalproject;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class loginController {

    @FXML
    public Label user;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    public void userScene() throws IOException{
        if (login()) {
            StartupController.switchScene("userProfile.fxml");
        }
    }
    public boolean login() {
            for (User savedUser : Main.existingUsers) {
                if (savedUser.getUsername().equals(usernameField.getText()) && savedUser.CheckPassword(passwordField.getText())) {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime localDateTime = LocalDateTime.now();
                    LoggedInUser.setDate(dtf.format(localDateTime));
                    LoggedInUser.setLoggedInUser(savedUser);
                    return true;
                }
                if (savedUser.getUsername().equals(usernameField.getText())&& !savedUser.CheckPassword(passwordField.getText())){
                    user.setText("Incorrect password");
                    passwordField.clear();
                    return false;
                }
            }
            user.setText("Invalid username");
            usernameField.clear();
            passwordField.clear();
            return false;
    }

    public void back() throws IOException {
        StartupController.switchScene("Startup.fxml");
    }
}
