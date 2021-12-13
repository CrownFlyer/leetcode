package exer.leetcode.week266;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-07 10:28
 */
public class Section2 {
    @Test
    public void test() {
        System.out.println(countVowels("noosabasboosa"));
    }

    public long countVowels(String word) {
        int n = word.length();
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (isValid(word.charAt(i))) res += (long) (n - i)*(i+1);
        }
        return res;
    }

    boolean isValid(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
