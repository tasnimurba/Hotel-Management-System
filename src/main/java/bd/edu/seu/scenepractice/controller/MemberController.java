package bd.edu.seu.scenepractice.controller;

import bd.edu.seu.scenepractice.HelloApplication;
import bd.edu.seu.scenepractice.model.UserModel;
import bd.edu.seu.scenepractice.servicepack.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MemberController {

    @FXML
    public TextField nameField;
    @FXML
    public TextField numField;
    @FXML
    public PasswordField passField;
    @FXML
    public PasswordField newPassField;


    @FXML
    public void sign()
    {
        String name=nameField.getText();
        String number=numField.getText();
        String passMember=passField.getText();
        String repass=newPassField.getText();


        UserModel userModel =new UserModel(name,number,passMember);
        UserService userService=new UserService();
        boolean isSigned = userService.memberCreate(userModel);

        if(isSigned)
        {
           HelloApplication.changeScene("login");
        }
        else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Failed to sign up");
            alert.showAndWait();
        }

       // String line=name + "," +number+ "," +passMember+ "," +repass;
        //System.out.println(line);
    }

    @FXML
    public void goToLogin()
    {
        HelloApplication.changeScene("login");
    }
    @FXML
    public void home()
    {
        HelloApplication.changeScene("hello-view");
    }

}
