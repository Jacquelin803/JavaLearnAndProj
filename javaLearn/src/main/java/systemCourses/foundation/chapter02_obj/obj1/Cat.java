package systemCourses.foundation.chapter02_obj.obj1;

public class Cat {
    String name;
    int month;
    double weight;
    String species;

    public void run(){
        System.out.println("run in night !! run in day");
    }

    public void run(String name){
        System.out.println(name+" run in night !! run in day");
    }

    public void eat(){
        System.out.println("eat much more fish");
    }


}
