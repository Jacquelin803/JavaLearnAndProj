package algorithm.C03_SelectionSort;

import java.util.Random;

public class ArrayGenerator {

    private static Integer[] arr;

    public static Integer[] generateOrderedArray(int n){

        Integer[] arrTemp = new Integer[n];
        for(int i = 0; i < n; i ++)
            arrTemp[i] = i;
        arr=arrTemp;
        return arr;
    }

    public static Integer[] generateRandomArray(int n, int bound) {

        Integer[] arrTemp = new Integer[n];
        Random rnd = new Random();

        for (int i = 0; i < n; i++) {
            arrTemp[i] = rnd.nextInt(bound);
        }
        arr=arrTemp;
        return arr;
    }



    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Array : [");
        for(int i =0;i<arr.length;i++){
            res.append(arr[i]+", ");
        }
        res.append("]");
        return res.toString();
    }
}
