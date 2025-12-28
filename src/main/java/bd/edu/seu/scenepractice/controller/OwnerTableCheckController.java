package bd.edu.seu.scenepractice.controller;

import bd.edu.seu.scenepractice.HelloApplication;
import bd.edu.seu.scenepractice.model.BookRoomModel;
import bd.edu.seu.scenepractice.servicepack.BookRoomService;
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

public class OwnerTableCheckController implements Initializable {
    @FXML
    public TableView<BookRoomModel> bookRoomTable;

    @FXML
    public TableColumn<BookRoomModel, String> dateColumn;

    @FXML
    public TableColumn<BookRoomModel, String> qualityColumn;

    @FXML
    public TableColumn<BookRoomModel, Number> roomColumn;

    @FXML
    public TableColumn<BookRoomModel, String> teleColumn;
    @FXML
    public TableColumn<BookRoomModel, Number> priceColumn;


    @FXML
    private TextField searchField;


    //label
    @FXML
    private Label qualityUpdateField;
    @FXML
    private Label quantityUpdateField;
    @FXML
    private Label dateUpdateField;
    @FXML
    private Label teleUpdateField;
    @FXML
    private Label priceUpdateField;

 //table er data text field e anar jonno
    @FXML
    private TextField teleField;
    @FXML
    private TextField qualityField;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField priceField;

//

    ObservableList<BookRoomModel> bookRoomModelObservableList;  //bahire declare

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        teleColumn.setCellValueFactory(cell->new SimpleStringProperty(cell.getValue().getTelephoneNum()));
        qualityColumn.setCellValueFactory(cell->new SimpleStringProperty(cell.getValue().getQuality()));
        dateColumn.setCellValueFactory(cell->new SimpleStringProperty(cell.getValue().getDate()));
        roomColumn.setCellValueFactory(cell->new SimpleIntegerProperty(cell.getValue().getQuantity()));
        priceColumn.setCellValueFactory(cell->new SimpleDoubleProperty(cell.getValue().getPrice()));


        //ObservableList<BookRoomModel> /////coz bahire already declared
         bookRoomModelObservableList= FXCollections.observableArrayList();

        //from database
        BookRoomService bookRoomService=new BookRoomService();
        List<BookRoomModel> detailList=bookRoomService.getBookRoomDetails();
        bookRoomModelObservableList.addAll(detailList);//////bahire declare
        //

        bookRoomTable.setItems(bookRoomModelObservableList);

    }

    public void home()

    {
        HelloApplication.changeScene("first-page");
    }


 //To Select
    BookRoomModel selectedItem;
    @FXML
    public void selectTableUser(MouseEvent event)
    {
        //delete
       selectedItem = bookRoomTable.getSelectionModel().getSelectedItem();

        //update
       if (selectedItem!=null){
           qualityUpdateField.setText(selectedItem.getQuality());
           quantityUpdateField.setText(String.valueOf(selectedItem.getQuantity()));
           dateUpdateField.setText(selectedItem.getDate());
           teleUpdateField.setText(selectedItem.getTelephoneNum());
           priceUpdateField.setText(String.valueOf(selectedItem.getPrice()));
    //
           qualityField.setText(selectedItem.getQuality());
           dateField.setText(selectedItem.getDate());
           quantityField.setText(String.valueOf(selectedItem.getQuantity()));
           teleField.setText(selectedItem.getTelephoneNum());
           priceField.setText(String.valueOf(selectedItem.getPrice()));

        //disable tele
        teleUpdateField.setDisable(true);
       }


    }
//delete
    @FXML
    public void delete(ActionEvent event)
    {


        if(selectedItem!=null){
            BookRoomService bookRoomService=new BookRoomService();
            bookRoomService.deleteInfo(selectedItem);

            bookRoomModelObservableList.clear();
            bookRoomModelObservableList.addAll(bookRoomService.getBookRoomDetails());


            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Success to delete");
            alert.showAndWait();

        }


    }
 //search

    @FXML
    void search(KeyEvent event) {
        String search=searchField.getText();
        BookRoomService friendDetailService=new BookRoomService();
        List<BookRoomModel> roomDetailList=friendDetailService.getBookRoomDetails();
        List<BookRoomModel> filterList=roomDetailList.stream().filter(c->c.getTelephoneNum().
                toLowerCase().contains(search.toLowerCase())).collect(Collectors.toList());
        bookRoomModelObservableList.clear();
        bookRoomModelObservableList.addAll(filterList);
    }
//update
    @FXML
    public void update(ActionEvent event)
    {

        String type=qualityField.getText();
        int numberOfRoom= Integer.parseInt(quantityField.getText());
        String mobile=teleField.getText();
        String date=dateField.getText();
        double price= Double.parseDouble(priceField.getText());

        System.err.println("Q: " + numberOfRoom);
        BookRoomModel bookRoomModel=new BookRoomModel(mobile,type,date,numberOfRoom,price);

        BookRoomService bookRoomService=new BookRoomService();
        boolean isUpdated= bookRoomService.updateInfo(bookRoomModel);

        if(isUpdated)
        {

            bookRoomModelObservableList.clear();
            bookRoomModelObservableList.addAll(bookRoomService.getBookRoomDetails());


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


}
