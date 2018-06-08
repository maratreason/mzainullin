package ru.mzainullin.iterators.set;

import java.util.ArrayList;

/**
 * @author Marat Zainullin
 * @since 08.06.2018
 * @param <K> - key
 * @param <V> - value
 */
public class Hasher<K, V> {


    /**
     * Класс узла связного списка.
     * Используется только в хэш-таблице.
     * реализуется в виде двусвязного списка.
     * @param <K>
     * @param <V>
     */
    private static class LinkedListNode<K, V> {
        public LinkedListNode<K, V> next;
        public LinkedListNode<K, V> prev;
        public K key;
        public V value;
        public LinkedListNode(K k, V v) {
            key = k;
            value = v;
        }

        public String printForward() {
            String data = "(" + key + "," + value + ")";
            if (next != null) {
                return data + "->" + next.printForward();
            } else {
                return data;
            }
        }
    }


    private ArrayList<LinkedListNode<K, V>> arr;


    /**
     * Метод создания списка связных списков.
     * @param capacity - размер.
     */
    public Hasher(int capacity) {
        /* Создание списка связных списков.
         * Список заполняется значениями null.
         * (единственный способ создания массива заданного размера).
         */
        arr = new ArrayList<LinkedListNode<K, V>>();
        arr.ensureCapacity(capacity);
        for (int i = 0; i < capacity; i++) {
            arr.add(null);
        }
    }


    /**
     * Метод вставки ключа и значения в хэш-таблицу.
     * @param key - ключ.
     * @param value - значение.
     * @return - true / false.
     */
    public V put(K key, V value) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node != null) {
            V oldValue = node.value;
            node.value = value; // Просто обновить значение.
            return oldValue;
        }

        node = new LinkedListNode<K, V>(key, value);
        int index = getIndexForKey(key);
        if (arr.get(index) != null) {
            node.next = arr.get(index);
            node.next.prev = node;
        }
        arr.set(index, node);
        return null;
    }


    /**
     * Метод удаления узла для ключа.
     * @param key - key.
     * @return - true / false.
     */
    public V remove(K key) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node == null) {
            return null;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            /* Удаление начального узла - обновление. */
            int hashKey = getIndexForKey(key);
            arr.set(hashKey, node.next);
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
        return node.value;
    }


    /**
     * Метод получение значения для ключа.
     * @param key - key
     * @return - ключ.
     */
    public V get(K key) {
        if (key == null) return null;
        LinkedListNode<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }


    /**
     * Метод получение узла связного списка для заданного ключа.
     * @param key - key
     * @return - true false
     */
    private LinkedListNode<K, V> getNodeForKey(K key) {
        int index = getIndexForKey(key);
        LinkedListNode<K, V> current = arr.get(index);
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


    /**
     * Метод проверяет содержит ли коллекция элемент.
     * @param e - искомый элемент.
     * @return - true / false.
     */
    public boolean contains(K e) {
        boolean isTrue = false;
        LinkedListNode<K, V> node = getNodeForKey(e);
        if (node.key.equals(e)) {
            isTrue = true;
        }
        return isTrue;
    }


    /**
     * Метод для связывания ключа с индексом.
     * @param key - ключ.
     * @return - индекс.
     */
    public int getIndexForKey(K key) {
        return Math.abs(key.hashCode() % arr.size());
    }


    public void printTable() {
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i) == null ? "" : arr.get(i).printForward();
            System.out.println(i + ": " + s);
        }
    }
}
