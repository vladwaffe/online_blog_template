package com.main.main;

import javafx.collections.ListChangeListener;
import javafx.scene.control.ChoiceBox;

public class primitive_check extends ChoiceBox {
    public primitive_check(){
        this.setMinWidth(90);
        this.getItems().add("line");
        this.getItems().add("circle");
        this.getItems().add("elipse");
        this.getItems().add("spline");
        this.getItems().add("Hull");




    }
}
