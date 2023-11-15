package com.main.main;

import javafx.scene.effect.Light;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class BezierCurve{
    private ArrayList<Light.Point> points = new ArrayList<>();
    public BezierCurve() {}
    public void setPoints(Light.Point point) {
        points.add(point);
    }
    public ArrayList<Light.Point> getPoints(){
        return points;
    }


    public void rasterize(Page page) {
        if (points.size() < 2) {
            return;
        }
        page.canvas.gc.beginPath();
        page.canvas.gc.moveTo(points.get(0).getX(), points.get(0).getY());
        for (int i = 1; i < points.size() - 2; i += 2) {
            double x1 = points.get(i).getX();
            double y1 = points.get(i).getY();
            double x2 = points.get(i+1).getX();
            double y2 = points.get(i+1).getY();
            double x3 = points.get(i+2).getX();
            double y3 = points.get(i+2).getY();
            page.canvas.gc.bezierCurveTo(x1, y1, x2, y2, x3, y3);
        }
        page.canvas.gc.stroke();
        page.curve.getPoints().clear();
    }
}


