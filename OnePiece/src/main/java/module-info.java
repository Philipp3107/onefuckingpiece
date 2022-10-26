module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.play.onepiece to javafx.fxml;
    exports com.play.onepiece;
}