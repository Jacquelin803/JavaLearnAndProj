package algorithm.C02_LinearSearch;


/**
 * 线性查找
 * 可以查找各种类型的元素--使用泛型实现
 * Java种的八种基本数据类型：boolean，byte, char,short,int,long,float,double
 * 每个基本数据类型都有其包装类：Boolean，Byte，Character，Short，Integer，Long，Float，Double
 * 泛型接受的不能是基本数据类型，只能是类对象
 * 使用自动转换
 */
public class LinearSearch02 {

    public static <E> int search(E[] data, E target) {  //<E>代表该函数为泛型函数，接收的是泛型，输入E代表的泛型，可以是对象，基础数据类型，等； 返回index
        for (int i = 0; i < data.length; i++) {
//            if (data[i] == target) {    //不规范，==表示引用相等，字符是一样的
            if (data[i].equals(target)) {  // equals比较的是两个对象的地址
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Integer[] data02 = {12, 34, 23, 1, 5, 56, 78};

        int res1 = LinearSearch02.search(data02, 23);
        System.out.println(res1);

        int res2 = LinearSearch02.search(data02, 4567);
        System.out.println(res2);

        int[] data01 = {12, 3, 4, 5, 23, 56, 24, 19};
        int res3 = LinearSearch01.search(data01, 23);
        System.out.println(res3);

        Student[] students={new Student("L"),
                            new Student("M"),
                            new Student("E")};

//        Student target=new Student("M");
//
//        int res4=LinearSearch02.search(students,target);
//        System.out.println(res4);

        int res5=LinearSearch02.search(students,students[1]);  // 这一步就只走equals函数里的this==student这一行代码了; 也不会在search里再走i=2的循环，因为i=1时已经return true了
        System.out.println(res5);

    }
}
