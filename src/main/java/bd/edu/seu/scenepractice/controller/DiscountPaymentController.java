package bd.edu.seu.scenepractice.controller;

import bd.edu.seu.scenepractice.HelloApplication;
import bd.edu.seu.scenepractice.model.DiscountRoomTransactionModel;
import bd.edu.seu.scenepractice.model.OtherTransactionModel;
import bd.edu.seu.scenepractice.servicepack.DiscountRoomTransactionService;
import bd.edu.seu.scenepractice.servicepack.OtherTransactionService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DiscountPaymentController implements Initializable
{

    @FXML
    private Label dateLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label typeLabel;
    @FXML
    public TextField mobileField;
    @FXML
    public TextField amountField;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        quantityLabel.setText(HelloApplication.discountRoomBenefitBook.getQuantity());
        dateLabel.setText(HelloApplication.discountRoomBenefitBook.getDate());
        typeLabel.setText(HelloApplication.discountRoomBenefitBook.getType());


    }

    public void pay()
    {
        String mobile=mobileField.getText();
        String amount=amountField.getText();


        DiscountRoomTransactionService discountRoomTransactionService=new DiscountRoomTransactionService();
        boolean isDiscountPaymentPayed=discountRoomTransactionService.discountRoomTransaction(new DiscountRoomTransactionModel(mobile,"pay in Bkash",amount));

        if(isDiscountPaymentPayed)
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
}

