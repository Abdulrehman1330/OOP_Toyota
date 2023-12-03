package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;


public class adminController {
    public Label incorPass;
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;


    public void adminPage() throws IOException {
        if (login()){
            StartupController.switchScene("adminProfile.fxml");
        }
        else incorPass.setText("Incorrect Password");
        password.clear();
    }

    public boolean login(){
        return (password.getText().equals("adminLogin") && username.getText().equals("Admin"));
    }

    public void back() throws IOException {
        StartupController.switchScene("Startup.fxml");
    }
}
