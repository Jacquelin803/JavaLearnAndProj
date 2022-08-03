package systemCourses.foundation.chapter01;

public class Flow5 {
    public static void main(String[] args) {
        //break
        int k=0;
//        for (int i=1;i<5;i++){
//            System.out.println("i="+i);
//            for (int j=1;j<5;j++){
//                System.out.println("j="+j);
//                k=i+j;
//                if (j==3)break;
//            }
//        }
//        System.out.println(k);

        //continue
        for (int i=1;i<=9;i++){
            if (i%2==0)continue;
            k=k+i;
        }
        System.out.println(k);
    }
}
