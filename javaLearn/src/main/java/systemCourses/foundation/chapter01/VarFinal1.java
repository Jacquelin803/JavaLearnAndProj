package systemCourses.foundation.chapter01;

public class VarFinal1 {

    public static void main(String[] args) {
        float f1=123.5f;
        double d1=234.5;
        double d2=12;//int,small than doube
        double d3=123L;
        final double sum = d1 + f1;

        char a='a';
        char c=65535;
        System.out.println(c);
        char c2=(char) 65536;
        int c3=c2;//隐式类型转换
        System.out.println(c2+"\n"+c3);

//        char d='\u005d';
//        System.out.println(d);

//        String s1=" ";
//        String s2="d";
//        System.out.println(s1+s2);
//        int x=2,y=1;
//        System.out.println(x);
//
//        float  e=1.2E3f;//科学计数法
//        double f=1.2e-4;
//        System.out.println(e);
//        System.out.println(f);

        //类型转换
        int i=100;
        long l=i;
        i=(int)l;

        float f=100012345677800000l;  //丢失精度
        System.out.println("f="+f);

        //常量
        int k=5;
        k=20;
        final int M=10;
//        m=2;

    }
}
