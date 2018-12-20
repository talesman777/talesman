package sc.lab2_4;

import java.util.HashSet;
import java.util.Scanner;

public class Tools {
	public static int getPositiveInteger(String promptMessage) {
		int number = -1;

		try (Scanner scanner = new Scanner(System.in)) {
			while (number < 0) {
				System.out.print(promptMessage);
				try {
					number = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage() + " - bad input, try again.");
					continue;
				}

				if (number < 0) {
					System.out.println(number + " - number should be greater than 0, try again.");
				}
			}
		}

		return number;
	}

	public static void displayPoints(HashSet<Point> points) {
		if (points == null || points.isEmpty()) {
			System.out.println("No elements to display");
			return;
		}

		System.out.println("Elements (x, y) :");
		for (Point point : points) {
			System.out.println(point);
		}
	}

	public static Point findPointWithLeastDistance(HashSet<Point> points) {
		Point result = null;
		double sum = Double.MAX_VALUE;

		for (Point point : points) {
			double tempSum = calculateSumDistance(point, points);

			System.out.printf("Point %s, total distance to others : %f\n", point, tempSum);
			if (tempSum < sum) {
				result = point;
				sum = tempSum;
			}
		}
		return result;
	}

	public static double calculateSumDistance(Point p, HashSet<Point> points) {
		double sum = 0;
		for (Point point : points) {
			if (point != p) {
				sum += calculateDistance(p, point);
			}
		}
		return sum;
	}

	public static double calculateDistance(Point a, Point b) {
		return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
	}
}
