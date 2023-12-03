package com.example.finalproject;

import javafx.scene.control.TextField;

import java.io.IOException;

public class Balance {
    public TextField balanceToAdd;

    public void addBalance() throws IOException {
        if (!balanceToAdd.getText().isEmpty()) {
            UserProfileController.user.addBalance(Integer.parseInt(balanceToAdd.getText()));
            UserProfileController.window.close();
            StartupController.switchScene("userProfile.fxml");
        }
    }
}
