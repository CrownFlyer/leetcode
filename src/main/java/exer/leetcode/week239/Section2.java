package exer.leetcode.week239;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-22 15:56
 */
public class Section2 {
    public static void main(String[] args) {
        String s = "00";
        System.out.println(splitString(s));
    }

    public static boolean splitString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int index = 0;
        // 处理无意义的'0'
        while (index < n && chars[index] == '0') index++;
        if (index == n) return false;
        for (int len = 1; len <= (n - index + 1) / 2; len++) {
            long first = Long.parseLong(s.substring(index, index + len));
            int nextIndex = index + len;
            if (nextIndex == n) return false;
            // 下一个需要的值
            long next = first - 1;
            while (nextIndex < n) {
                String nextString = String.valueOf(next);
                // 处理无意义的'0'
                while (next != 0 && nextIndex < n && chars[nextIndex] == '0') nextIndex++;
                // 处理有意义的'0'
                while (nextIndex < n - 1 && next == 0 && chars[nextIndex] == '0') nextIndex++;
                if (nextIndex + nextString.length() <= n && !s.substring(nextIndex, nextIndex + nextString.length()).equals(nextString))
                    break;
                nextIndex += nextString.length();
                next--;
            }
            if (nextIndex == n) return true;
        }
        return false;
    }
}
