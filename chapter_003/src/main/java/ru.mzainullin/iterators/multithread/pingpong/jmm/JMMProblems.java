package ru.mzainullin.iterators.multithread.pingpong.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Marat Zainullin
 * @since 01.07.2018
 */
public class JMMProblems {

    private volatile int count = 0;
//    private AtomicInteger count = new AtomicInteger(0);

    private synchronized void increment() {
        count++;
    }

    public void counter() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
//                    count++;
//                    count.incrementAndGet();
                    increment();
                }
                System.out.println(count + " первый поток");
            }
        });


        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
//                    count++;
//                    count.incrementAndGet();
                    increment();
                }
                System.out.println(count + " второй поток");
            }
        });


        thread.start();
        newThread.start();
    }

    public static void main(String[] args) {
        new JMMProblems().counter();
    }

}

// 1. Проблемы визабилити. То что мы не видим что происходит в кэш.
//  volatile - значение не кэшируется
// 2. Атомарность операций. Когда процессор меняет значение в heap, операцию инкрементации делает не за 1 заход.
// Т.е. проблема в том, что сам процесс инкрементирования - не атомарен. Т.е. он происходит не за определенную
// единицу времени, а занимает какое-то время, и за это время другой поток может прийти и
// увидеть старое значение(raise condition).
// Поэтому часть операция инкрементирования окажется бессмысленной. Будет потеря данных.
//
// И чтобы это исправить :
// 1. в папке concurrent есть атомарные классы. Например AtomicInteger, которые гарантируют нам что
// у нас не будет raise condition.
// private AtomicInteger count = new AtomicInteger(0); - это атомарная переменная.
// Она снимает проблему инкрементирования тем, что блокирует переменную до тех пор, пока она не будет полностью
// обработана. Делается это так:
// count.incrementAndGet();
//
// Еще можно решить проблему вот так, без АтомикКлассов.
// Чтобы не дать потоку увидеть старое значение инкремента есть ключевое слово synchronized
// Это не позволит второму потоку зайти и посмотреть значение.
//
// volatile - решается проблема с видимостью
// synchronized - решается проблема с тем, что второй поток не видит не законченную работу первого потока.
// 1. Проблема визабилити. Из-за того, что процессоры имеют свои кэш. Первый поток не знает что делает второй поток.
// И наоборот. В итоге они работают, записывают в heap и получаются некорректные результаты.
// 2. Проблема связана с неатомарностью операций. Для того, чтобы провести какую-то операцию,
// нужно время. И этого времени достаточно чтобы другой поток зашел и увидел старое значение, которое
// может быть уже наполовину инкрементировано. Это называется проблемой raise condition.
