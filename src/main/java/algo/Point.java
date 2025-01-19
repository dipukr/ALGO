package algo;

public class Point {
	
	public int x;
	public int y;
	
	public static Point of(int x, int y) {
		Point point = new Point();
		point.x = x;
		point.y = y;
		return point;
	}
	
	public String toString() {
		return String.format("(%d,%d)", x, y);
	}
}
