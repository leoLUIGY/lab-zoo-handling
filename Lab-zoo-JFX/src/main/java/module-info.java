module com.example.labzoojfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.labzoojfx to javafx.fxml;
    exports com.example.labzoojfx;
}