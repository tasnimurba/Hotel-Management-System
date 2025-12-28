package bd.edu.seu.scenepractice.controller;

import bd.edu.seu.scenepractice.HelloApplication;
import bd.edu.seu.scenepractice.model.OtherTransactionModel;
import bd.edu.seu.scenepractice.servicepack.OtherTransactionService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class OtherPaymentController implements Initializable
{
    @FXML
    public Label nameLabel;
    @FXML
    public Label quantityLabel;
    @FXML
    public Label dateLabel;
    @FXML
    public Label roomTypeLabel;

    @FXML
    public TextField mobileOtherField;
    @FXML
    public TextField amountOtherField;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        nameLabel.setText(HelloApplication.otherBook.getName());
        quantityLabel.setText(String.valueOf(HelloApplication.otherBook.getNumberRoomOther()));
        dateLabel.setText(HelloApplication.otherBook.getDateOther());
        roomTypeLabel.setText(HelloApplication.otherBook.getOtherQuality());


    }

    public void pay()
    {
        String mobile=mobileOtherField.getText();
        String amount=amountOtherField.getText();


        OtherTransactionService otherTransactionService=new OtherTransactionService();
        boolean isOtherInserted=otherTransactionService.InsertPaymentOther(new OtherTransactionModel(mobile,"cash in bkash",amount));

        if(isOtherInserted)
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

    public void home()
    {
        HelloApplication.changeScene("first-page");
    }
}
