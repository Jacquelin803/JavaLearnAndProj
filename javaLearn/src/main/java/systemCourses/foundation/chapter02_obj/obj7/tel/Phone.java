package systemCourses.foundation.chapter02_obj.obj7.tel;

public class Phone extends TelPhone implements IPhoto,INet {
    @Override
    public void photo() {
        System.out.println("手机可以拍照");
    }

    @Override
    public void connection() {

    }
}
