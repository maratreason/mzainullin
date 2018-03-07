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
     * Проверяет что слово начинается с префикса
     * @param prefix
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        // проверить. что массив data имеет первые элементы одинаковые с value


        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < value.length; j++) {
                if (i % 2 == 0) {
                    if (data[0] == value[0] && data[1] == value[1]) {
                        result = true;
                    } else {
                        result = false;

                    }
                    break;
                }
            }
        }

        return result;
    }

}
