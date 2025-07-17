module com.example.gerenciadorjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gerenciadorjavafx to javafx.fxml;
    exports com.example.gerenciadorjavafx;
    exports com.example.gerenciadorjavafx.controler;
    opens com.example.gerenciadorjavafx.controler to javafx.fxml;
    opens com.example.gerenciadorjavafx.model;

}