package ru.mzainullin.points.promprog.ch01.homework;

public class HomeWorkFive {

    // Сортировка пузырьком в обратном порядке

    static void swap(int[] a, int left, int right) {
        if (left != right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {17, 24, 3, 18, 1, 5, 9, 4, 7, 19, 35};

        for(int i = 0; i < arr.length; i++) {
            for(int j = arr.length-1; j > i; j--) {
                if(arr[j] > arr[j - 1]) {
                    swap(arr, j, j-1);
                }
            }

        }

        for(int arr2 : arr) {
            System.out.println(arr2);
        }
    }
}
