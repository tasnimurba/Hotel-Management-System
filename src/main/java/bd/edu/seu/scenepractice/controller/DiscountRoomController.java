package bd.edu.seu.scenepractice.controller;

import bd.edu.seu.scenepractice.HelloApplication;
import bd.edu.seu.scenepractice.model.DiscountRoomModel;
import bd.edu.seu.scenepractice.servicepack.DiscountRoomService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DiscountRoomController implements Initializable {
    @FXML
    private DatePicker dateField;

    @FXML
    private TextField quantityField;

    @FXML
    private ChoiceBox<String> typeField;

    @FXML
    void pay()
    {
      String choose=typeField.getValue();
      String date=dateField.getValue().toString();
      String quantity=quantityField.getText();

        DiscountRoomModel discountRoomModel=new DiscountRoomModel(choose,quantity,date);
        HelloApplication.discountRoomBenefitBook=discountRoomModel;

        DiscountRoomService discountRoomService=new DiscountRoomService();
        boolean isBooked=discountRoomService.discountRoom(discountRoomModel);

        if(isBooked)
        {
            HelloApplication.changeScene("discount-payment");
        }
        else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Failed");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initializing");

//choicebox
        ObservableList<String> discountRoomQualityBook= FXCollections.observableArrayList();

        discountRoomQualityBook.add("Business Class=BDT 20,000");
        discountRoomQualityBook.add("Suit=BDT 28,000");
        discountRoomQualityBook.add("Dulex Room=BDT 18,000");
        discountRoomQualityBook.add("Superior Room=BDT 22,000");
        discountRoomQualityBook.add("Single Room=BDT 10,000");
        discountRoomQualityBook.add("Double Room=BDT 18,100");
        discountRoomQualityBook.add("Quad=BDT 22,100");
        discountRoomQualityBook.add("Bridal Suit=BDT 26,000");
        discountRoomQualityBook.add("Junior Suit=BDT 20,100");
        //  quantityBook.setItems(FXCollections.observableArrayList("1","2","3"));


        typeField.setItems(discountRoomQualityBook);


    }
}