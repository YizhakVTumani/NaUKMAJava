package org.example;

class ArrayStat {
    public static int findMin(int[] array){
        if (array == null || array.length == 0){
            throw  new IllegalArgumentException("array is null");
        }
        int f = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] < f){
                f = array[i];
            }
        }
        return f;
    }
    public static int findMax(int[] array){
        if (array == null || array.length == 0){
            throw  new IllegalArgumentException("array is null");
        }
        int f = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] > f){
                f = array[i];
            }
        }
        return f;
    }
    public static double calculateAvg(int[] array){
        if (array == null || array.length == 0){
            throw  new IllegalArgumentException("array is null");
        }
        double f = 0;
        double sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
            f++;
        }
        return (double)sum / f;
    }
}