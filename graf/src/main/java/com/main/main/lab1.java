package com.main.main;

import javafx.scene.paint.Color;

import static java.lang.Math.*;

public class lab1 {
    public lab1(Page page){
        functions(page);
    }

    public void functions(Page page){
        int x0 = 295;
        int y0 = 225;
        int i_min = 0;
        int i_max = 359;
        for(int i =  i_min ; i < i_max; i++){
            page.canvas.gc.setStroke(Color.WHITE);
            page.canvas.gc.setFill(Color.WHITE);
            double r1 = (2 - abs(cos(4 * i)))/4;
            double r2 = (2 - sin(2 * cos(4 * i)) * sin(2 * cos(4 * i)))/2;
            double x1 = x0 + r1 * cos(toRadians(i)) * 300;
            double x2 = x0 + r2 * cos(toRadians(i)) * 300;
            double y1 = y0 + r1 * sin(toRadians(i)) * 300;
            double y2 = y0 + r2 * sin(toRadians(i)) * 300;
            page.canvas.gc.strokeLine(x1, y1, x1, y1);
            page.canvas.gc.strokeLine(x2, y2, x2, y2);
        }
    }
    public void section (Page page){
        double f = Double.parseDouble(page.tool.X2.getText());
        int[] coords = new int[4];
        int x0 = 295;
        int y0 = 225;
        double r1 = (2 - abs(cos(4 * f)))/4;
        double r2 = (2 - sin(2 * cos(4 * f)) * sin(2 * cos(4 * f)))/2;
        coords[0] = (int) (x0 + r1 * cos(toRadians(f)) * 300);
        coords[1] = (int) (y0 + r1 * sin(toRadians(f)) * 300);
        coords[2] = (int) (x0 + r2 * cos(toRadians(f)) * 300);
        coords[3] = (int) (y0 + r2 * sin(toRadians(f)) * 300);
        page.line.paint(page, coords, (int) f);
        paint_circles(page, coords);


    }
    public void paint_circles(Page page, int[] coords){
        int x0 = 295;
        int y0 = 225;
        //page.canvas.gc.setFill(Color.AQUA);
        page.canvas.gc.setStroke(Color.AQUA);
        double r1 = hypot(coords[0] - x0, coords[1] - y0);
        System.out.println(r1);
        double r2 = hypot(coords[2] - x0, coords[3] - y0);
        System.out.println(r2);
        System.out.println(coords[0]);
        System.out.println(coords[1]);
        System.out.println(coords[2]);
        System.out.println(coords[3]);
        page.canvas.gc.strokeOval(x0 - r1, y0 - r1, r1*2, r1*2);
        page.canvas.gc.strokeOval(x0 - r2, y0 - r2, r2*2, r2*2);
    }

}
