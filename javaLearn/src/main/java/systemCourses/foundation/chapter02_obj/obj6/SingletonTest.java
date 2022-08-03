package systemCourses.foundation.chapter02_obj.obj6;

public class SingletonTest {

    public static void main(String[] args) {

        SingletonOne one=SingletonOne.getInstance();
        SingletonOne two=SingletonOne.getInstance();
        System.out.println(one);  //SingletonOne@74a14482
        System.out.println(two); //SingletonOne@74a14482
        System.out.println("++++++++++++++++++++");
        SingletonTwo one1=SingletonTwo.getInstance();
        SingletonTwo two1=SingletonTwo.getInstance();
        System.out.println(one1);
        System.out.println(two1);




    }
}
