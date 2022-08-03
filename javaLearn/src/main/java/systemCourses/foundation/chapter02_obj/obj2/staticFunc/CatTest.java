package systemCourses.foundation.chapter02_obj.obj2.staticFunc;

public class CatTest {

    public static void main(String[] args) {
        Cat one=new Cat("tutu");
        one.price=1200;
        one.eat();


        Cat two =new Cat("huahua");
        two.price=2000;
        Cat.price=3000;//是类成员，最好是类调用
        two.eat();
        System.out.println("one"+one.price);
        System.out.println("one"+two.price);
    }
}
