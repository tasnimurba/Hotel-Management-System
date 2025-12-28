package bd.edu.seu.scenepractice.controller;

import bd.edu.seu.scenepractice.HelloApplication;
import bd.edu.seu.scenepractice.model.OtherOptionModel;
import bd.edu.seu.scenepractice.servicepack.OtherService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class OtherController implements Initializable
{

    @FXML
    public TextField numberOther;

    @FXML
    public ToggleGroup landlord;

    @FXML
    public TextField otherNameField;
    @FXML
    public TextField otherTeleField;

    @FXML
    public ChoiceBox<String> typeField;

    @FXML
    public DatePicker dateOther;

    @FXML
    public TextField otherPrice;




    public void book()
    {
        String nameOfLand=otherNameField.getText();
        String teleOfLand=otherTeleField.getText();
        String qualityOfRoomOther=typeField.getValue();
        int selectNumOther= Integer.parseInt(numberOther.getText());
        String selectedDate=dateOther.getValue().toString();
        double price= Double.parseDouble(otherPrice.getText());

        RadioButton landRadio=(RadioButton) landlord.getSelectedToggle();
        String land=landRadio.getText();
//1st objects
        OtherOptionModel otherOptionModel=new OtherOptionModel(nameOfLand,selectedDate,selectNumOther,teleOfLand,land,qualityOfRoomOther,price);
        HelloApplication.otherBook=otherOptionModel;
//2nd object
        OtherService otherService=new OtherService();
        boolean isBooked =otherService.otherRoomBook(otherOptionModel);
//
        if(isBooked)
        {
            HelloApplication.changeScene("other-payment");
        }
        else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Failed to sign up");
            alert.showAndWait();
        }

        //String line=selectNumOther +"," +land+ "," +nameOfLand+ "," +teleOfLand+ ","+qualityOfRoomOther+ "," +selectedDate;
        //System.out.println(line);



        //HelloApplication.changeScene("other-payment");
    }


    public void home()
    {
        HelloApplication.changeScene("hello-view");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        System.out.println("initializing");

//choicebox
        ObservableList<String> otherRoomQualityBook= FXCollections.observableArrayList();

        otherRoomQualityBook.add("Business Class=BDT 20,000");
        otherRoomQualityBook.add("Suit=BDT 28,000");
        otherRoomQualityBook.add("Dulex Room=BDT 18,000");
        otherRoomQualityBook.add("Superior Room=BDT 22,000");
        otherRoomQualityBook.add("Single Room=BDT 10,000");
        otherRoomQualityBook.add("Double Room=BDT 18,100");
        otherRoomQualityBook.add("Quad=BDT 22,100");
        otherRoomQualityBook.add("Bridal Suit=BDT 26,000");
        otherRoomQualityBook.add("Junior Suit=BDT 20,100");
        //  quantityBook.setItems(FXCollections.observableArrayList("1","2","3"));


        typeField.setItems(otherRoomQualityBook);

    }
}
