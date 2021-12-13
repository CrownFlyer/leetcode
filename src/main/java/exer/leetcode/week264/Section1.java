package exer.leetcode.week264;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-24 10:28
 */
public class Section1 {
    @Test
    public void test() {

    }

    public int countValidWords(String sentence) {
        String[] strs = sentence.split(" ");
        int res = 0;
        for (String str : strs) {
            if (str.equals("")) continue;
            int n = str.length();
            int idx = 0;
            boolean lz = false;
            while (idx < n) {
                if (str.charAt(idx) >= '0' && str.charAt(idx) <= '9') break;
                if (str.charAt(idx) == '-') {
                    if (!lz) lz = true;
                    else break;
                }
                if ((str.charAt(idx) == '!' || str.charAt(idx) == ',' || str.charAt(idx) == '.') && idx != n - 1) break;
                if (str.charAt(idx) == '-' && ((idx == 0 || idx == n - 1) ||
                        !(Character.isLetter((str.charAt(idx - 1))) && Character.isLetter((str.charAt(idx + 1))))))
                    break;
                idx++;
            }
            if (idx == n) res++;
        }
        return res;
    }
}
