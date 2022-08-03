package algorithm.C04_InsertionSort;

import algorithm.C03_SelectionSort.ArrayGenerator;
import algorithm.C03_SelectionSort.SortHelper;

/**
 * 插入排序法 : 对一个数组排序
 * 对于插入排序：时间复杂度为O(sqaure(n))
 * 复杂度是用最复杂情况下衡量的
 * 但，对于已经排序好的数组，其复杂度为O(n),这点可以从运行时间看出
 * 原理解释：如果已经排好序，在进入第二个for循环时， t.compareTo(arr[j-1]) < 0 条件是不符合的，也即不会走关于j的for循环
 *
 */
public class InsertionSort {

    public InsertionSort() {
    }

    /**
     * 过程：
     * 将i位置的元素拿出来作为临时变量t
     * 依次与前面的元素对比，表面上看是前面几个元素整体往后移动给t留出位置
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int j;
            E t=arr[i];
            for (j = i; j - 1 >= 0 && t.compareTo(arr[j-1]) < 0; j--){  // 条件合并表达
                arr[j]=arr[j-1];
            }
            arr[j]=t;
        }
    }

    public static void main(String[] args) throws Exception{

        // test int
//        Integer[] arr1={6,4,1,6,3,5};
//
//        InsertionSort.sort(arr1);
//        for(int i:arr1){
//            System.out.println(i);
//        }

        // test performance
        /**
         * test  algorithm time
         */
        int[] dataSize = {10000, 100000};
        for(int n: dataSize) {

            System.out.println("Random Array : ");

            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortHelper.sortTest("InsertionSort", arr);


            System.out.println();

            System.out.println("Ordered Array : ");

            arr = ArrayGenerator.generateOrderedArray(n);
            SortHelper.sortTest("InsertionSort", arr);

            System.out.println();

            /**
             * Random Array :
             * [Ljava.lang.Integer;@6d6f6e28
             * InsertionSort , 10000 ,0.175181444s
             *
             * Ordered Array :
             * [Ljava.lang.Integer;@266474c2
             * InsertionSort , 10000 ,3.01295E-4s
             *
             * Random Array :
             * [Ljava.lang.Integer;@6f94fa3e
             * InsertionSort , 100000 ,11.419902433s
             *
             * Ordered Array :
             * [Ljava.lang.Integer;@5e481248
             * InsertionSort , 100000 ,5.25826E-4s
             */
        }

    }
}
