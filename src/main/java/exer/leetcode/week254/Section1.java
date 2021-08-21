package exer.leetcode.week254;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-18 23:34
 */
public class Section1 {
    @Test
    public void test() {

    }

    public int numOfStrings(String[] patterns, String word) {
        int n = patterns.length;
        int res = 0;
        int wLen = word.length();
        for (int i = 0; i < n; i++) {
            int size = patterns[i].length();
            for (int j = 0; j <= wLen - size; j++) {
                if (patterns[i].equals(word.substring(j, j + size))) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

}
