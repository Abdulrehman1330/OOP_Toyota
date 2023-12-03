package com.example.finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Main extends Application {

    static Stage stage;

    static ArrayList<User> existingUsers = new ArrayList<>();

    static FXMLLoader fxmlLoader;
    static {
        try {
            File file = new File("users.ser");
            if (!(file.exists()&&file.length() == 0)) {
                existingUsers = registerController.getUsers();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void start(Stage primarystage) throws IOException{
        stage = primarystage;
        fxmlLoader = new FXMLLoader(getClass().getResource("Startup.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load());

        stage.setTitle("Toyota Showroom");
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}