package systemCourses.foundation.chapter02_obj.obj2.ani;

public class Cat {
    // 修改属性的可见性---private 限定只能在当前类内访问
    private String name;
    int month;
    double weight;
    String species;

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public int getMonth() {

        return month;
    }

    public void setMonth(int month) {
        if (month<0){
            System.out.println("error month");
        }else {
            this.month = month;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
    public Cat(int month){
        System.out.println("我是带参构造方法");
        this.setMonth(month);
    }

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
