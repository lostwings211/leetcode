import java.util.*;
public class Solution {
    public class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) {
            return 0;
        }
        int max = 1;
        for(int i = 0; i < points.length; i++) {
            int localmax = 1;
            int maxSlope = 1;
            int same = 0;
            HashMap<Float, Integer> slopes = new HashMap<Float, Integer>();
            for(int j = 0; j < points.length; j++) {
                if(i == j) {
                    continue;
                }
                else if(points[i].x == points[j].x && points[i].y == points[j].y) {
                    same++;
                }
                else if(points[i].x == points[j].x) {
                    maxSlope++;
                }
                else {
                    float slope = (float)(points[j].y - points[i].y) / (float)(points[j].x - points[i].x);
                    if(slopes.containsKey(slope)) {
                        int count = slopes.get(slope);
                        slopes.put(slope,  count + 1);
                        if(count + 1 > localmax) {
                            localmax = count + 1;
                        }
                    }
                    else {
                        slopes.put(slope, 2);
                        if(2 > localmax) {
                            localmax = 2;
                        }
                    }
                }
            }
            localmax = Math.max(localmax, maxSlope) + same;
            if(localmax > max) {
                max = localmax;
            }
        }
        return max;
    }
}
