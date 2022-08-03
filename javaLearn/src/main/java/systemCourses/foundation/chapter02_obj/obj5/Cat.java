package systemCourses.foundation.chapter02_obj.obj5;

public class Cat extends Animal{

    private double weight;

    public static int st3=13;
    static{
        System.out.println("我是子类的静态代码块");
    }

    {
        System.out.println("我是子类的构造代码块");
    }

    public Cat(){
        System.out.println("我是子类的无参构造方法");
    }

    public Cat(String name,int month){
        /* 子类构造默认调用父类无参构造方法
         * 可以通过super()调用父类允许被访问的其他构造方法
         * super()必须放在子类构造方法有效代码第一行
         * 构造方法调用时，super和this不能同时出现，都要抢占第一行，一山无二虎
         * super主要目的是指明调用哪个构造方法
         */
//        super(name,month);
        this();   //会执行本类（即子类）中的无参构造方法
        System.out.println("我是子类的带参构造方法");

    }

    public static void say(){
        //this和super在静态方法中不能被调用
//        this.weight=20;
//        super.temp=1;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void run(){
        System.out.println(this.getName()+"\t"+"running");
    }

    @Override   //alt+insert
    public void eat() {
        super.eat();
    }

    @Override
    public Cat create() {
        return new Cat();
    }
}
