module com.lab5_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    opens com.lab5_1 to javafx.fxml;
    exports com.lab5_1;
    requires java.naming;
}
