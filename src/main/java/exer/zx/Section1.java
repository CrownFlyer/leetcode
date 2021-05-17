package exer.zx;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-24 14:14
 */
public class Section1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = 0, h = 0, u = 0;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            n = in.nextInt();
            h = in.nextInt();
            u = in.nextInt();
        }
        int[] arr = new int[n];
        Arrays.sort(arr);
        int index = arr.length;
        while (h < u) {
            h += arr[--index];
        }
        System.out.println(arr.length - index);

    }
}
