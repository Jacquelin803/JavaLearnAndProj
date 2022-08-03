package systemCourses.DB.reflex;

import org.junit.Test;

public class ClassTest01 {
    @Test
    /**
     * 获得Class对象
     * * 1.通过类名.class
     * * 2.对象.getClass()
     * * 3.Class.forName();
     */
    public void demo01() throws ClassNotFoundException {
        Class<Person> c1 = Person.class;

        Person p1 = new Person();
        Class c2 = p1.getClass();

        Class<?> c3 = Class.forName("systemCourses.DB.reflex.Person");
    }
}
