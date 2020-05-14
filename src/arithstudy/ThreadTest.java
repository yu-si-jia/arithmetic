package arithstudy;
/**
 * 两个线程交替打印
 */

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
public class ThreadTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int K = scanner.nextInt();
            int N = scanner.nextInt();
            AtomicInteger n = new AtomicInteger(1);
            for (int i = 0; i < K; i++) {
                int finalI = i;
                new Thread(() -> {
                    int num = finalI + 1;
                    while (n.get() != N - 1) {
                        while (n.get() % K != num && !(num == K && n.get() % K == 0)) {

                        }
                        System.out.print(String.format("%d:%d ", num, n.get()));
                        n.getAndIncrement();
                    }
                }).start();

            }
        }
    }
}

