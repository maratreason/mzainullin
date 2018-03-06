package ru.mzainullin.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class TriangleTest {

	@Test
	public void whenAreaSetThreePointsThenTriangleArea() {

		// Создаем три объекта класса Point.
		Point a = new Point(0, 0);
		Point b = new Point(0, 7);
		Point c = new Point(7, 0);

	 	// Создаем объект треугольник и передаем в него объекты точек.
		Triangle triangle = new Triangle(a, b, c);

	 	// Вычисляем площадь.
		double result = triangle.area();

	 	// Задаем ожидаемый результат.
		double expected = 24.5D;

	 	//Проверяем результат и ожидаемое значение.
		assertThat(result, closeTo(expected, 0.1));
	}
}