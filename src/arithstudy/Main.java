package arithstudy;

import java.util.*;

/**
 * @author YuSiJia
 * @date 2020/3/15
 * @desc
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[] l = new int[m];
            int[] r = new int[m];
            for (int i=0; i<m; i++){
                l[i] = scanner.nextInt();
                r[i] = scanner.nextInt();
            }
            int sum = condition(l,r,n,0);
            System.out.println(sum);
        }
    }

    private static int condition(int[] l, int[] r, int n, int index){
        if (index == l.length){
            if (n == 0) {
                return 1;
            }
            return 0;
        }
        if (n==0&&l[index]>0){
            return 0;
        }
        int sum = 0;
        for (int i = l[index]; i<=r[index];i++){
            if (n-i>=0){
                sum += condition(l,r,n-i,index+1);
            }
        }
        return sum;
    }
}
