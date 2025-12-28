package bd.edu.seu.scenepractice.controller;

import bd.edu.seu.scenepractice.HelloApplication;
import bd.edu.seu.scenepractice.model.BookRoomModel;
import bd.edu.seu.scenepractice.model.TransactionModel;
import bd.edu.seu.scenepractice.servicepack.BookRoomService;
import bd.edu.seu.scenepractice.servicepack.TransactionService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class PaymentController implements Initializable
{
    @FXML
    public TextField mobileField;

    @FXML
    public TextField amountField;

    @FXML
    private Label dateLabel;
    @FXML
    private Label quantityLabel;

    @FXML
    private Label typeLabel;
    @FXML
    private Label amountLabel;




    public void home()
    {
        HelloApplication.changeScene("first-page");
    }

    @FXML
    public void pay(ActionEvent event)
    {
        String mobile=mobileField.getText();
        String amount=amountField.getText();

        TransactionService transactionService=new TransactionService();
        boolean isInserted=transactionService.InsertPayment(new TransactionModel(mobile,"pay in cash",amount));

        if(isInserted)
        {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("payment successful");
            alert.showAndWait();
        }
        else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Failed to pay");
            alert.showAndWait();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        typeLabel.setText(HelloApplication.roomBook.getQuality());
        quantityLabel.setText(String.valueOf(HelloApplication.roomBook.getQuantity()));
        dateLabel.setText(HelloApplication.roomBook.getDate());
        amountLabel.setText(String.valueOf(HelloApplication.totalPrice.getTotalPrice()));

    }
}


