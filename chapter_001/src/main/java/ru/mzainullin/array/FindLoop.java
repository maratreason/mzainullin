package ru.mzainullin.array;

/**
 * @author MaratZainullin
 * @version 1.0
 * @since 0.1
 */
public class FindLoop {

    /**
     * Метод поиска элемента в массиве.
     * @param data
     * @param el
     * @return индекс элемента
     */
    public int indexOf(int[] data, int el) {
        int result = -1;

        for(int i = 0; i < data.length; i++) {
            if(data[i] == el) {
                result = i;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 9, 14, 1, 0, 19, 21};
        FindLoop loop = new FindLoop();
        loop.indexOf(nums, 19);
    }

}
