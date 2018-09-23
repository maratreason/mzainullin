package ru.mzainullin.testsql.magnit.model;

import ru.mzainullin.testsql.magnit.config.SQLConnect;
import ru.mzainullin.testsql.magnit.services.sql.*;
import ru.mzainullin.testsql.magnit.services.xml.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Marat Zainullin
 * @version 1.1
 * @since 23.09.2018
 */
public class Menu {
    private List<Entry> fields = new LinkedList<>();
    public void showMenu() throws Exception {

        SQLService service = new SQLService();

        System.out.println("Выберите пункт меню от 1 до 5...\n");
        System.out.println("1. Показать все данные из таблицы.");
        System.out.println("2. Сгенерировать данные в таблицу.");
        System.out.println("3. Получить данные из таблицы.");
        System.out.println("4. Вывести данные полей в XML.");
        System.out.println("5. Преобразовать XML в новый файл через XSLT.");
        Scanner scn = new Scanner(System.in);
        int x = 1;
        while (x <= 4) {
            while (scn.hasNext()) {
                x = Integer.parseInt(scn.nextLine());
                switch (x) {
                    case 1:
                        service.showTable();
                        showMenu();
                        break;
                    case 2:
                        System.out.println("Введите количество сгенерированных чисел:\n");
                        Scanner count = new Scanner(System.in);
                        int y = count.nextInt();
                        service.generate(y);
                        showMenu();
                        break;
                    case 3:
                        service.getFields(fields);
                        showMenu();
                        break;
                    case 4:
                        new XMLService().StaxWriteExample();
                        showMenu();
                        break;
                    case 5:
                        new XMLService().fileConvertXSQT();
                        showMenu();
                        break;
                    default:
                        System.out.println("Вы ввели неверный номер");
                        showMenu();
                        break;
                }
            }
        }
    }
}
