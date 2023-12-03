package com.example.finalproject;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class StartupController {

    @FXML
    public void registerScene() throws IOException {
        switchScene("register_page.fxml");
    }
    @FXML
    public void loginScene() throws IOException {
        switchScene("login_page.fxml");
    }
    public void adminScene() throws IOException {
        switchScene("admin.fxml");
    }
    public static void switchScene(String page) throws IOException {
        Stage stage1 = Main.stage;
        Parent root;
        root = FXMLLoader.load(StartupController.class.getResource(page));
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.show();
        stage1.setOnCloseRequest(e -> {
            try {
                registerController.saveUsersToFile();
            } catch (IOException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
