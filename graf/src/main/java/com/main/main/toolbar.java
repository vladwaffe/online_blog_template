package com.main.main;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;

public class toolbar extends ToolBar {
    public button_class apply;
    public TextField X1, Y1, X2, Y2, R;
    Label label;
    public toolbar(Page page) {




        apply = new button_class("apply");

        Label x1 = new Label("X1");
        Label y1 = new Label("Y1");
        Label x2 = new Label("X2");
        Label y2 = new Label("Y2");
        Label a = new Label("-->");
        Label or = new Label("or R");
        X1 = new TextField();
        X1.setMaxWidth(40);
        Y1 = new TextField();
        Y1.setMaxWidth(40);
        X2 = new TextField();
        X2.setMaxWidth(40);
        Y2 = new TextField();
        Y2.setMaxWidth(40);
        label = new Label("");

        R = new TextField();
        R.setMaxWidth(40);


        this.getItems().add(apply);
        this.getItems().addAll(x1, X1, y1, Y1, a, x2, X2, y2, Y2, or, R);
    }


}
