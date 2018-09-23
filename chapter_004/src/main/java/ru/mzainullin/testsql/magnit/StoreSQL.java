package ru.mzainullin.testsql.magnit;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.sql.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 01.09.2018
 */
public class StoreSQL {

    Connection conn;
    private Config config;

    List<Entry> fields = new LinkedList<>();

    public void configSQL() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:d:/program files/SQLlite/databases/entry.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Метод генерации чисел
     * @param n - сгенерированное число
     * @return - число
     */
    public int generate(int n) {
        clearData();
        int result = 1;
        while (result <= n) {
            System.out.println("Вставляются данные: " + result);
            try {
                String query = "INSERT INTO entry (field) VALUES (" + result + ");";
                Statement st = conn.createStatement();

                st.executeUpdate(query);
                this.fields.add(new Entry(result));
                st.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }

            result++;
        }
        return result;
    }


    /**
     * Метод создания таблицы entry
     * Если таблица не существует,
     * то создается.
     */
    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS entry (field INTEGER)";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            st.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Таблица успешно создана");
    }


    /**
     * Метод отображения всех данных из таблицы entry
     */
    public void showTable() {
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM entry");
            System.out.println("+--- Show all fields ---+");
            while (res.next()) {
                System.out.println(String.format("field: %d",res.getInt("field")));
            }
            res.close();
            st.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return;
    }


    /**
     * Метод получения данных из таблицы entry
     */
    public List<Entry> getFields(List<Entry> newList) {
        int fieldValue;
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM entry");
            while (res.next()) {
                fieldValue = res.getInt("field");
                newList.add(new Entry());
                for (int i = 0; i < newList.size(); i++) {
                    newList.get(i).setField(fieldValue);
                    this.fields.add(newList.get(i));
                    System.out.println(newList.get(i).getField());
                    break;
                }

            }
            res.close();
            st.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return newList;
    }


    public List<Entry> getLists() {
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM entry");
            this.fields.clear();
            while (res.next()) {
                Entry entry = new Entry();
                entry.setField(res.getInt("field"));
                this.fields.add(entry);
            }
            res.close();
            st.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        System.out.println("The list's size is " + this.fields.size());
        return this.fields;
    }


    /**
     * Метод удаления таблицы
     */
    public void clearData() {
        try {
            String query = "DELETE FROM entry;";
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            st.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


    public void fileConvertXSQT() throws Exception {
        File inputXML = new File("D:\\Projects\\mzainullin\\chapter_004\\src\\main\\java\\ru\\mzainullin\\testsql\\magnit\\file.xml");
        File dest = new File("D:\\Projects\\mzainullin\\chapter_004\\src\\main\\java\\ru\\mzainullin\\testsql\\magnit\\file1.xml");
        File schema = new File("D:\\Projects\\mzainullin\\chapter_004\\src\\main\\java\\ru\\mzainullin\\testsql\\magnit\\file.xsl");
        new ConvertXSQT().convert(inputXML, dest, schema);
    }


    public void getInput() throws Exception {
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
                        showTable();
                        getInput();
                        break;
                    case 2:
                        System.out.println("Введите количество сгенерированных чисел:\n");
                        Scanner count = new Scanner(System.in);
                        int y = count.nextInt();
                        generate(y);
                        getInput();
                        break;
                    case 3:
                        getFields(fields);
                        getInput();
                        break;
                    case 4:
                        new XmlUsage().StaxWriteExample();
                        getInput();
                        break;
                    case 5:
                        fileConvertXSQT();
                        getInput();
                        break;
                    default:
                        System.out.println("Вы ввели неверный номер");
                        getInput();
                        break;
                }
            }
        }
    }


}