package systemCourses.foundation.chapter03_commonUtils.wrap;

public class CatTest {

    public static void main(String[] args) {
//        Cat three=new Cat(); //如果只写了带参构造方法，则实例化时只能带参
//        Cat three=new Cat("tutu");
//        three.run();

//        Cat four =new Cat();  //如果想要无参实例化，只能显式定义一个无参构造方法
//        four.run();

        Cat five=new Cat("tutu",2,1000);
        System.out.println(five.name);
        System.out.println(five.month);
        System.out.println(five.weight);
        five.run("tutu");
    }
}
