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


public class UserProfileController{
    static Stage window;

    public Label welcome;

    public static User user;
    static ObservableList<Cars> observableList = FXCollections.observableArrayList();
    public TableColumn<Cars, Integer> priceCol;
    @FXML
    private TableColumn<Cars, Integer> seatCol;
    @FXML
    public TableColumn<Cars, String> nameCol;
    @FXML
    private TableView<Cars> tableView;
    @FXML
    private TableColumn<Cars, String> EngCol;
    @FXML
    private TableColumn<Cars, Integer> EngineSizeCol;

    public void initialize() {
        user = LoggedInUser.getLoggedInUser();
        observableList.clear();
        if (user != null) {
            welcome.setText("Welcome, %s \nLogged in at %s\nYour account balance is: %d $".formatted(user.getName(), LoggedInUser.getLoggedInDate(),user.getAccountBalance()));
            observableList.addAll(user.cars);
        }
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        seatCol.setCellValueFactory(new PropertyValueFactory<>("Seats"));
        EngCol.setCellValueFactory(new PropertyValueFactory<>("Engine"));
        EngineSizeCol.setCellValueFactory(new PropertyValueFactory<>("engineSize"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        tableView.setItems(observableList);

    }


    public void logout() throws IOException {
        StartupController.switchScene( "Startup.fxml");
        observableList.clear();
    }

    public void purchase() throws IOException {
        StartupController.switchScene("purchase.fxml");
        observableList.clear();
    }

    public void sell() throws IOException {
        Cars selected = tableView.getSelectionModel().getSelectedItem();
        user.addBalance(selected.sellPrice);
        user.cars.remove(selected);
        StartupController.switchScene("userProfile.fxml");
    }

    public void profile() throws IOException {
        StartupController.switchScene("userInfo.fxml");
    }

    public void add() throws IOException {
        window = new Stage();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Balance.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
}
