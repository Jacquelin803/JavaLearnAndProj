package systemCourses.foundation.chapter02_obj.obj5;

public class AnimalTest {
    public static void main(String[] args) {
        Animal one=new Animal("tutu1",2);
        Animal two=new Animal("tutu1",2);

        System.out.println(one.equals(two));
    }



}
