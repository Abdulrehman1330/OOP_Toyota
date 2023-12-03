package com.example.finalproject;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;


public class registerController {
    @FXML
    public PasswordField passwordField;
    public Label incorEmail;
    public Label incorUser;
    public Label empty;
    public Label invAge;
    @FXML
    private TextField fNameField;
    @FXML
    private TextField lNameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField emailField;


    public static void saveUsersToFile() throws IOException, ClassNotFoundException {
        if (Main.existingUsers != null) {
            try {
                FileOutputStream fileOut = new FileOutputStream("users.ser");
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(Main.existingUsers);

                System.out.println(Main.existingUsers);
                objectOut.close();
                fileOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static ArrayList<User> getUsers() throws IOException, ClassNotFoundException {

        FileInputStream fileIn = new FileInputStream("users.ser");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        ArrayList<User> savedUsers;
        savedUsers = (ArrayList<User>) objectIn.readObject();
        System.out.println(savedUsers);
        objectIn.close();
        fileIn.close();
        return savedUsers;

    }

    @FXML
    protected void register() throws IOException {
        if (!(emailField.getText().contains("@") && emailField.getText().contains("."))) {
            incorEmail.setText("Invalid email");
            emailField.clear();
        }
        if (usernameField.getText().length()<3) {
            incorUser.setText("Invalid username");
            usernameField.clear();
        }
        if (!ageField.getText().matches("\\d+")) {
            ageField.clear();
            invAge.setText("Invalid age");
        }
        else if (!(emailField.getText().isEmpty() || passwordField.getText().isEmpty() || usernameField.getText().isEmpty() || fNameField.getText().isEmpty() || lNameField.getText().isEmpty() || ageField.getText().isEmpty())) {
            Main.existingUsers.add(new User(usernameField.getText(), passwordField.getText(), fNameField.getText(), lNameField.getText(), ageField.getText(), emailField.getText()));
            StartupController.switchScene("login_page.fxml");
        }else {
            empty.setText("Field cannot be empty");
        }
    }

    public void back() throws IOException {
        StartupController.switchScene("Startup.fxml");
    }
}