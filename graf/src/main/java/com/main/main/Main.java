package com.main.main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        com.main.main.Page page = new com.main.main.Page();
        group.getChildren().add(page);
        page.canvas.pressed(page, page.line);
        Scene scene = new Scene(group, 900, 600);
        scene.setFill(Color.web("#282828"));
        stage.setScene(scene);
        stage.show();
    }


}