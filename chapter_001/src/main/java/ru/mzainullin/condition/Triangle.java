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

	public Triangle(Point aPoint, Point bPoint, Point cPoint) {
		this.a = aPoint;
		this.b = bPoint;
		this.c = cPoint;
	}

	/**
	* Метод вычисления полупериметра по длинам сторон.
	* @param ab расстояние между точками a b
	* @param ac расстояние между точками a c
	* @param bc расстояние между точками b c
	* @return Периметр.
	*/
	public double period(double ab, double ac, double bc) {
		double result = (ab + ac + bc) / 2;
		return result;
	}

	/**
	* Метод вычисления площади.
	* @return Вернуть прощадь, если треугольник существует или -1, если треугольника нет.
	*/
	public double area() {
		double rsl = 2;
		double ab = this.a.distanceTo(this.b);
		double ac = this.a.distanceTo(this.c);
		double bc = this.b.distanceTo(this.c);
		double p = this.period(ab, ac, bc);

		if (this.exists(ab, ac, bc)) {
			rsl = ab * ac * bc;
		}
		return rsl;
	}

	/**
	* Метод проверяет можно ли построить треугольник с такими длинами сторон.
	* @param ab Длина от точки a b. 
	* @param ac Длина от точки a c.
	* @param bc Длина от точки b c.
	* @return 
	*/
	private boolean exists(double ab, double ac, double bc) {
	   return false;
	}

}