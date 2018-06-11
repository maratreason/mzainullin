package ru.mzainullin.iterators.set;

import ru.mzainullin.iterators.map.SimpleMapImpl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Марат Зайнуллин.
 * @since 07.06.2018.
 * @param <E> - Тип данных - Ключ.
 */
public class SimpleHashSet<E> {

    private Node<E>[] hashTable;
    private int size = 0;
    private float threshold;

    public SimpleHashSet() {
        hashTable = new Node[16];
        threshold = hashTable.length * 0.75f;
    }

    private class Node<E> {
        private List<Node<E>> nodes;
        private int hash;
        private E element;

        private Node(E element) {
            this.element = element;
            nodes = new LinkedList<Node<E>>();
        }

        private List getNodes() {
            return nodes;
        }

        private int hash() {
            return hashCode() % hashTable.length;
        }

        private E getElement() {
            return element;
        }

        private void setElement(E element) {
            this.element = element;
        }
    }


    boolean add (E element) {
        if (size + 1 >= threshold) {
            threshold *= 2;
            arrayDoubling();
        }

        Node<E> newNode = new Node<>(element);
        int index = newNode.hash();

        if (hashTable[index] == null) {
            return simpleAdd(index, newNode);
        }

        List<Node<E>> nodeList = hashTable[index].getNodes();

        for (Node<E> node : nodeList) {
            if (collisionProcessing(node, newNode, nodeList)) {
                return true;
            }
        }
        return false;
    }


    public boolean simpleAdd(int index, Node<E> newNode) {
        hashTable[index] = new Node<>(null);
        hashTable[index].getNodes().add(newNode);
        size++;
        return true;
    }


    private boolean keyExistButValueNew(Node<E> nodeFromList, Node<E> newNode, E element) {
        if (newNode.getElement().equals(nodeFromList.getElement())) {
            nodeFromList.setElement(element);
            return true;
        }
        return false;
    }


    private boolean collisionProcessing(Node<E> nodeFromList, Node<E> newNode, List<Node<E>> nodes) {
        if (newNode.hashCode() == nodeFromList.hashCode() &&
                !Objects.equals(newNode.element, nodeFromList.element)) {
            nodes.add(newNode);
            size++;
            return true;
        }
        return false;
    }


    private void arrayDoubling() {
        Node<E>[] oldHashTable = hashTable;
        hashTable = new Node[oldHashTable.length * 2];
        size = 0;
        for (Node<E> node : oldHashTable) {
            if (node != null) {
                add(node.element);
            }
        }
    }


    boolean remove (E element) {
        int index = hash(element);
        if (hashTable[index] == null) {
            return false;
        }

        if(hashTable[index].getNodes().size() == 1) {
            hashTable[index].getNodes().remove(0);
            return true;
        }

        List<Node<E>> nodeList = hashTable[index].getNodes();

        for (Node<E> node : nodeList) {
            if (element.equals(node.getElement())) {
                nodeList.remove(node);
                return true;
            }
        }
        return false;
    }


    public E contains (E element) {
        int index = hash(element);
        if (index < hashTable.length && hashTable[index] != null) {

            List<Node<E>> list = hashTable[index].getNodes();
            for (Node<E> node : list) {
                if (element.equals(node.getElement())) {
                    return node.getElement();
                }
            }
        }
        return null;
    }


    public int size() {
        return size;
    }


    private int hash(E key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % hashTable.length;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleHashSet<?> that = (SimpleHashSet<?>) o;
        return size == that.size &&
                Float.compare(that.threshold, threshold) == 0 &&
                Arrays.equals(hashTable, that.hashTable);
    }


    @Override
    public int hashCode() {
        int result = Objects.hash(size, threshold);
        result = 31 * result + Arrays.hashCode(hashTable);
        return result;
    }
}


/*
3. Реализовать коллекцию типа Set на базе хэш-таблицы [#998]

        Напишите свою реализацию Set на базе хэш-таблицы. Реализуйте следующие методы:
        1) boolean add (E e)
        2) boolean contains (E e)
        3) boolean remove (E e)

        Ваша хэш-таблица должна базироваться на массиве. Не используйте стандартные коллекции JDK.

        Принципы организации хэш-таблиц вы сможете узнать из следующих источников:
        1) Wikipedia - хеш-таблица
        2) Core Java - К.Хорстманн
        3) Алгоритмы. Построение и анализ. - Т.Кормен и др.
        4) Алгоритмы и структуры данных. - Н. Вирт
        5) Структуры данных и алгоритмы Java - Роберт Лафоре. Стр. 487.

        Разрешение коллизий реализовывать не надо.
        Предусмотрите возможность роста хэш-таблицы при нехватке места для нового элемента. */
