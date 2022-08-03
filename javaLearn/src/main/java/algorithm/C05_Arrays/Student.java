package algorithm.C05_Arrays;

public class Student  implements Comparable<Student>{

    private String name;
    private int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student another){
        return another.score - this.score;
    }

    @Override
    public boolean equals(Object student){

        if(this == student)
            return true;

        if(student == null)
            return false;

        if(this.getClass() != student.getClass())
            return false;

        Student another = (Student)student;
        return this.score == another.score;
    }

    @Override
    public String toString(){
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {
        ArrayE<Student> arr=new ArrayE<Student>();
        arr.addLast(new Student("L",21));
        arr.addLast(new Student("M",22));
        arr.addLast(new Student("J",20));
        System.out.println(arr);
        arr.remove(1);
        System.out.println(arr);
    }
}
