package com.example.finalproject;

import javafx.scene.control.TextField;

import java.io.IOException;

public class EditUser {

    User user = UserProfileController.user;
    public TextField password;

    public TextField emailField;
    public TextField usernameField;
    public TextField ageField;
    public TextField nameField;
    public TextField nameField1;

    public void changePass() {
        if (!password.getText().isEmpty()) {
            for (User user1 : Main.existingUsers)
                if (user1.equals(user)) {
                    user1.setPassword(password.getText());
                    break;
                }
            password.clear();
        }
    }
    public void changeEmail() throws IOException {
        if (!emailField.getText().isEmpty()) {
            for (User user1 : Main.existingUsers) {
                if (user1.equals(user)) {
                    user1.setEmail(emailField.getText());
                    break;
                }
            }
            emailField.clear();
        }
    }

    public void changeUsername() throws IOException {
        if (!(usernameField.getText().isEmpty())) {
            for (User user1 : Main.existingUsers) {
                if (user1.equals(user)) {
                    user1.setUsername(usernameField.getText());
                    break;
                }
            }
            usernameField.clear();
        }
    }

    public void changeAge() throws IOException {
        if (!(ageField.getText().isEmpty())) {
            for (User user1 : Main.existingUsers) {
                if (user1.equals(user)) {
                    user1.setAge(ageField.getText());
                    break;
                }
            }
            ageField.clear();
        }
    }

    public void changeName() throws IOException {
        if (!(nameField1.getText().isEmpty() && nameField.getText().isEmpty())) {
            for (User user1 : Main.existingUsers) {
                String[] name = user1.getName().split(" ");
                if (user1.equals(user)) {
                    if (!(nameField1.getText().isEmpty() && nameField.getText().isEmpty())) {
                        user1.setName(nameField.getText(), nameField1.getText());
                        break;
                    }
                    if (nameField1.getText().isEmpty()) {
                        user1.setName(nameField.getText(), name[1]);
                        break;
                    }
                    if (nameField.getText().isEmpty()) {
                        user1.setName(name[0], nameField1.getText());
                        break;
                    }
                }
            }
            nameField.clear();
            nameField1.clear();
        }
    }
    public void back() throws IOException {
       StartupController.switchScene("UserInfo.fxml");
    }
}
