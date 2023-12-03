package com.example.finalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class purchaseController implements Initializable {
    public TableColumn<Cars, Integer> priceCol;
    public Label insufBalance;
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

    static ObservableList<Cars> observableList = FXCollections.observableArrayList(
            new Cars(Models.PRIUS),
            new Cars(Models.YARIS),
            new Cars(Models.COROLLA),
            new Cars(Models.FORTUNER),
            new Cars(Models.SUPRA),
            new Cars(Models.LANDCRUISER)
    );
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        seatCol.setCellValueFactory(new PropertyValueFactory<>("Seats"));
        EngCol.setCellValueFactory(new PropertyValueFactory<>("Engine"));
        EngineSizeCol.setCellValueFactory(new PropertyValueFactory<>("engineSize"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("buyPrice"));
        tableView.setItems(observableList);
    }


    public void buy() throws IOException {
        Cars selectedCar = tableView.getSelectionModel().getSelectedItem();
        if (UserProfileController.user.getAccountBalance() >= selectedCar.getBuyPrice()) {
            UserProfileController.user.addCar(selectedCar);
            UserProfileController.user.subtractBalance(selectedCar.getBuyPrice());
            StartupController.switchScene("userProfile.fxml");
        }else {
            insufBalance.setText("Insufficient balance to purchase this car");
        }

    }

    public void back() throws IOException {
        StartupController.switchScene("userProfile.fxml");
    }
}
