package interview.topkelements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {

    // [[1, 3], [3, 4], [2, -1]], K = 2
    //
    // [5, sqrt(10)] -> [sqrt(10), sqrt(5)]
    //
    public static List<Point> findClosestPoints(Point[] points, int k) {
        Queue<Point> queue =
                new PriorityQueue<>((p1, p2) ->
                        (int) Math.sqrt(p2.distFromOrigin()) - (int) Math.sqrt(p1.distFromOrigin()));
        for (int i = 0; i < k; i++) {
            queue.add(points[i]);
        }
        for (int i = k; i < points.length; i++) {
            if (points[i].distFromOrigin() < queue.peek().distFromOrigin()) {
                queue.remove();
                queue.add(points[i]);
            }
        }
        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
        List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result)
            System.out.print("[" + p.x + " , " + p.y + "] ");
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distFromOrigin() {
            return (x * x) + (y * y);
        }
    }
}
