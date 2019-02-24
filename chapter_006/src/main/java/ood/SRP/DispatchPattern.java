package ood.SRP;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

/**
 * @author Marat Zainullin.
 * @version 0.1.
 * @since 23.02.2019.
 */
public class DispatchPattern {

    Calculator calc;
    private final Map<Integer, Function<Message, Double>> dispatch = new HashMap<>();
    private Scanner scn;

    private Function func(Message message, double result) {
        return msg -> {
            System.out.println(message.getInfo() + "\nРезультат вычисления: " + result + "\n");
            return result;
        };
    }

    public Function<Message, Double> add(int first, int second) {
        String point = "Вы выбрали пункт: 0";
        System.out.println(point);
        double result = calc.add(first, second);
        Message message = new Message(0, point);
        return func(message, result);
    }

    public Function<Message, Double> subtract(int first, int second) {
        String point = "Вы выбрали пункт: 1";
        System.out.println(point);
        double result = calc.subtract(first, second);
        Message message = new Message(0, point);
        return func(message, result);
    }

    public Function<Message, Double> multiple(int first, int second) {
        String point = "Вы выбрали пункт: 2";
        System.out.println(point);
        double result = calc.multiple(first, second);
        Message message = new Message(0, point);
        return func(message, result);
    }

    public Function<Message, Double> divide(int first, int second) {
        String point = "Вы выбрали пункт: 3";
        System.out.println(point);
        double result = calc.divide(first, second);
        Message message = new Message(0, point);
        return func(message, result);
    }


    public DispatchPattern init() {
        scn = new Scanner(System.in);
        int first = scn.nextInt();
        int second = scn.nextInt();
        this.load(0, Message.ADD, this.add(first, second));
        this.load(1, Message.SUBTRACT, this.subtract(first, second));
        this.load(2, Message.MULTIPLE, this.multiple(first, second));
        this.load(3, Message.DIVIDE, this.divide(first, second));
        return this;
    }


    public void load(int num, int type, Function<Message, Double> action) {
        this.dispatch.put(num, action);
    }

//    public Collection iterateDispatch(int inputNumber) {
//        for (int count : dispatch.keySet()) {
//            if (inputNumber == count) {
//                return dispatch.values();
//            }
//        }
//    }

}
