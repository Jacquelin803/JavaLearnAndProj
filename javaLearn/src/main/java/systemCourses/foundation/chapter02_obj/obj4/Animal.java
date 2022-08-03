package systemCourses.foundation.chapter02_obj.obj4;

public class Animal {
//extends
    private String name="xiaomaomi";
    private int month=2;
    private String species;

    public  int temp=111;
    private static int st1=11;
    public static int st2=12;

    static {
        System.out.println("我是父类的静态代码块");
    }
    {
        System.out.println("我是父类的构造代码块");
    }

    // 父类的构造不允许被继承、不允许被重写,但是会影响子类对象的实例化：子类的多参构造方法是调用父类无参构造方法
    public Animal(){
        System.out.println("我是父类的无参构造方法");
    }

    public Animal(String name, int month) {
        System.out.println("我是父类的带参构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void eat(){
        System.out.println(this.name+"super eating");
    }
}
