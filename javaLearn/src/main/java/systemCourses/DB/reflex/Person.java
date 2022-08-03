package systemCourses.DB.reflex;

public class Person {

    public String name;
    private String sex;

    public Person() {
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void eat(){
        System.out.println("eat~~~~~");
    }

    private void smile(){
        System.out.println("simle ha ha ha");
    }

    public void say(String name){
        System.out.println("hello (public method ,has argument) "+name);
    }

    private String study(String name,Integer age){
        System.out.println(name + " is "+age +" years old,can study");
        return "hello "+name;
    }
}
