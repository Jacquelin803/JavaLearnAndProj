package systemCourses.foundation.chapter02_obj.obj7.tel;

public class TelPhone {
    private String brand;
    private int price;

    public TelPhone(){

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void call(){
        System.out.println("手机可以打电话");
    }
}
