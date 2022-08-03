package algorithm.C03_SelectionSort;


/**
 * 选择排序法 [时间复杂度：square(n)]
 * 数组按大小排序
 */
public class SelectionSort {

    public SelectionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) throws Exception{   // 带约束的泛型：extends comparable，泛型本身不支持比较

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            // 每一次循环都是找剩下元素中的最小值对应index，将这个最小值与i对应的元素交换
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex])<0){    // <:-1
//                    System.out.println(arr[j].compareTo(arr[minIndex]));
                    minIndex=j;
                }
            }
            swap(arr,minIndex,i);
        }

    }

    /**
     * 交换数组中两个元素 (只在当前类内部使用，private)
     */
    private static <E> void swap(E[] arr,int minIndex,int i){
        E t=arr[i];
        arr[i]=arr[minIndex];
        arr[minIndex]=t;
    }

    public static void main(String[] args) throws Exception{

        /**test int order*/
//        Integer[] arr1 = {9, 4, 5, 1, 0, 2};
//        SelectionSort.sort(arr1);
//        for(Integer i : arr1){
//            System.out.println(i);
//        }
        /**
         * test Student class order
         */
//        Student[] students={new Student("L",99),
//                new Student("M",88),
//                new Student("E",100)};
//
//        SelectionSort.sort(students);
//        for(Student s: students){
//            System.out.println(s +" ");
//        }

//        Student (name: M, score: 88)
//        Student (name: L, score: 99)
//        Student (name: E, score: 100)

        /**
         * test  algorithm time
         */
        int n=100000;
        Integer[] arr1=ArrayGenerator.generateRandomArray(n,n);

        SortHelper.sortTest("SelectionSort",arr1);
//        throw new RuntimeException("~~~");

    }
}
