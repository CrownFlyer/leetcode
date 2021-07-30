package exer.leetcode.week251;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-25 15:08
 */
public class Section2 {
    @Test
    public void test() {
        String num = "132";
        int[] change = {9, 8, 5, 0, 3, 6, 4, 2, 6, 8};
        System.out.println(maximumNumber(num, change));
    }

    public String maximumNumber(String num, int[] change) {
        int n = num.length();
        char[] chars = num.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chars[i] - '0' < change[chars[i] - '0']) {
                while (i < n && chars[i] - '0' <= change[chars[i] - '0']) {
                    chars[i] = (char) (change[chars[i] - '0'] + '0');
                    i++;
                }
                break;
            }
        }
        return new String(chars);
    }
}
