package systemCourses.foundation.chapter02_obj.obj7.ainimal;

public class PolyTest {

    public static void main(String[] args) {

        Animal one=new Animal();//1
//        one.eat();
		/*向上转型、隐式转型、自动转型
        父类引用 指向 子类实例，可以调用子类重写父类的方法以及父类派生的方法，无法调用子类独有方法
		注意：父类中的静态方法无法被子类重写，所以向上转型之后，只能调用到父类原有的静态方法
		小类转型为大类
		 */
		Animal two=new Cat();
		two.eat();
//		two.setWeight  (无法调用)
		Animal three=new Dog();
		three.eat();

        System.out.println("++++++++++++++++++++++++++");
        /*向下转型、强制类型转换
//		 * 子类引用指向父类对象，此处必须进行强转，可以调用子类特有的方法
//		 * 必须满足转型条件才能进行强转
//		 * instanceof运算符：返回true/false
//		 */
        Cat tempCat=(Cat) two;   //原本就是new 的cat，现在只是将其还原。将这个转为Dog是不可以的，cat和dog没有兼容（继承）关系
        tempCat.run();
//        Dog tempDog=(Dog)two; //ClassCastException: com.systemCourse.foundation.chapter02.obj7.Cat cannot be cast to com.systemCourse.foundation.chapter02.obj7.Dog
//        tempDog.sleep();

        if (two instanceof Cat){
            Cat tempCat2=(Cat)two;
            tempCat2.eat();
            tempCat2.run();
            System.out.println("two可以转换为Cat类型");
        }
        if (two instanceof Dog){
            Dog tempCat2=(Dog)two;
            tempCat2.sleep();
            System.out.println("two可以转换为Dog类型");
        }

        if (two instanceof Animal){
            System.out.println("Animal");
        }

        if (two instanceof Object){
            System.out.println("Object");
        }

    }
}
