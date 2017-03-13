package Week3;

import edu.princeton.cs.algs4.In;

import javax.sound.sampled.Line;
import javax.swing.text.Segment;
import java.util.*;

public class BruteCollinearPoints {

    ArrayList<LineSegment> segm = new ArrayList<>();

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        int i, j, k, m;
        int len = points.length;
        Arrays.sort(points, Point::compareTo);

        for (i = 0; i < len - 3; i++) {
            for (j = i + 1; j < len - 2; j++) {
                double slope1 = points[i].slopeTo(points[j]);
                for (k = j + 1; k < len - 1; k++) {
                    double slope2 = points[j].slopeTo(points[k]);
                    if (slope1 != slope2) {
                        continue;
                    }

                    for (m = k +1; m < len; m++) {
                        double slope3 = points[k].slopeTo(points[m]);

                        if (slope2 == slope3) {
                            LineSegment ls = new LineSegment(points[i], points[m]);
                            segm.add(ls);
                        }

                    } // end loop m
                } // end loop k
            } // end loop j
        } // end look i
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






/*
        HashMap<Point, Integer> hmap = new HashMap<Point, Integer>();
        int temp = -1;
        Point comp = null;
        if (hmap.containsKey(start)) {
        temp = hmap.get(start);
        comp = segments[temp].p;
        } else if (hmap.containsKey(arr[3])) {
        temp = hmap.get(arr[3]);
        comp = segments[temp].q;
        }

        if (temp >= 0 && start.slopeOrder().compare(arr[3], comp) == 1) {
        LineSegment ls = new LineSegment(start, comp);
        segments[temp] = ls;
        hmap.put(arr[0], temp);
        hmap.put(arr[1], temp);
        hmap.put(arr[2], temp);
        hmap.put(arr[3], temp);
        } else {
        LineSegment ls = new LineSegment(start, arr[3]);
        segments[numberOfSegments] = ls;
        hmap.put(arr[0], numberOfSegments);
        hmap.put(arr[1], numberOfSegments);
        hmap.put(arr[2], numberOfSegments);
        hmap.put(arr[3], numberOfSegments);
        numberOfSegments++;
        }
*/