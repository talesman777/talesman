package sc.lab2_4;

import java.util.HashSet;

import static sc.lab2_4.Tools.*;

public class Lab2_4 {
	public static void main(String[] args) {
		PointSetGenerator pointSetGenerator = new PointSetGenerator();
		HashSet<Point> points = pointSetGenerator.generatePoints(getPositiveInteger("Number of points : "));

		displayPoints(points);
		System.out.println();

		Point least = findPointWithLeastDistance(points);
		if (least != null) {
			System.out.println("\nPoint with least total distance to other points : " + least);
		}
	}
}
