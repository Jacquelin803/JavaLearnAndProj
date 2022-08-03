package systemCourses.foundation.chapter02_obj.obj7.tel;

public class PhoneTest {

    public static void main(String[] args) {
        IPhoto ip=new Phone();
        ip.photo();

        TelPhone tp=new Phone();
        tp.call();

        INet in=new Phone();
        in.connection();
    }
}
