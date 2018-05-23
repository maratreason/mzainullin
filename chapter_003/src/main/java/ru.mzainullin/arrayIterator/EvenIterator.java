package ru.mzainullin.arrayIterator;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

/**
 * @author Marat Zainullin
 * @since 21.05.2018
 */
public class EvenIterator implements Iterator {

    private int position = 0;
    private int[] arr;

    public EvenIterator(final int[] numbers) {
        this.arr = numbers;
//        Iterator it = new EvenIterator(new int[]{4, 2, 1, 1});
    }

    @Override
    public boolean hasNext() {
        boolean isTrue = false;
        for (int index = 0; index != arr.length; index++) {
            if (arr[index] > 0 && arr[index] % 2 == 0) {
                this.position++;
                isTrue = true;
                next();
                break;
            } else {
                isTrue = false;
            }
        }
        return isTrue;
    }

    @Override
    public Integer next() {
        int arrPos = 0;
        if (arr.length > this.position) {
            arrPos = this.position++;
        }
        return arrPos;
    }
}
