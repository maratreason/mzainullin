package ru.mzainullin.points.promprog.ch02;

public class AffRef {
    public static void main(String[] args) {
        int myRef[], my; // объявление ссылки на массив и переменной
        float[] myRefFloat, myFloat; // два массива
        int myDin[] = new int[10];
        int myInt[] = {15, -1, 4, -3, 6};
        byte mybyte[] = {3, 5, 7};
        Object myObj[] = new Float[5];
        myRef = myDin;
        myDin = myInt;
    }
}
