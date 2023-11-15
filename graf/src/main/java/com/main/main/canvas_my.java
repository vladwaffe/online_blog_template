package com.main.main;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class canvas_my extends Canvas {
    Light.Point point = new Light.Point();
    private int X, Y;
    private int counter = 0;
    public GraphicsContext gc;
    private int[] coords = new int[] {-1, -1, -1, -1};

    public canvas_my() {
        this.setHeight(450);
        this.setWidth(590);
        gc = this.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.AQUAMARINE);
        gc.strokeLine(0, 0, 590, 0);
        gc.strokeLine(0, 0, 0, 450);
        gc.strokeLine(589, 0, 589, 450);
        gc.strokeLine(0, 449, 590, 449);
        gc.strokeLine(294, 0, 294, 450);
        gc.strokeLine(0, 224, 590, 224);



    }
    public void pressed(Page page, Line_my line) {
            this.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    String value = (String) page.leftMenu.getCheck().getValue();
                    //page.tool.label.setText("(x: " + (int) mouseEvent.getX() + ", y: " + (int) mouseEvent.getY() + ")");
                    switch (value) {
                        case "line": {
                            if (counter == 0 || counter == 2) {
                                counter = 1;
                                coords[0] = (int) mouseEvent.getX();
                                coords[1] = (int) mouseEvent.getY();
                            } else {
                                counter = 2;
                                coords[2] = (int) mouseEvent.getX();
                                coords[3] = (int) mouseEvent.getY();
                                page.line.paint(page, coords);
                            }
                            break;
                        }
                        case "circle": {
                            if (counter == 0 || counter == 2) {
                                counter = 1;
                                coords[0] = (int) mouseEvent.getX();
                                coords[1] = (int) mouseEvent.getY();
                            } else {
                                counter = 2;
                                coords[2] = (int) mouseEvent.getX();
                                coords[3] = (int) mouseEvent.getY();
                                page.circle.paint(page, coords);
                            }
                            break;
                        }
                        case "spline": {
                            page.tool.apply.press_build(page);
                            //if(counter <= 3) {
                                point = new Light.Point();
                                point.setX((int) mouseEvent.getX());
                                point.setY((int) mouseEvent.getY());
                                page.curve.getPoints().add(point);
                                counter++;
                            //}
                            //else {
                                //page.curve.rasterize(page);
                                //counter = 0;
                                //page.curve.getPoints().clear();
                            //}
                        }
                        case "Hull": {

                            point = new Light.Point();
                            point.setX((int) mouseEvent.getX());
                            point.setY((int) mouseEvent.getY());
                            page.quickHullAlgorithm.getPoints().add(point);
                            page.canvas.gc.strokeLine(point.getX(), point.getY(), point.getX(), point.getY());
                        }

                    }
                }
            });
    }
    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }
}



