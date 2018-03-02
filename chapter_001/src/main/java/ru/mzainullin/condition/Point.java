package ru.mzainullin.condition;

/**
* Class Point.
* @author Marat Zainullin (maratreason@mail.ru)
* @version 1
* @since 0.1
*/
public class Point {

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	* Метод который измеряет расстояние
	* @param that точка.
    * @return квадратный корень
	*/
	public double distanceTo(Point that) {
//		Point a = this;
//		Point b = that;

//		int x1 = a.x;
//		int y1 = a.y;
//		int x2 = b.x;
//		int y2 = b.y;
//
//		double result = Math.sqrt(
//				Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)
//		);
//
//		return result;

		return Math.sqrt(
				Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
		);
	}

	public static void main(String[] args) {
		Point startPoint = new Point(0, 1);
		Point endPoint = new Point(2, 18);

		double result =  startPoint.distanceTo(endPoint);
		System.out.println("Растояние между точками startPoint и endPoint: " + result);
	}

}