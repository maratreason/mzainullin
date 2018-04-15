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
     * @param prefix = входной параметр
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {

        boolean result = true;
        char[] value = prefix.toCharArray();
        // проверить. что массив data имеет первые элементы одинаковые с value

        for (int i = 0; i != value.length; i++) {
            if (value[i] == data[i]) {
                result = true;
                break;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * Метод проверяющий что словo String находится в другом слове String.
     * @param origin
     * @param sub
     * @return
     */
    /*boolean contains(String origin, String sub) {
        char[] value = origin.toCharArray();
        char[] expectValue = sub.toCharArray();

        int count = 0;

        boolean result = true;

        for (int i = 0; i != value.length; i++) {
            for (int j = 0; j != expectValue.length; j++) {
                char[] temp;
                if (value[i] == expectValue[j]) {
                    temp = expectValue;
                    i++;
                    j++;
                    result = true;
                } else {
                    result = false;
                }
            }


        }
        return result;
    }*/

}
