package Chores;

import java.util.Scanner;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-12 18:06
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = 0, L = 0;
        N = in.nextInt();
        L = in.nextInt();
        N *= 2;
        while (L < N && L <= 100) {
            if (N % L == 0 && (N / L - L + 1) % 2 == 0) break;
            L++;
        }
        if (L > 100 || L == N) {
            System.out.println("No");
            System.exit(0);
        }
        int n = (N / L - L + 1) / 2;
        for (int i = 0; i < L; i++) {
            if (i < L - 1)
                System.out.print(n + i + " ");
            else System.out.print(n + i);
        }
    }


}
