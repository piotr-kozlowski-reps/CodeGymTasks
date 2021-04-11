package com.codegym.task.task40.task4004;

import java.util.ArrayList;
import java.util.List;

/* 
Points in a polygon

*/

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(0, 10));
        polygon.add(new Point(10, 10));
        polygon.add(new Point(10, 0));

        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
        System.out.println(isPointInPolygon(new Point(100, 100), polygon));
    }

        public static boolean isPointInPolygon(Point point, List<Point> polygon) {

            boolean isPointInside = false;

            int x = point.x;
            int y = point.y;

            for (int i = 0, j = polygon.size() - 1; i < polygon.size(); j = i++) {
                int xi = polygon.get(i).x;
                int yi = polygon.get(i).y;
                int xj = polygon.get(j).x;
                int yj = polygon.get(j).y;

                boolean intersect = ((yi > y) != (yj > y))
                        && (x < (xj - xi) * (y - yi) / (yj - yi) + xi);

                if (intersect) isPointInside = !isPointInside;
            }




        return isPointInside;

    }




//    public static boolean isPointInPolygon(Point point, List<Point> polygon) {
//
//        boolean isPoint = false;
//
//        if (isXOnPolygon(point, polygon) && isYOnPolygon(point, polygon)) {
//            isPoint = true;
//        }
//
//        return isPoint;
//
//    }
//    private static boolean isXOnPolygon(Point point, List<Point> polygon) {
//
//        if (point.x >= polygon.get(0).x && point.x <= polygon.get(2).x) return true;
//        else return false;
//
//    }
//    private static boolean isYOnPolygon(Point point, List<Point> polygon) {
//
//        if (point.y >= polygon.get(0).y && point.y <= polygon.get(1).y) return true;
//        else return false;
//
//    }

}

