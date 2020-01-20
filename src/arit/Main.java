package arit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int num = scanner.nextInt();
        int[][] big = new int[100][100];
        for (int i=0;i<100;i++){
            for (int j = 0;j<100;j++){
                big[i][j] = 1;
            }
        }
        for (int i = 0; i < num; i++) {
            int a = scanner.nextInt()+50;
            int b = scanner.nextInt()+50;

            big[a][b] = 100;
        }

        int dp[][] = new int[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[i][j] = big[i][j];
                    } else {
                        dp[i][j] = dp[i][j - 1] + big[i][j];
                    }
                } else {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + big[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + big[i][j];
                    }
                }
            }
        }


            x = 50+x;


            y = 50+y;

        System.out.println(dp[x -1][y -1 ]);
    }
}
