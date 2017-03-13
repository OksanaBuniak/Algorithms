package Week3;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class FastCollinearPoints {

    ArrayList<LineSegment> segm = new ArrayList<>();

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        int len = points.length;
        Arrays.sort(points, Point::compareTo);
        Point[] pointsQueue = points.clone();

        for (int i = 0; i < len; i++) {
            Point currentPoint = points[i];
            Arrays.sort(pointsQueue, currentPoint.slopeOrder());
            List<Double> slopes = Arrays.stream(pointsQueue).map(point -> currentPoint.slopeTo(point)).collect(Collectors.toList());

            for (int j = 0; j < len; j++) {
                if (pointsQueue[j] == points[i]) {
                    continue;
                }

                double angle = currentPoint.slopeTo(pointsQueue[j]);
                boolean shouldSkipAngle = pointsQueue[j].compareTo(currentPoint) != 1;

                int count = 2;
                while (j < len - 1 && angle == currentPoint.slopeTo(pointsQueue[j + 1])) {
                    j++;
                    count++;
                }

                if (!shouldSkipAngle && count >= 4) {
                    segm.add(new LineSegment(currentPoint, pointsQueue[j]));
                }
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return segm.size();
    }

    // the line segments
    public LineSegment[] segments() {
        LineSegment[] segments = new LineSegment[segm.size()];
        segments = segm.toArray(segments);
        return segments;
    }

}
