package systemCourses.foundation.chapter03_commonUtils.wrap;

public class Cat {
    String name;
    int month;
    double weight;

    //构造方法
    public Cat(){
        System.out.println("我是无参构造方法");  //在实例化时会跟着执行: Cat three=new Cat();
    }
    public Cat(String name){
        System.out.println("我是带参构造方法");
    }
    public Cat(String name,int month,double weight){
        this();
        this.name=name;
        this.month=month;
        this.weight=weight;
        this.run();
        System.out.println("我是带3参构造方法");
    }

    public void run(){
        System.out.println("run in night !! run in day0");
    }

    public void run(String name){
        this.eat();
        System.out.println(name+" run in night !! run in day1");
    }

    public void eat(){
        System.out.println("eat much more fish");
    }


}
