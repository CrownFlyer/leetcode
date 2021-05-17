package exer.zx;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-24 14:46
 */
public class Section2 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int T = in.nextInt();
//        long[] arr = new long[T];
//        int index = 0;
//        while (in.hasNextInt()) {
//            arr[index++] = in.nextInt();
//        }
//
//        for (int i = 0; i < T; i++) {
//            long n = arr[i];
//            int res = 1;
//            while (n > 1) {
//                n = Math.max(n - n / 2, n / 2);
//                res++;
//            }
//            System.out.println(res);
//        }


        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T > 0) {
            T--;

            BigDecimal n = new BigDecimal(sc.nextLine());   // 数字超界
            int i = 0;
            while (n.compareTo(new BigDecimal(Math.pow(2, i))) == 1) {
                i++;
            }
            System.out.println(i + 1);
        }
    }
}
