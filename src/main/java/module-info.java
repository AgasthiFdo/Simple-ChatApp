module lk.ijse.gdse.simple_chatapllication {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.ijse.gdse.simple_chatapllication.controller to javafx.fxml;
    exports lk.ijse.gdse.simple_chatapllication;
    opens lk.ijse.gdse.simple_chatapllication to javafx.base;
}