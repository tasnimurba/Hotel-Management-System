package bd.edu.seu.scenepractice;

import bd.edu.seu.scenepractice.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static UserModel loggedUserModel;
    public static OwnerPageModel ownerInfo;
    public static DiscountRoomModel discountRoomBenefitBook;
    public static AfterLoginBenefitModel benefitBook;
    public static OtherOptionModel otherBook;

    public static BookRoomModel roomBook; //payment


    public static BookRoomModel totalPrice;


    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("first-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        stage.setTitle("Green View Hotel");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void changeScene(String fxmlFileName) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFileName+".fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 500);
            stage.setScene(scene);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}