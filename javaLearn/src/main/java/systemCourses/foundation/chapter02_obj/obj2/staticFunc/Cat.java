package systemCourses.foundation.chapter02_obj.obj2.staticFunc;

public class Cat {
    //static 就是想定义一个一直不变的量
    //静态方法中不能直接访问同一个类中的非静态成员，只能直接调用同一个类中的静态成员
    //只能通过对象实例化后，对象.成员方法的方式访问非静态成员
    // static 类共享
    // this 每个实例
    private String name;// 昵称 String类型默认值null
    private int month;// 年龄 int类型默认值0
    private double weight;// 体重 double类型默认值0.0
    private String species;// 品种

    //static: 静态 静态成员、类成员
    //static+属性--》静态属性、类属性
    public static int price;//售价   //静态只占用一个地址块，所有实例共用这个块

    //构造方法
    public Cat(String name){
        this.name=name;
        //static+方法内的局部变量--》不存在
//        static int temp=14;
        System.out.println("我是宠物猫"+this.name);
    }

    public static void eat(){
//        this.price=20;// this 每个实例
//        name="xiaomaomi";//静态方法中不能直接访问同一个类中的非静态成员，只能直接调用同一个类中的静态成员
        price=2000;
        System.out.println("eat fish");
    }
}
