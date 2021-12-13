package exer.meituan;

import java.util.Scanner;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-13 16:08
 */
public class Section6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        sc.close();

        int tail = n - 1;
        while (s.charAt(tail) != 'T') tail--;
        while (s.charAt(tail) != 'M') tail--;

        int head = 0;
        while (s.charAt(head) != 'M') head++;
        while (s.charAt(head) != 'T') head++;

        System.out.println(s.substring(head + 1, tail));
    }
}
