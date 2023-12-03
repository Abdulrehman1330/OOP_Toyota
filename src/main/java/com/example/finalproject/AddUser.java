package com.example.finalproject;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddUser {
    public TextField fname;
    public TextField lname;
    public TextField age;
    public TextField username;

    public PasswordField password;
    public TextField email;
    public Label invAge;
    public Label incorEmail;
    public Label incorUser;
    public Label empty;

    public void adduser() throws IOException {

        if (username.getText().length()<3) {
            incorUser.setText("Invalid username");
            username.clear();
        }
        if (!age.getText().matches("\\d+")) {
            age.clear();
            invAge.setText("Invalid age");
        }
        if (!(email.getText().contains("@") && email.getText().contains("."))) {
            incorEmail.setText("Invalid email");
            email.clear();
        }

        else if (!(email.getText().isEmpty() || password.getText().isEmpty() || username.getText().isEmpty() || fname.getText().isEmpty() || lname.getText().isEmpty() || age.getText().isEmpty())){
            Main.existingUsers.add(new User(username.getText(),password.getText(),fname.getText(),lname.getText(),age.getText(), email.getText()));
            StartupController.switchScene("adminProfile.fxml");
            UserProfileController.window.close();
        } else {
            empty.setText("Field cannot be empty");
        }
    }

    public void back(){
        UserProfileController.window.close();
    }
}
