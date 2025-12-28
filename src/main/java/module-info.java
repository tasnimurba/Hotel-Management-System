module bd.edu.seu.scenepractice {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens bd.edu.seu.scenepractice to javafx.fxml;
    exports bd.edu.seu.scenepractice;
    exports bd.edu.seu.scenepractice.model;
    opens bd.edu.seu.scenepractice.model to javafx.fxml;
    exports bd.edu.seu.scenepractice.controller;
    opens bd.edu.seu.scenepractice.controller to javafx.fxml;
    exports bd.edu.seu.scenepractice.singleton;
    opens bd.edu.seu.scenepractice.singleton to javafx.fxml;
}