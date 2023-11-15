module com.main.graf {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.main.graf to javafx.fxml;
    exports com.main.main;
    opens com.main.main to javafx.fxml;
}