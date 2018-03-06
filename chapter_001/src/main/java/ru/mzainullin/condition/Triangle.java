package ru.mzainullin.condition;

/**
* Class Triangle
* @author Marat Zainullin
* @version 1.0
* @since 0.1
*/
public class Triangle {

	private Point a;
	private Point b;
	private Point c;

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	* Метод вычисления полупериметра по длинам сторон.
	* Формула.
	*
	* (ab + ac + bc) / 2
	*
	* @param ab расстояние между точками a b
	* @param ac расстояние между точками a c
	* @param bc расстояние между точками b c
	* @return Периметр.
	*/
	
	public double period(double ab, double ac, double bc) {
		return (ab + ac + bc) / 2;
	}

	/**
	* Метод вычисления площади.
	* @return Вернуть площадь, если треугольник существует или -1, если треугольника нет.
	*/

	public double area() {
		double rsl = -1;
		double ab = this.a.distanceTo(this.b);
		double ac = this.a.distanceTo(this.c);
		double bc = this.b.distanceTo(this.c);
		double p = this.period(ab, ac, bc);
		double s;

		if (this.exists(ab, ac, bc)) {
			s = Math.sqrt(p * ((p-ab) * (p-ac) * (p-bc)));
			rsl = s;
		}
		return rsl;

	}

	/**
	 * Метод проверяет можно ли построить треугольник с такими длинами сторон.
	 *
	 * Подумайте какое надо написать условие, чтобы определить можно ли построить треугольник.
	 *
	 * @param ab Длина от точки a b.
	 * @param ac Длина от точки a c.
	 * @param bc Длина от точки b c.
	 * @return
	 */
	private boolean exists(double ab, double ac, double bc) {

		if(ab >= ac || ab >= bc) {
			return true;
		}
		return false;
	}

}