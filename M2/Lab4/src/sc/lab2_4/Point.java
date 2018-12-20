package sc.lab2_4;

public class Point {
	private double x;
	private double y;

	public Point() {
		this(0, 0);
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Point point = (Point) obj;
		if (x != point.x) {
			return false;
		}
		return y == point.y;
	}

	@Override
	public int hashCode() {
		int result = 0xC5AF;

		long x = Double.doubleToLongBits(this.x);
		long y = Double.doubleToLongBits(this.y);

		result = 31 * result + (int) (x ^ (x >>> 32));
		result = 31 * result + (int) (y ^ (y >>> 32));

		return result;
	}

	@Override
	public String toString() {
		return String.format("(%9f, %9f)", x, y);
	}
}
