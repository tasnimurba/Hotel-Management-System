package bd.edu.seu.scenepractice.controller;

import bd.edu.seu.scenepractice.HelloApplication;
import bd.edu.seu.scenepractice.model.AfterLoginBenefitModel;
import bd.edu.seu.scenepractice.servicepack.AfterLoginBenefitService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboxControllerOne implements Initializable
{
    @FXML
    private TextField dateTimeField;

    @FXML
    private ChoiceBox<String> optionField;

    @FXML
    private TextField numberPersonField;


    public void book()
    {
      String toChoose=optionField.getValue();
      String date=dateTimeField.getText();
      String calculate=numberPersonField.getText();

      //1st object
        AfterLoginBenefitModel afterLoginBenefitModel=new AfterLoginBenefitModel(toChoose,date,calculate);
        HelloApplication.benefitBook=afterLoginBenefitModel;

      //2nd object
        AfterLoginBenefitService afterLoginBenefitService=new AfterLoginBenefitService();
       boolean isBooked= afterLoginBenefitService.insertToBookBenefit(afterLoginBenefitModel);

        if(isBooked)
        {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Booked successfully");
            alert.showAndWait();
        }
        else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Failed to Booked");
            alert.showAndWait();
        }

    }

    @FXML
    void click(ActionEvent event)
    {

        HelloApplication.changeScene("discount-room");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        System.out.println("initializing");

//choicebox
        ObservableList<String> serviceChoose= FXCollections.observableArrayList();

        serviceChoose.add("Book for spa");
        serviceChoose.add("Book for event");
        serviceChoose.add("Book for breakfast");
        serviceChoose.add("Book for lunch");
        serviceChoose.add("Book for Dinner");
        serviceChoose.add("Book for Swimming alone");
        serviceChoose.add("Book for special date ");
        serviceChoose.add("Book for meeting");

        //  quantityBook.setItems(FXCollections.observableArrayList("1","2","3"));


        optionField.setItems(serviceChoose);


    }
}
