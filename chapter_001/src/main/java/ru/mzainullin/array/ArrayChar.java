package ru.mzainullin.array;

/**
 * @author Marat Zainullin.
 * @version 1.0
 * @since 0.1
 */
public class ArrayChar {

    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Метод проверяет что слово начинается с префикса
     * @param prefix
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {

        boolean result = true;
        char[] value = prefix.toCharArray();
        // проверить. что массив data имеет первые элементы одинаковые с value

        for (int i = 0; i != value.length; i++) {
                if (value[i] == data[i]) {
                    result = true;
                } else {
                    result = false;
                }
            }
        return result;
    }

}
