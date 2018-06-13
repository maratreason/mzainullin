package ru.mzainullin.iterators.tree;

import java.util.*;

/**
* @author Marat Zainullin
* @since 13.06.2018
* @param <E> - параметр
*/
public class Node<E extends Comparable<E>> {

    private final List<Node<E>> children = new ArrayList<>();
    private final E value;
    Node<E> root;

    public Node(final E value) {
        this.value = value;
    }

    public void add(Node<E> child) {
        this.children.add(child);
    }

    public List<Node<E>> leaves() {
        return this.children;
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;

    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

}

/**
 2. Элемент дерева может иметь множество дочерних элементов.

 метод add - Должен находить элемент parent в дереве и добавлять в него дочерний элемент.

 node.children.add(child);

 Для поиска элементов в дереве надо использовать методы findBy - Он уже реализован.

 В дереве не могут быть дубликатов, т.е. никакие узлы в дереве не должны иметь двух одинаковых дочерних узлов.
 Обязательно реализуйте итератор.


 Давайте рассмотрим пример реализации метода findBy

 В качестве базового алгоритма мы будет использовать алгоритм поиска в ширину.

 @Override
 public Optional<Node<E>> findBy(E value) {
     Optional<Node<E>> rsl = Optional.empty();
     Queue<Node<E>> data = new LinkedList<>();
     data.offer(this.root);
     while (!data.isEmpty()) {
         Node<E> el = data.poll();
         if (el.eqValue(value)) {
             rsl = Optional.of(el);
             break;
         }
         for (Node<E> child : el.leaves()) {
            data.offer(child);
         }
     }
     return rsl;
 }

 Смысл этого алгоритма в следующем.
 Мы берем очередь и добавляем первый элемент дерева - это корень.
 Дальше, если корень не наш элемент мы добавляем все элементы корня.
 И так для каждого элемента.

 */