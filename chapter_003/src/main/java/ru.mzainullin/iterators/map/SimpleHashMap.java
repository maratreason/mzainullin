package ru.mzainullin.iterators.map;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Marat Zainullin
 * @since 09.06.2018
 * @param <K> - ключ.
 * @param <V> - значение.
 */
public class SimpleHashMap<K, V> implements SimpleMapImpl<K, V> {

    private Node<K, V>[] hashTable;
    private int size = 0;
    private float threshold;

    public SimpleHashMap() {
        hashTable = new Node[16];
        threshold = hashTable.length * 0.75f;
    }

    /**
     * Метод для вставки данных в коллекцию.
     * @param key - ключ.
     * @param value - значение.
     * @return - true / false.
     */
    @Override
    public boolean insert(K key, V value) {
        if (size + 1 >= threshold) {
            threshold *= 2;
            arrayDoubling();
        }

        Node<K, V> newNode = new Node<>(key, value);
        int index = newNode.hash();

        if (hashTable[index] == null) {
            return simpleAdd(index, newNode);
        }

        List<Node<K, V>> nodeList = hashTable[index].getNodes();

        for (Node<K, V> node : nodeList) {
            if (keyExistButValueNew(node, newNode, value) || collisionProcessing(node, newNode, nodeList)) {
                return true;
            }
        }

        return false;
    }


    private boolean simpleAdd(int index, Node<K, V> newNode) {
        hashTable[index] = new Node<>(null, null);
        hashTable[index].getNodes().add(newNode);
        size++;
        return true;
    }


    private boolean keyExistButValueNew(Node<K, V> nodeFromList, Node<K, V> newNode, V value) {
        if (newNode.getKey().equals(nodeFromList.getKey()) &&
            !newNode.getValue().equals(nodeFromList.getValue())) {
            nodeFromList.setValue(value);
            return true;
        }
        return false;
    }


    private boolean collisionProcessing(Node<K, V> nodeFromList, Node<K, V> newNode, List<Node<K, V>> nodes) {
        if (newNode.hashCode() == nodeFromList.hashCode() &&
                !Objects.equals(newNode.key, nodeFromList.key) &&
                !Objects.equals(newNode.value, nodeFromList.value)) {
            nodes.add(newNode);
            size++;
            return true;
        }
        return false;
    }


    private void arrayDoubling() {
        Node<K, V>[] oldHashTable = hashTable;
        hashTable = new Node[oldHashTable.length * 2];
        size = 0;
        for (Node<K, V> node : oldHashTable) {
            if (node != null) {
                for (Node<K, V> n : node.getNodes()) {
                    insert(n.key, n.value);
                }
            }
        }
    }

    /**
     * Метод получения ключа коллекции.
     * @param key - искомый ключ.
     * @return - наденный ключ / null.
     */
    @Override
    public V get(K key) {
        int index = hash(key);
        if (index < hashTable.length && hashTable[index] != null) {

            List<Node<K, V>> nodeList = hashTable[index].getNodes();

            for (Node<K, V> node : nodeList) {
                if (key.equals(node.getKey())) {
                    return node.getValue();
                }
            }
        }
        return null;
    }


    @Override
    public boolean delete(K key) {
        int index = hash(key);
        if(hashTable[index] == null) {
            return false;
        }
        if (hashTable[index].getNodes().size() == 1) {
            hashTable[index].getNodes().remove(0);
            return true;
        }

        List<Node<K, V>> nodeList = hashTable[index].getNodes();

        for (Node<K, V> node : nodeList) {
            if (key.equals(node.getKey())) {
                nodeList.remove(node);
                return true;
            }
        }
        return false;
    }


    private int hash(K key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % hashTable.length;
    }


    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {

            int counterArray = 0;
            int valueCounter = 0;
            Iterator<Node<K, V>> subIterator = null;

            @Override
            public boolean hasNext() {
                if (valueCounter == size) {
                    return false;
                }
                if (subIterator == null || !subIterator.hasNext()) {
                    if (moveToNextCell()) {
                        subIterator = hashTable[counterArray].getNodes().iterator();
                    } else {
                        return false;
                    }
                }
                return subIterator.hasNext();
            }

            private boolean moveToNextCell() {
                counterArray++;
                while (hashTable[counterArray] == null) {
                    counterArray++;
                }
                return hashTable[counterArray] != null;
            }

            @Override
            public V next() {
                valueCounter++;
                return subIterator.next().getValue();
            }
        };
    }


    private class Node<K, V> {
        private List<Node<K, V>> nodes;
        private int hash;
        private K key;
        private V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            nodes = new LinkedList<Node<K, V>>();
        }

        private List<Node<K, V>> getNodes() {
            return nodes;
        }

        private int hash() {
            return hashCode() % hashTable.length;
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        }

        private void setValue(V value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            hash = 31;
            hash = hash * 17 + key.hashCode();
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj instanceof Node) {
                Node<K, V> node = (Node) obj;
                return (Objects.equals(key, node.getKey()) &&
                        Objects.equals(value, node.getValue()) ||
                        Objects.equals(hash, node.hashCode()));
            }
            return false;
        }
    }
}