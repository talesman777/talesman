package sc.lab2_4;

import java.util.HashSet;

public class PointSetGenerator {
	private double scale;

	public PointSetGenerator() {
		this(1);
	}

	public PointSetGenerator(double scale) {
		this.scale = scale;
	}

	public HashSet<Point> generatePoints(int num) {
		HashSet<Point> generatedPoints = new HashSet<Point>();
		for (int i = 0; i < num; i++) {
			generatedPoints.add(generatePoint());
		}
		return generatedPoints;
	}

	public Point generatePoint() {
		return new Point((Math.random() - 0.5) * scale, (Math.random() - 0.5) * scale);
	}
}
