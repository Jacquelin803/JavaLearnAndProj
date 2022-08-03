package systemCourses.foundation.chapter03_commonUtils.wrap;

public class Wrap {
    public static void main(String[] args) {
//        //装箱：把基本数据类型转换成包装类
//        int t1=2;
//        Integer t2=t1;
//        Integer t3=new Integer(t1);
//        System.out.println(t1);
//        System.out.println(t2);
//        System.out.println(t3);
//
//        //拆箱：把包装类转换成基本数据类型
//        int t4=t2;
//        int t5=t2.intValue();
//        double t6=t2.doubleValue();
//        System.out.println(t4);
//        System.out.println(t5);
//        System.out.println(t6);
//        Cat cat1=new Cat();
//        System.out.println(cat1.month);
//        System.out.println(cat1.name);
//        System.out.println(cat1.weight);
        Integer t7=100;
        Integer t8=100;
        Integer t9=new Integer(100);
        Integer t10=new Integer(100);
        System.out.println(t7==t8);//true
        System.out.println(t9==t10);//false
        System.out.println(t9==100);//true

        Integer t11=200;
        Integer t12=200;
        System.out.println(t11==t12);//false
    }
}


