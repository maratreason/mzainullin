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

		return Math.sqrt(
				Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
		);
	}

}