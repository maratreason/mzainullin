package ru.mzainullin.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Marat Zainullin
 * @since 24.05.2018
 */
public class Converter {

    Iterator<Iterator<Integer>> iter;
    private Iterator<Integer> currentIterator = null;

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.iter = it;

        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                selectCurrentIterator();
                return (currentIterator != null && currentIterator.hasNext());
            }

            @Override
            public Integer next() {
                selectCurrentIterator();
                if (currentIterator == null) {
                    throw new NoSuchElementException();
                }
                return currentIterator.next();
            }

            private void selectCurrentIterator() {
                if (currentIterator != null && currentIterator.hasNext()) {
                    return;
                }
                currentIterator = null;
                while (iter.hasNext()) {
                    Iterator<Integer> nextIterator = iter.next();
                    if (nextIterator.hasNext()) {
                        currentIterator = nextIterator;
                        break;
                    }
                }
            }

        };
    }

}
