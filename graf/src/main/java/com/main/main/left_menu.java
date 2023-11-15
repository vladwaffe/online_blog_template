package com.main.main;

import javafx.scene.layout.VBox;

public class left_menu extends VBox {
    private primitive_check check;
    public button_class build = new button_class("build");
    private button_class apply_hull = new button_class("Hull");

    public left_menu(){
        check = new primitive_check();
        this.getChildren().add(check);
        this.getChildren().add(build);
        this.getChildren().add(apply_hull);
        this.setMinWidth(100);
        this.setSpacing(10);
        build.setMinWidth(90);
    }

    public button_class getApply_hull() {
        return apply_hull;
    }

    public void setApply_hull(button_class apply_hull) {
        this.apply_hull = apply_hull;
    }

    public primitive_check getCheck() {
        return check;
    }
}
