package ru.mzainullin.points.promprog.ch03;

/**
 * @author Marat Zainullin (maratreason@mail.ru)
 * @version 1.1
 * @since 0.1
 * 1.04.2018
 */
public class DepartmentLogic {
    public static void main(String[] args) {
        Department dept = new Department(75);
        System.out.println("Значение id=" + dept.getId());
    }
}

/**
 * В первой строке вывода поле id получит значение по умолчанию, так как па-
 мять для него выделена при создании объекта, а значение еще не проинициализи-
 ровано. Во второй строке выводится значение id, равное 10, так как после ини-
 циализации атрибута класса был вызван логический блок, изменивший его значе-
 ние.
 */
