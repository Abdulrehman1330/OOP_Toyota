package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class UserInfo {
    public Label Age;
    public static User user;
    public Label balance;
    @FXML
    private Label username;
    @FXML
    private Label name;
    @FXML
    Label email;
    public void initialize() {
        user = LoggedInUser.getLoggedInUser();
        if (user != null) {
            username.setText(user.getUsername());
            name.setText(user.getName());
            balance.setText("%d $".formatted(user.getAccountBalance()));
            email.setText(user.getEmail());
            Age.setText("%d".formatted(user.getAge()));
        }
    }
    public void edit() throws IOException {
        StartupController.switchScene("EditUser.fxml");
    }

    public void back() throws IOException {
        StartupController.switchScene("userProfile.fxml");
    }
}
