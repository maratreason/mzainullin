package ru.mzainullin.points.promprog.ch03;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.1
 * @since 0.1
 * 1.04.2018
 */
public class Mark {
    private int mark = 3;
    public static int coeff = 5;

    public double gerResult() {
        return (double) coeff * mark / 100;
    }

    public static void setCoeffFloat(float c) {
        // coeff = (int) coeff * c;
        // будет ошибка
        // из статического метода нельзя обратиться к нестатическим полям и методам
    }

    public void setMart(int mark) {
        this.mark = mark;
    }

    public static void main(String[] args) {
        Mark ob1 = new Mark();
        Mark ob2 = new Mark();

        Mark.coeff = 7;
        Mark.setCoeffFloat(7);
    }
}

/**
 Статический метод можно вызывать также с использованием имени объекта,
 но такой вызов снижает качество кода и не будет логически корректным, хотя и
 не приведет к ошибке компиляции.
 Переопределение статических методов класса не имеет практического смыс-
 ла, так как обращение к статическому атрибуту или методу осуществляется по
 большей части посредством задания имени класса, которому они принадлежат.
 */