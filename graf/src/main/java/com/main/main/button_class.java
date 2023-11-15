package com.main.main;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class button_class extends Button {
    private String name;
    public button_class(String name){
        this.setText(name);
        this.name = name;
    }

    public void press_build(Page page) {
        page.leftMenu.build.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                page.curve.rasterize(page);
            }
        });
    }
    public void press_apply_hull(Page page) {
        page.leftMenu.getApply_hull().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                page.quickHullAlgorithm.quickHull(page);
                page.quickHullAlgorithm.rasterize(page);
            }
        });
    }
}
