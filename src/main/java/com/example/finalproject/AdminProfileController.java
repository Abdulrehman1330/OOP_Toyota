package com.example.finalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminProfileController {
    @FXML
    public TableColumn<Cars, String> carCol;
    public Label length;
    public TableColumn<Cars, String> emailCol;
    public TableColumn<Cars, String> balanceCol;
    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<Cars, String> nameCol;
    @FXML
    private TableColumn<Cars, String> ageCol;
    @FXML
    private TableColumn<Cars, String> usernameCol;

    public void initialize(){
        length.setText("Total Users\n"+ Main.existingUsers.size());
        emailCol.setCellValueFactory(new PropertyValueFactory<>("Email"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("Age"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("Username"));
        carCol.setCellValueFactory(new  PropertyValueFactory<>("Cars"));
        balanceCol.setCellValueFactory(new PropertyValueFactory<>("AccountBalance"));
        observableList.addAll(Main.existingUsers);
        tableView.setItems(observableList);

    }

    ObservableList<User> observableList = FXCollections.observableArrayList();



    public void exit() throws IOException {
        StartupController.switchScene("Startup.fxml");
        observableList.clear();
    }

    public void remove() throws IOException {
        User user = tableView.getSelectionModel().getSelectedItem();
        observableList.remove(user);
        Main.existingUsers.remove(user);
        StartupController.switchScene("adminProfile.fxml");
    }

    public void addUser() throws IOException {
        UserProfileController.window = new Stage();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("AddUser.fxml"));
        Scene scene = new Scene(root);
        UserProfileController.window.setScene(scene);
        UserProfileController.window.show();
    }
}
