package exer.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description: Scanner
 * next():读到空白符结束
 * nextLine():读到换行符结束
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-11 15:16
 */
public class Section1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入字符串（next）：");
        String str = input.next();
        System.out.println(str);

        System.out.println("请输入字符串（nextLine）：");
        String str1 = input.nextLine();
        System.out.println(str1);
        input.close();
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        sc.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            list.add(sc.next());
        }
        for (int i = 0; i < cnt; i++) {
            String username = list.get(i);
            boolean flag_Char = false, flag_Digit = false, first_Char = false;
            char fc = username.charAt(0);
            first_Char = (fc >= 'a' && fc <= 'z') || (fc >= 'A' && fc <= 'Z');
            int idx = 1, n = username.length();
            while (first_Char && idx < n) {
                char c = username.charAt(idx);
                if (!flag_Char) flag_Char = (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
                if (!flag_Digit) flag_Digit = (c >= '0' && c <= '9');
                if (!valid(c)) break;
                idx++;
            }
            System.out.println(idx == n && flag_Char && flag_Digit ? "Accept" : "Wrong");
        }
    }

    public static boolean valid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
