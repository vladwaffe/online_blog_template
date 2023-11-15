package com.main.main;

import javafx.scene.paint.Color;

public class Line_my {
    public Line_my(){}

    public void paint(Page page, int[] coords){
        int e, deltaS, deltaD, x, y, a, b;
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        if(coords[0] > coords[2] && coords[1] > coords[3]){
            x2 = coords[0];
            y2 = coords[1];
            x1 = coords[2];
            y1 = coords[3];
        }
        else{
            x1 = coords[0];
            y1 = coords[1];
            x2 = coords[2];
            y2 = coords[3];
        }

        page.canvas.gc.setFill(Color.WHITE);
        page.canvas.gc.setStroke(Color.WHITE);
        a = x2 - x1;
        b = y2 - y1;
        if ( a > b ){
            e = b/a;
            deltaS = 2*b; // if a < b change a and b
            deltaD = 2*b-2*a; // a = x2 - x1 b = y2 - y1
            x = x1;
            y = y1;
            while( x < x2 ){ //x2  // if a > b to x < x2 if b > a to y < y2
                page.canvas.gc.strokeLine(x, y, x, y);
                if( e > 0 ){
                    x++;
                    y++;
                    e += deltaD;
                }
                else{
                    x++; //y ++
                    e += deltaS;
                }
            }
        }
        else {
                e = a/b;
                deltaS = 2*a; // if a < b change a and b
                deltaD = 2*a-2*b; // a = x2 - x1 b = y2 - y1
                x = x1;
                y = y1;
            while( y < y2 ){ //x2  // if a > b to x < x2 if b > a to y < y2
                page.canvas.gc.strokeLine(x, y, x, y);
                if( e > 0 ){
                    x++;
                    y++;
                    e += deltaD;
                }
                else{
                    y++; //y ++
                    e += deltaS;
                }
            }
        }


    }
    public void paint(Page page, int[] coords, int shade){
        int e, deltaS, deltaD, x, y, a, b;
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        if(coords[0] > coords[2] && coords[1] > coords[3]){
            x2 = coords[0];
            y2 = coords[1];
            x1 = coords[2];
            y1 = coords[3];
        }
        else{
            x1 = coords[0];
            y1 = coords[1];
            x2 = coords[2];
            y2 = coords[3];
        }

        page.canvas.gc.setStroke(Color.hsb(shade, 1, 1));
        page.canvas.gc.setStroke(Color.hsb(shade, 1, 1));
        a = x2 - x1;
        b = y2 - y1;
        if ( a > b ){
            e = b/a;
            deltaS = 2*b; // if a < b change a and b
            deltaD = 2*b-2*a; // a = x2 - x1 b = y2 - y1
            x = x1;
            y = y1;
            while( x < x2 ){ //x2  // if a > b to x < x2 if b > a to y < y2
                page.canvas.gc.strokeLine(x, y, x, y);
                if( e > 0 ){
                    x++;
                    y++;
                    e += deltaD;
                }
                else{
                    x++; //y ++
                    e += deltaS;
                }
            }
        }
        else {
            e = a/b;
            deltaS = 2*a; // if a < b change a and b
            deltaD = 2*a-2*b; // a = x2 - x1 b = y2 - y1
            x = x1;
            y = y1;
            while( y < y2 ){ //x2  // if a > b to x < x2 if b > a to y < y2
                page.canvas.gc.strokeLine(x, y, x, y);
                if( e > 0 ){
                    x++;
                    y++;
                    e += deltaD;
                }
                else{
                    y++; //y ++
                    e += deltaS;
                }
            }
        }


    }
}
