package algorithm.C09_MergeSort;

import algorithm.utils.ReflexMap;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 判断selectionSort是否正确
 */
public class SortHelper {

    public SortHelper(){}

    public static  <E extends Comparable<E>> boolean isSorted(E[] arr){
        System.out.println(arr.toString());
        for (int i=1;i<arr.length;i++){
            if (arr[i-1].compareTo(arr[i])>0){
                return false;
            }
        }
        return true;
    }
//    @Test
    public  static <E extends Comparable<E>> void sortTest(String sortName,E[] arr) throws Exception {
        long begin = System.nanoTime();

        //        if(sortName.equals("SelectionSort")){
//            SelectionSort.sort(arr);
//        }

        // 使用反射机制
        String className = ReflexMap.get(sortName);
        Class<?> c1 = Class.forName(className);
        Method sortMethod = c1.getMethod("sort", Comparable[].class);
        Constructor cons = c1.getConstructor();
        Object obj = cons.newInstance();
        sortMethod.invoke(obj,new Object[]{arr});

        long end = System.nanoTime();

        double time = (end - begin)/1000000000.0;

        if(!SortHelper.isSorted(arr)){
            throw new RuntimeException(sortName+" failed!");
        }
        System.out.println(String.format("%s , %d ,%s s",sortName,arr.length,time));
    }
}
