package systemCourses.foundation.chapter02_obj.obj3.schoolPro;

public class SchoolTest {

    public static void main(String[] args) {

        Subject sub1=new Subject("计算机科学与应用","J0001",4);
//        System.out.println(sub1.info());

//        Student stu1=new Student("S01","张三","男",200,sub1);
//        System.out.println(stu1.introduce());
        System.out.println("===============================");
//        System.out.println(stu1.introduce(sub1));
        Student stu1=new Student("S01","张yi","男",200);
        Student stu2=new Student("S02","张er","男",35);
        Student stu3=new Student("S03","张三","男",23);

        sub1.addStudent(stu1);
        sub1.addStudent(stu2);
        sub1.addStudent(stu3);
        System.out.println(sub1.getSubjectName()+"的专业中已有"+sub1.getStudentNum()+"的专业中已有");

    }
}
