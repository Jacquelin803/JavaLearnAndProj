package algorithm.C03_SelectionSort;


/**
 * 本测试例目的：根据学生score进行排序
 * 重写compareTo方法，每个传入的类需要自己重写自己的比较规则
 */
public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;  // 谁调用该类就把name赋值给谁
        this.score = score;
    }

    // 覆盖object里边的equals方法，原方法传入的是object类型
    @Override
    public boolean equals(Object student) {

        // 如果人家本来就是自己，即相同的地址值。那么返回TRUE
        if (this == student) {
            return true;
        }

        if (student == null) {
            return false;
        }

        // 类都是不一样的，肯定不是一个学生了
        if (this.getClass() != student.getClass()) {
            return false;
        }

        // 强转后，姓名全部转成小写，比较姓名
        Student another = (Student) student; // 强转成Student类
        return this.name.toLowerCase().equals(another.name.toLowerCase());
    }

    // 实现了comparable接口，重写其compareTo方法
    @Override
    public int compareTo(Student another) {
        return this.score - another.score;
    }

    // 重写toString方法
    @Override
    public String toString(){
        return String.format("Student (name: %s, score: %d)",name,score);
    }


}
