import java.util.Scanner;

public class Test7<T> {

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            Integer n = in.nextInt();
//            for(int i = 1;;i++){
//                int sum = 2*i+i*(i-1)/2;
//                if(sum>n||sum==n){
//                    System.out.println(n-(i-1)*2);
//                    break;
//                }
//            }
//        }
//    }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int day = input.nextInt();
            int a = 3, b = 0;

            for (int i = 3; ; i++) {

                if (a <= day) {
                    a += i;
                    b++;
                } else {
                    break;
                }

            }
            System.out.println(day - 2 * b);
        }

}
