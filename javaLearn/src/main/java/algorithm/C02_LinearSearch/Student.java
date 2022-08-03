package algorithm.C02_LinearSearch;


/**
 * 本测试例目的：从一群学生中挑出目标学生，比较原则是根据姓名比较
 * 如果不重写equals方法，比较的就是引用地址值，不论姓名一样与否都是返回-1，因为new过两次Student
 */
public class Student {

    private String name;

    public Student(String name) {
        this.name = name;  // 谁调用该类就把name赋值给谁
    }

    // 覆盖object里边的equals方法，原方法传入的是object类型
    @Override
    public boolean equals(Object student) {

        // 如果人家本来就是自己，即相同的地址值。那么返回TRUE
        if(this==student){
            return true;
        }

        if (student==null){
            return false;
        }

        // 类都是不一样的，肯定不是一个学生了
        if (this.getClass()!=student.getClass()){
            return false;
        }

        // 强转后，姓名全部转成小写，比较姓名
        Student another = (Student) student; // 强转成Student类
        return this.name.toLowerCase().equals(another.name.toLowerCase());
    }

}
