package systemCourses.DB.reflex;

import org.junit.Test;

import java.lang.reflect.Field;

public class FieldTest01 {

    @Test
    /**
     * 测试公有的属性
     */
    public void demo01() throws Exception {

        Class c1 = Class.forName("systemCourses.DB.reflex.Person");
        Field nameField = c1.getField("name");
        Person p1 = (Person) c1.newInstance();
        nameField.set(p1,"L");  //=: p.name = "L";

        String nameStr = (String) nameField.get(p1);
        System.out.println(p1.name);

        p1.name="L_publicField";
        System.out.println(p1.name);

        /**
         *  print:
         *  L
         * L_publicField
         */
    }

    @Test
    /**
     * 测试私有的属性
     */
    public void demo02() throws Exception {

        Class c2 = Class.forName("systemCourses.DB.reflex.Person");
        Field sexField = c2.getDeclaredField("sex");
        Person p2 = (Person) c2.newInstance();
        sexField.setAccessible(true);
        sexField.set(p2,"male");  //=: p.name = "L";

        String sexStr = (String) sexField.get(p2);
        System.out.println(sexStr);
        System.out.println(p2);
    }
}
