package systemCourses.foundation.chapter02_obj.obj7.ainimal;

public class Cat extends Animal{
    private double weight;

    public Cat(){

    }
    public Cat(String name,int month,double weight){
        super(name,month);
        this.weight=weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void run(){
        System.out.println("小猫快乐的奔跑");
    }

    @Override  //ctrl+o
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void playBall(){
        System.out.println("小猫喜欢玩线球");
    }
}
