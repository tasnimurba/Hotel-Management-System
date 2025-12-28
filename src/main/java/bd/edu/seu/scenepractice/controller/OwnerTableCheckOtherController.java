package bd.edu.seu.scenepractice.controller;

import bd.edu.seu.scenepractice.HelloApplication;
import bd.edu.seu.scenepractice.model.BookRoomModel;
import bd.edu.seu.scenepractice.model.OtherOptionModel;
import bd.edu.seu.scenepractice.servicepack.BookRoomService;
import bd.edu.seu.scenepractice.servicepack.OtherService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class OwnerTableCheckOtherController implements Initializable {

    @FXML
    public TableView<OtherOptionModel> otherTableColumn;

    @FXML
    public TableColumn<OtherOptionModel, String> dateOtherColumn;

    @FXML
    public TableColumn<OtherOptionModel, String> identityOtherColumn;

    @FXML
    public TableColumn<OtherOptionModel, String> nameOtherColumn;


    @FXML
    public TableColumn<OtherOptionModel, Number> quantityOtherColumn;

    @FXML
    public TableColumn<OtherOptionModel, String> telephoneOtherColumn;

    @FXML
    public TableColumn<OtherOptionModel, String> typeOtherColumn;

    @FXML
    public TableColumn<OtherOptionModel, Number> priceOtherColumn;


    //label
    @FXML
    public Label qualityOtherUpdateField;
    @FXML
    public Label quantityOtherUpdateField;
    @FXML
    public Label dateOtherUpdateField;
    @FXML
    public Label teleOtherUpdateField;
    @FXML
    public Label priceOtherUpdateField;
    @FXML
    public Label identityOtherUpdateField;
    @FXML
    public Label nameOtherUpdateField;



    //table er data text field e anar jonno
    @FXML
    public TextField teleOtherField;
    @FXML
    public TextField qualityOtherField;
    @FXML
    public TextField quantityOtherField;
    @FXML
    public TextField dateOtherField;
    @FXML
    public TextField priceOtherField;
    @FXML
    public TextField identityOtherField;
    @FXML
    public TextField nameOtherField;


//

    @FXML
    public TextField searchOtherField;



    ObservableList<OtherOptionModel> otherOptionModelObservableList;  //bahire declare

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameOtherColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));
        typeOtherColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getOtherQuality()));
        identityOtherColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getIdentity()));
        dateOtherColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDateOther()));
        quantityOtherColumn.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getNumberRoomOther()));
        priceOtherColumn.setCellValueFactory(cell -> new SimpleDoubleProperty(cell.getValue().getPrice()));


        //ObservableList<BookRoomModel> /////coz bahire already declared
        otherOptionModelObservableList = FXCollections.observableArrayList();

        //from database
        OtherService otherService = new OtherService();
        List<OtherOptionModel> otherDetailList = otherService.getOtherBookRoomDetails();
        otherOptionModelObservableList.addAll(otherDetailList);//////bahire declare
        //

        otherTableColumn.setItems(otherOptionModelObservableList);

    }

    //To Select
    OtherOptionModel otherSelectedItem;

    @FXML
    public void selectOtherTableUser(MouseEvent event) {
        //delete
        otherSelectedItem = otherTableColumn.getSelectionModel().getSelectedItem();

        //update
        if (otherSelectedItem != null) {
            qualityOtherUpdateField.setText(otherSelectedItem.getOtherQuality());
            quantityOtherUpdateField.setText(String.valueOf(otherSelectedItem.getNumberRoomOther()));
            dateOtherUpdateField.setText(otherSelectedItem.getDateOther());
            teleOtherUpdateField.setText(otherSelectedItem.getTelephone());
            priceOtherUpdateField.setText(String.valueOf(otherSelectedItem.getPrice()));
            nameOtherUpdateField.setText(otherSelectedItem.getName());
            identityOtherUpdateField.setText(otherSelectedItem.getIdentity());
            //
            qualityOtherField.setText(otherSelectedItem.getOtherQuality());
            dateOtherField.setText(otherSelectedItem.getTelephone());
            quantityOtherField.setText(String.valueOf(otherSelectedItem.getNumberRoomOther()));
            teleOtherField.setText(otherSelectedItem.getTelephone());
            priceOtherField.setText(String.valueOf(otherSelectedItem.getPrice()));
            nameOtherField.setText(otherSelectedItem.getName());
            identityOtherField.setText(otherSelectedItem.getIdentity());

            //disable tele
            teleOtherUpdateField.setDisable(true);
        }


    }

    //delete
    @FXML
    public void delete(ActionEvent event) {


        if (otherSelectedItem != null) {
            OtherService otherService = new OtherService();
            otherService.deleteOtherInfo(otherSelectedItem);

            otherOptionModelObservableList.clear();
            otherOptionModelObservableList.addAll(otherService.getOtherBookRoomDetails());


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Success to delete");
            alert.showAndWait();

        }
    }

    //update
    @FXML
    public void update(ActionEvent event)
    {

        String type=qualityOtherField.getText();
        int numberOfRoom= Integer.parseInt(quantityOtherField.getText());
        String mobile=teleOtherField.getText();
        String date=dateOtherField.getText();
        double price= Double.parseDouble(priceOtherField.getText());
        String name=nameOtherField.getText();
        String identity=identityOtherField.getText();


        System.err.println("Q: " + numberOfRoom);
        OtherOptionModel otherOptionModel=new OtherOptionModel(identity,date,numberOfRoom,mobile,name,type,price);

        OtherService otherService=new OtherService();
        boolean isUpdated= otherService.updateOtherInfo(otherOptionModel);

        if(isUpdated)
        {

            otherOptionModelObservableList.clear();
            otherOptionModelObservableList.addAll(otherService.getOtherBookRoomDetails());


            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Success to update");
            alert.showAndWait();
        }
        else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Failed to update");
            alert.showAndWait();
        }
    }

    //search

    @FXML
    void search(KeyEvent event) {
        String search=searchOtherField.getText();
        OtherService otherService=new OtherService();
        List<OtherOptionModel> otherRoomDetailList=otherService.getOtherBookRoomDetails();
        List<OtherOptionModel> filterOtherList=otherRoomDetailList.stream().filter(c->c.getTelephone().
                toLowerCase().contains(search.toLowerCase())).collect(Collectors.toList());
        otherOptionModelObservableList.clear();
        otherOptionModelObservableList.addAll(filterOtherList);
    }




    public void home()

    {
        HelloApplication.changeScene("first-page");
    }
}



