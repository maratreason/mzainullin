package ru.mzainullin.points.promprog.ch02;

public class CastTypes {
    public static void main(String[] args) {
        Float f1 = new Float(10.71);
        String s1 = Float.toString(0f); // float в String
        String s2 = String.valueOf(f1); // Float в String
        Byte b = Byte.valueOf("120"); //String в Byte
        double d = b.doubleValue(); // Byte в double
        byte b0 = (byte)(float)f1; // Float в byte
        short s = (short) d; // double в short

        Character ch = new Character('3');
        int i = Character.digit(ch.charValue(), 10);
        System.out.printf("f1=%1.2e s1=%s s2=%s%n", f1, s1, s2);
        System.out.printf("b=%o d=%.1f b0=%d s=%d i=%d", b, d, b0, s, i);
    }
}
