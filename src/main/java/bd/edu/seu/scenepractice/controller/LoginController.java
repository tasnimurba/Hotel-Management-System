package bd.edu.seu.scenepractice.controller;

import bd.edu.seu.scenepractice.HelloApplication;
import bd.edu.seu.scenepractice.model.UserModel;
import bd.edu.seu.scenepractice.servicepack.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController
{
    @FXML
    public TextField numberSignField;
    @FXML
    public PasswordField passSignField;


    @FXML
    public void login()
    {
        String number=numberSignField.getText();
        String pass=passSignField.getText();

        //User user=new User(number,pass);
        UserService userService=new UserService();
        UserModel userModel =userService.login(number,pass);


        if(userModel != null)
        {
            //HelloApplication.loggedUserModel = userModel;
            HelloApplication.changeScene("dashboxone");
        }
        else
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Failed to login");
            alert.showAndWait();
        }

       // String line=number + "," +pass;
        //System.out.println(line);
    }

    @FXML
    public void goForMembership()
    {
        HelloApplication.changeScene("member");
    }
    @FXML
    public void home()
    {
        HelloApplication.changeScene("hello-view");
    }

}
