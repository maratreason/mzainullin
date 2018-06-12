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
        boolean isTrue = false;
        if (size + 1 >= threshold) {
            threshold *= 2;
            arrayDoubling();
        }

        Node<K, V> newNode = new Node<>(key, value);
        int index = newNode.hash();

        if (hashTable[index] == null) {
            isTrue = simpleAdd(index, newNode);
        }

        List<Node<K, V>> nodeList = hashTable[index].getNodes();

        for (Node<K, V> node : nodeList) {
            if (keyExistButValueNew(node, newNode, value) || collisionProcessing(node, newNode, nodeList)) {
                isTrue = true;
            }
        }

        return isTrue;
    }


    private boolean simpleAdd(int index, Node<K, V> newNode) {
        hashTable[index] = new Node<>(null, null);
        hashTable[index].getNodes().add(newNode);
        size++;
        return true;
    }


    private boolean keyExistButValueNew(Node<K, V> nodeFromList, Node<K, V> newNode, V value) {
        boolean isTrue = false;
        if (newNode.getKey().equals(nodeFromList.getKey()) &&
            !newNode.getValue().equals(nodeFromList.getValue())) {
            nodeFromList.setValue(value);
            isTrue = true;
        }
        return isTrue;
    }


    private boolean collisionProcessing(Node<K, V> nodeFromList, Node<K, V> newNode, List<Node<K, V>> nodes) {
        boolean isTrue = false;
        if (newNode.hashCode() == nodeFromList.hashCode() &&
                !Objects.equals(newNode.key, nodeFromList.key) &&
                !Objects.equals(newNode.value, nodeFromList.value)) {
            nodes.add(newNode);
            size++;
            isTrue = true;
        }
        return isTrue;
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
        V isNode = null;
        int index = hash(key);
        if (index < hashTable.length && hashTable[index] != null) {

            List<Node<K, V>> nodeList = hashTable[index].getNodes();

            for (Node<K, V> node : nodeList) {
                if (key.equals(node.getKey())) {
                    isNode = (V) node.getValue();
                } else {
                    isNode = null;
                }
            }
        }

        return isNode;
    }


    @Override
    public boolean delete(K key) {
        boolean isTrue = false;
        int index = hash(key);
        if(hashTable[index] == null) {
            isTrue = false;
        }
        if (hashTable[index].getNodes().size() == 1) {
            hashTable[index].getNodes().remove(0);
            isTrue = true;
        }

        List<Node<K, V>> nodeList = hashTable[index].getNodes();

        for (Node<K, V> node : nodeList) {
            if (key.equals(node.getKey())) {
                nodeList.remove(node);
                isTrue = true;
            }
        }
        return isTrue;
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
                boolean isTrue = false;
                if (valueCounter == size) {
                    isTrue = false;
                }
                if (subIterator == null || !subIterator.hasNext()) {
                    if (hashTable[counterArray] != null) {
                        subIterator = hashTable[counterArray].getNodes().iterator();
                    } else {
                        isTrue = false;
                    }
                }
                isTrue = subIterator.hasNext();
                return isTrue;
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
            boolean isTrue = false;
            if (this == obj) {
                isTrue = true;
            }

            if (obj instanceof Node) {
                Node<K, V> node = (Node) obj;
                isTrue = (Objects.equals(key, node.getKey()) &&
                        Objects.equals(value, node.getValue()) ||
                        Objects.equals(hash, node.hashCode()));
            }
            return isTrue;
        }
    }
}