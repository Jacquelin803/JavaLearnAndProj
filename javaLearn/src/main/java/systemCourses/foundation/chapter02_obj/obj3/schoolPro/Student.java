package systemCourses.foundation.chapter02_obj.obj3.schoolPro;

public class Student {

    private String studentNo;
    private String studentName;
    private String studentSex;
    private int studentAge;
    private Subject studentSubject;//引用其他类作为成员属性，就可将引入类的属性方法与该类关联


    // 无参构造方法
    public Student(){

    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public void setStudentAge(int studentAge) {
        if (studentAge<10 || studentAge>100)
            this.studentAge=18;
        else
            this.studentAge = studentAge;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentSubject(Subject studentSubject) {
        this.studentSubject = studentSubject;
    }

    public Subject getStudentSubject() {
        if (this.studentSubject==null)
            this.studentSubject=new Subject();
        return studentSubject;
    }

    //多参构造方法，实现对学号、姓名、性别、年龄的赋值
    public Student(String studentNo, String studentName, String studentSex, int studentAge) {
        this.setStudentNo(studentNo);
        this.setStudentName(studentName);
        this.setStudentSex(studentSex);
        this.setStudentAge(studentAge);
    }
    //多参构造方法，实现对学号、姓名、性别、年龄的赋值
    public Student(String studentNo, String studentName, String studentSex, int studentAge,Subject studentSubject) {
        this.setStudentNo(studentNo);
        this.setStudentName(studentName);
        this.setStudentSex(studentSex);
        this.setStudentAge(studentAge);
        this.setStudentSubject(studentSubject);
    }

    /**
     *  学生自我介绍的方法
     * @return 自我介绍的信息，包括姓名、学号、性别、年龄
     */
    public String introduce(){
        String str="学生信息如下：\n姓名：" + this.getStudentName() + "\n学号：" + this.getStudentNo() + "\n性别："
                + this.getStudentSex() + "\n年龄：" + this.getStudentAge()+"\n所报专业名称："+
                this.getStudentSubject().getSubjectName()+"\n学制年限："+this.getStudentSubject().getSubjectLife();
        return str;
    }

    public String introduce(Subject mySubject){
        String str = "学生信息如下：\n姓名：" + this.getStudentName() + "\n学号：" + this.getStudentNo() + "\n性别："
                + this.getStudentSex() + "\n年龄：" + this.getStudentAge() + "\n所报专业名称：" + mySubject.getSubjectName() + "\n学制年限："+mySubject.getSubjectLife()+"\n专业编号："+mySubject.getSubjectNo();
        return str;
    }


}
