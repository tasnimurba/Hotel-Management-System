package bd.edu.seu.scenepractice.controller;
import bd.edu.seu.scenepractice.HelloApplication;
import bd.edu.seu.scenepractice.model.OwnerPageModel;
import bd.edu.seu.scenepractice.model.UserModel;
import bd.edu.seu.scenepractice.servicepack.OwnerPageService;
import bd.edu.seu.scenepractice.servicepack.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class OwnerPageController
{

        @FXML
        private TextField numberField;

        @FXML
        private PasswordField passField;



        @FXML
        void login(ActionEvent event) {

            String num=numberField.getText();
            String pass=passField.getText();


            System.out.println(num+","+pass);
            OwnerPageService ownerPageService=new OwnerPageService();
            OwnerPageModel ownerPageModel =ownerPageService.ownerInfo(num,pass);
            System.out.println("1");

            if(ownerPageModel != null)
            {
                HelloApplication.changeScene("owner-table-check");
            }
            else
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Failed to login");
                alert.showAndWait();
            }

        }

    @FXML
    void loginOther(ActionEvent event) {

        String num = numberField.getText();
        String pass = passField.getText();


        System.out.println(num + "," + pass);
        OwnerPageService ownerPageService = new OwnerPageService();
        OwnerPageModel ownerPageModel = ownerPageService.ownerInfo(num, pass);
        System.out.println("1");

        if (ownerPageModel != null) {
            HelloApplication.changeScene("owner-table-check-other");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Failed to login");
            alert.showAndWait();
        }
    }




    public void home()

    {
        HelloApplication.changeScene("first-page");
    }


}

