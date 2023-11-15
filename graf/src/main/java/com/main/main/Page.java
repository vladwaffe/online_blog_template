package com.main.main;

import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.List;

public class Page extends BorderPane {
    public com.main.main.canvas_my canvas;
    public left_menu leftMenu;
    public QuickHullAlgorithm quickHullAlgorithm;
    public toolbar tool;
    public com.main.main.Line_my line;
    public circle circle;
    public BezierCurve curve;
    public lab1 lab1;
    public Page(){
        tool = new toolbar(this);
        leftMenu = new left_menu();
        canvas = new canvas_my();
        circle = new circle();
        line = new Line_my();
        curve = new BezierCurve();
        this.setLeft(leftMenu);
        this.setBottom(tool);
        this.setMinHeight(600);
        this.setMinWidth(900);
        this.setCenter(canvas);
        quickHullAlgorithm = new QuickHullAlgorithm();
        this.leftMenu.getApply_hull().press_apply_hull(this);





//        points.add(new QuickHullAlgorithm.Point(1, 1));
//        points.add(new QuickHullAlgorithm.Point(2, 3));
//        points.add(new QuickHullAlgorithm.Point(3, 2));
//        points.add(new QuickHullAlgorithm.Point(4, 4));
//        points.add(new QuickHullAlgorithm.Point(5, 1));
//        points.add(new QuickHullAlgorithm.Point(6, 3));
//        points.add(new QuickHullAlgorithm.Point(7, 2));
//        points.add(new QuickHullAlgorithm.Point(8, 4));
        //List<QuickHullAlgorithm.Point> convexHull = quickHull(points);
    }
}
