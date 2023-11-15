package com.main.main;

import javafx.scene.paint.Color;

import static java.lang.Math.*;

public class circle {
    public circle(){}
    public void paint(Page page){
        page.canvas.gc.setFill(Color.WHITE);
        page.canvas.gc.setStroke(Color.WHITE);
        int x = (int) Double.parseDouble(page.tool.X1.getText());
        int y = (int) Double.parseDouble(page.tool.Y1.getText());
        int R = (int) Double.parseDouble(page.tool.R.getText());
        int i, j, d;
        i = x;
        j = y + R;
        d = 3 - (2 * R);
        do{
            page.canvas.gc.strokeLine(x + i, y + j, x + i, y + j);
            page.canvas.gc.strokeLine(x + j, y + i, x + j, y + i);
            page.canvas.gc.strokeLine(x + i, y - j, x + i, y - j);
            page.canvas.gc.strokeLine(x + j, y - i, x + j, y - i);
            page.canvas.gc.strokeLine(x - i, y - j, x - i, y - j);
            page.canvas.gc.strokeLine(x - j, y - i, x - j, y - i);
            page.canvas.gc.strokeLine(x - i, y + j, x - i, y + j);
            page.canvas.gc.strokeLine(x - j, y + i, x - j, y + i);
            if( d < 0 ){
                d += 4 * i + 6;
            }
            else{
                d += 4 * (i - j) + 10; --j;
            }
            ++i;
        }while(i < x + R/sqrt(2));

    }
    public void paint(Page page, int[] coords){
        page.canvas.gc.setFill(Color.WHITE);
        page.canvas.gc.setStroke(Color.WHITE);
        int x = coords[0];
        int y = coords[1];
        int R =(int) (hypot(coords[3]-2, coords[2]-y));
        int i = x;
        int j = y + R;
        int d = 3 - 2 * R;
        do{
            page.canvas.gc.strokeLine(x + i, y + j, x + i, y + j);
            page.canvas.gc.strokeLine(x + j, y + i, x + j, y + i);
            page.canvas.gc.strokeLine(x + i, y - j, x + i, y - j);
            page.canvas.gc.strokeLine(x + j, y - i, x + j, y - i);
            page.canvas.gc.strokeLine(x - i, y - j, x - i, y - j);
            page.canvas.gc.strokeLine(x - j, y - i, x - j, y - i);
            page.canvas.gc.strokeLine(x - i, y + j, x - i, y + j);
            page.canvas.gc.strokeLine(x - j, y + i, x - j, y + i);
            if( d < 0 ){
                d += 4 * i + 6;
            }
            else{
                d += 4 * (i - j) + 10; --j;
            }
            ++i;
        }while(i < x + R/sqrt(2));

    }
}
