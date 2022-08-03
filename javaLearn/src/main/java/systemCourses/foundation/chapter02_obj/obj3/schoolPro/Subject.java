package systemCourses.foundation.chapter02_obj.obj3.schoolPro;

/**
 * 专业类
 */
public class Subject {

    private String subjectName;
    private String subjectNo;
    private int subjectLife;
    private Student[] myStudent;
    private int studentNum;

    // 无参构造方法
    public Subject(){

    }

    // 带参构造，实现对全部属性的赋值
    public Subject(String subjectName,String subjectNo,int subjectLife){
        this.setSubjectName(subjectName);
        this.setSubjectNo(subjectNo);
        this.setSubjectLife(subjectLife);
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectNo() {
        return subjectNo;
    }

    public int getSubjectLife() {
        return subjectLife;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setSubjectNo(String subjectNo) {
        this.subjectNo = subjectNo;
    }

    public void setSubjectLife(int subjectLife) {
        if (subjectLife<=0)
            return;
        this.subjectLife = subjectLife;
    }

    public Student[] getMyStudent() {
        if (this.myStudent==null)
            this.myStudent=new Student[200];
        return myStudent;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setMyStudent(Student[] myStudent) {
        this.myStudent = myStudent;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    /**
     * 专业介绍的方法
     * @return
     */
    public String info(){
        String str ="专业信息如下：\n专业名称:"+this.getSubjectName()+"\n专业编号:"+this.getSubjectNo()
                +"\n学制年限："+this.getSubjectLife();
        return str;
    }

    public void addStudent(Student stu){
        for (int i=0;i<this.getMyStudent().length;i++){
            if (this.getMyStudent()[i]==null){
                stu.setStudentSubject(this);    //this:谁调用的addStudent，谁就是this,this->sub1
                this.getMyStudent()[i]=stu;
                this.studentNum=i+1;
                return;
            }
        }
    }
}
