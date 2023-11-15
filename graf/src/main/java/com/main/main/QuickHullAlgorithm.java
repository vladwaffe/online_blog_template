package com.main.main;

import javafx.scene.effect.Light;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class QuickHullAlgorithm {
    private List<Light.Point> points;
    public QuickHullAlgorithm(){
        points = new ArrayList<>();
    }

    public List<Light.Point> getPoints() {
        return points;
    }

    public void setPoints(List<Light.Point> points) {
        this.points = points;
    }

    public List<Light.Point> quickHull(Page page) {
        List<Light.Point> convexHull = new ArrayList<>();

        if (points.size() < 3) {
            return points;
        }

        int minPointIndex = -1;
        int maxPointIndex = -1;
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;

        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).getX() < minX) {
                minX = (int) points.get(i).getX();
                minPointIndex = i;
            }
            if (points.get(i).getX() > maxX) {
                maxX = (int) points.get(i).getX();
                maxPointIndex = i;
            }
        }

        Light.Point A = points.get(minPointIndex);
        Light.Point B = points.get(maxPointIndex);

        convexHull.add(A);
        convexHull.add(B);

        points.remove(A);
        points.remove(B);

        List<Light.Point> leftSet = new ArrayList<>();
        List<Light.Point> rightSet = new ArrayList<>();

        for (int i = 0; i < points.size(); i++) {
            Light.Point p = points.get(i);
            if (pointLocation(A, B, p) == -1) {
                leftSet.add(p);
            } else if (pointLocation(A, B, p) == 1) {
                rightSet.add(p);
            }
        }

        hullSet(A, B, rightSet, convexHull);
        hullSet(B, A, leftSet, convexHull);

        return convexHull;
    }

    public static int distance(Light.Point A, Light.Point B, Light.Point C) {
        int ABx = (int) (B.getX() - A.getX());
        int ABy = (int) (B.getY() - A.getY());
        int num = (int) (ABx * (A.getY() - C.getY()) - ABy * (A.getX() - C.getX()));

        if (num < 0) {
            num = -num;
        }

        return num;
    }

    public static void hullSet(Light.Point A, Light.Point B, List<Light.Point> set, List<Light.Point> hull) {
        int insertIndex = hull.indexOf(B);
        if (set.isEmpty()) {
            return;
        }
        if (set.size() == 1) {
            Light.Point p = set.get(0);
            set.remove(p);
            hull.add(insertIndex, p);
            return;
        }

        int dist = Integer.MIN_VALUE;
        int furthestPointIndex = -1;
        for (int i = 0; i < set.size(); i++) {
            Light.Point p = set.get(i);
            int distance = distance(A, B, p);
            if (distance > dist) {
                dist = distance;
                furthestPointIndex = i;
            }
        }

        Light.Point P = set.get(furthestPointIndex);
        set.remove(furthestPointIndex);
        hull.add(insertIndex, P);

        // Points to the left of AP
        List<Light.Point> leftSetAP = new ArrayList<>();
        for (int i = 0; i < set.size(); i++) {
            Light.Point M = set.get(i);
            if (pointLocation(A, P, M) == 1) {
                leftSetAP.add(M);
            }
        }

        // Points to the left of PB
        List<Light.Point> leftSetPB = new ArrayList<>();
        for (int i = 0; i < set.size(); i++) {
            Light.Point M = set.get(i);
            if (pointLocation(P, B, M) == 1) {
                leftSetPB.add(M);
            }
        }

        hullSet(A, P, leftSetAP, hull);
        hullSet(P, B, leftSetPB, hull);
    }

    public static int pointLocation(Light.Point A, Light.Point B, Light.Point P) {
        int cp1 = (int) ((B.getX() - A.getX()) * (P.getY() - A.getY()) - (B.getY() - A.getY()) * (P.getX() - A.getX()));
        if (cp1 > 0) {
            return 1;
        } else if (cp1 == 0) {
            return 0;
        } else {
            return -1;
        }
    }
    public void rasterize(Page page){
        for(int i = 0; i < points.size()-1; i++){
            page.canvas.gc.setStroke(Color.RED);
            page.canvas.gc.strokeLine(points.get(i).getX(), points.get(i).getY(), points.get(i+1).getX(), points.get(i+1).getY());
        }
    }

}
