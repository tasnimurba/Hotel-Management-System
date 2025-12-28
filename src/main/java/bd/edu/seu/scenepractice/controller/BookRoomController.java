package bd.edu.seu.scenepractice.controller;

import bd.edu.seu.scenepractice.HelloApplication;
import bd.edu.seu.scenepractice.model.BookRoomModel;
import bd.edu.seu.scenepractice.servicepack.BookRoomService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class BookRoomController implements Initializable
{
    @FXML
    private DatePicker dateBook;

    @FXML
    private ChoiceBox<String> qualityBook;

    @FXML
    private TextField quantityBook;

    @FXML
    private TextField teleBook;

    @FXML
    private TextField priceBook;



    @FXML
    void pay(ActionEvent event) {
//        selectedQuantity=teleBook
        String type=qualityBook.getValue();
        int numberOfRoom= Integer.parseInt(quantityBook.getText());
        String mobile=teleBook.getText();
        String date=dateBook.getValue().toString();
        double price= Double.parseDouble(priceBook.getText());

        //to sum prices
        BookRoomModel bookModel=new BookRoomModel(mobile,type,date,numberOfRoom,price);
        HelloApplication.totalPrice=bookModel;
//        BookRoomService multiplyService=new BookRoomService();
//        boolean isSuccess= multiplyService.multiply(bookModel);

//        if(isSuccess)
//        {
//            Alert alert=new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("success");
//            alert.setContentText("Thanks for Trusting Our Process and Booking Our Hotel Room Again!");
//            alert.showAndWait();
//        }
//        else {
//            Alert alert=new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("success");
//            alert.setContentText("Your First Booking in Our Hotel is Successful!");
//            alert.showAndWait();
//        }

//       double totalSum=numberOfRoom*price;
//        System.out.println("total sum=" +totalSum);

//sum er kaaj shesh

       int quantity = Integer.parseInt(quantityBook.getText()) ;
       if(quantity<8){
           HelloApplication.changeScene("payment");
          // System.out.println(quantity);
       }else {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setContentText("No Room Available");
           alert.showAndWait();
       }

        BookRoomModel bookRoomModel=new BookRoomModel(mobile,type,date,numberOfRoom,price);
        HelloApplication.roomBook=bookRoomModel; //payment

        BookRoomService bookRoomService=new BookRoomService();
        boolean isBooked= bookRoomService.bookRoomNow(bookRoomModel);

        if(isBooked)
        {
           // HelloApplication.changeScene("payment");
        }
        else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Failed to go to payment scene");
            alert.showAndWait();
        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initializing");

//choicebox
        ObservableList<String> roomBookType= FXCollections.observableArrayList();

        roomBookType.add("Business Class=BDT 20,000");
        roomBookType.add("Suit=BDT 28,000");
        roomBookType.add("Dulex Room=BDT 18,000");
        roomBookType.add("Superior Room=BDT 22,000");
        roomBookType.add("Single Room=BDT 10,000");
        roomBookType.add("Double Room=BDT 18,100");
        roomBookType.add("Quad=BDT 22,100");
        roomBookType.add("Bridal Suit=BDT 26,000");
        roomBookType.add("Junior Suit=BDT 20,100");
        //  quantityBook.setItems(FXCollections.observableArrayList("1","2","3"));


        qualityBook.setItems(roomBookType);

    }


    @FXML
    void home(MouseEvent event) {
        HelloApplication.changeScene("hello-view");

    }
}

