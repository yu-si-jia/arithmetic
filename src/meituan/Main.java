package meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int re(int k, int n, int[] a) {
        if (k == 0) {
            return a[n];
        }
        if (n == 0) {
            return 0;
        }
        return re(k - 1, n, a) + re(k, n - 1, a);
    }

    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            int result = re(k, n, a);
            System.out.println((int)(result % (1e9 + 7)));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            String[] nums = new String[num];
            for (int i = 0; i<nums.length; i++){
                nums[i] = scanner.next();
            }
            int result = 0;
            List<StringBuilder> allList = new ArrayList<>();
            for (String n : nums) {
                int size = nums.length;
                for (int i = 0; i < size; i++) {
                    StringBuilder newSub = new StringBuilder();
                    newSub.append(n);
                    allList.add(newSub);
                }
            }
            for (StringBuilder sb : allList) {
                String sb1 = sb.toString();
                for (int i = 1; i < sb.length(); i++) {
                    if (i % sb1.charAt(i) != 0) {
                        continue;
                    } else {
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}


//    }
//    public static void main3(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int n = scanner.nextInt();
//            int[] radius = new int[n + 1];
//            for (int i = 1; i <= n; i++) {
//                radius[i] = scanner.nextInt();
//            }
//            int radiusSquare = 0;
//            int p = 0;
//            for (int i = n; i > 0; i--) {
//                p = p ^ 1;
//                if (p == 1) {
//                    radiusSquare += Math.pow(radius[i], 2);
//                } else if (p == 0) {
//                    radiusSquare -= Math.pow(radius[i], 2);
//                }
//            }
//            System.out.println(String.format("%.5f", Math.PI * radiusSquare));
//        }
//    }
//
//
//    public List<List<Integer>> enumerate(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        for (Integer n : nums) {
//            int size = res.size();
//            for (int i = 0; i < size; i++) {
//                List<Integer> newSub = new ArrayList<>(res.get(i));
//                newSub.add(n);
//                res.add(newSub);
//            }
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int num = scanner.nextInt();
//            char[] nums = new char[num];
//            int result = 0;
//            List<StringBuilder> allList = new ArrayList<>();
//            for (char n : nums) {
//                int size = allList.size();
//                for (int i= 0; i < size; i++) {
//                    StringBuilder newSub = new StringBuilder();
//                    newSub.append(n);
//                    allList.add(newSub);
//                }
//            }
//            for (StringBuilder sb : allList){
//                String sb1 = sb.toString();
//                for (int i=0; i<sb.length(); i++){
//                    if (sb1.charAt(i)%i!=0){
//                        continue;
//                    }
//                    else {
//                        result++;
//                    }
//                }
//            }
//            System.out.println(result);
//        }
//
//
//        public static void main2 (String[]args){
//            Scanner scanner = new Scanner(System.in);
//            while (scanner.hasNext()) {
//                int n = scanner.nextInt();
//                int[] path = new int[n];
//                double area = 0;
//                double all = 0;
//                for (int i = 0; i < n; i++) {
//                    path[i] = scanner.nextInt();
//                }
//                for (int i = 0; i < path.length; i++) {
//                    if (i % 2 != 0) {
//                        area = Math.PI * path[i] * path[i];
//                    }
//                }
//                all = area;
//            }
//        }
//
//
//        public static void main1 (String[]args){
//            Scanner scanner = new Scanner(System.in);
//            while (scanner.hasNext()) {
//                String string = scanner.next();
//                int[] replace = new int[10];
//                for (int i = 1; i < 10; i++) {
//                    replace[i] = scanner.nextInt();
//                }
//                StringBuilder sb = new StringBuilder();
//                for (int i = 0; i < string.length(); i++) {
//                    if (string.charAt(i) == '-') {
//                        sb.append(string.charAt(i));
//                        continue;
//                    }
//                    sb.append(replace[string.charAt(i) - '0']);
//                }
//                System.out.println(sb);
//            }
//        }
//    }
