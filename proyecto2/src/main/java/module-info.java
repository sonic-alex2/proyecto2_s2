module com.example.proyecto2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyecto2 to javafx.fxml;
    exports com.example.proyecto2;
}