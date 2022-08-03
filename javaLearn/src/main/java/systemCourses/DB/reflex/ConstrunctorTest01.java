package systemCourses.DB.reflex;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class ConstrunctorTest01 {

    @Test
    /**
     * 获得无参数的构造方法
     */
    public void demo01() throws Exception {

        Class c1 = Class.forName("systemCourses.DB.reflex.Person");
        Constructor c = c1.getConstructor();
        Person p1 = (Person) c.newInstance();  // 相当于Person p1 = new Person();
        p1.eat();
    }

    @Test
    /**
     * 获得有参数的构造方法
     */
    public void demo02() throws Exception {

        Class c2 = Class.forName("systemCourses.DB.reflex.Person");
        Constructor c = c2.getConstructor(String.class,String.class);
        Person p2 = (Person) c.newInstance("L","male");  // 相当于Person p1 = new Person();
        p2.eat();
        System.out.println(p2.getName()+p2.getSex());
    }
}
