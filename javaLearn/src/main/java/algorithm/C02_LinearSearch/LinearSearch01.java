package algorithm.C02_LinearSearch;


/**
 * 简版线性查找（只针对int型）
 * 从一个数组中找到某个特定元素
 */
public class LinearSearch01 {

    private LinearSearch01(){}

    public static int search(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data={12,3,4,5,23,56,24,19};
        int target=56;

        int res1= LinearSearch01.search(data,56);
        System.out.println(res1);

        int res2= LinearSearch01.search(data,34);
        System.out.println(res2);
    }
}
