package systemCourses.DB.reflex;

import org.junit.Test;

import java.lang.reflect.Method;


public class MethodTest01 {

    @Test
    /**
     * 测试公有的方法
     */
    public void demo01() throws Exception {

        Class c1 = Class.forName("systemCourses.DB.reflex.Person");
        Person p1 = (Person) c1.newInstance();
        Method eatMethod = c1.getMethod("eat");
        eatMethod.invoke(p1);
        p1.eat();   // = eatMethod.invoke(p1);
        /**
         *  print:
         *  eat~~~~~
         */
    }
    @Test
    /**
     * 测试私有的方法
     */
    public void demo02() throws Exception {
        Class c2 = Class.forName("systemCourses.DB.reflex.Person");
        Method smilePrivMethod = c2.getDeclaredMethod("smile");  // getMethod : public method; getDeclaredMethod : all method
        Person p2 = (Person) c2.newInstance();
        smilePrivMethod.setAccessible(true);
        smilePrivMethod.invoke(p2); // no arguments
        smilePrivMethod.invoke(p2,null);   // no arguments ,= smilePrivMethod.invoke(p2);
    }
    @Test
    /**
     * 测试公有的方法带参数
     */
    public void demo03() throws Exception {
        Class c3 = Class.forName("systemCourses.DB.reflex.Person");
        Person p3 = (Person) c3.newInstance();
        Method sayPubMethodArg = c3.getMethod("say", String.class);
        sayPubMethodArg.invoke(p3,"L");
    }

    @Test
    /**
     * 测试私有的方法带参数
     */
    public void demo04() throws Exception {
        Class c3 = Class.forName("systemCourses.DB.reflex.Person");
        Person p3 = (Person) c3.newInstance();
        Method studyPrivArg = c3.getDeclaredMethod("study", String.class, Integer.class);
        studyPrivArg.setAccessible(true);
        String returnStr = (String) studyPrivArg.invoke(p3, "L4", 2);
        System.out.println(returnStr);
        /**
         * print:
         * L4 is 2 years old,can study
         * hello L4
         */
    }
}
