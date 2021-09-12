package exer.test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-07 10:00
 */
public class LEETCODE_1221_SIMPLE {
    public int balancedStringSplit(String s) {
        int n = s.length();
        int l = 0, r = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') l++;
            else r++;

            if (l == r && l != 0) {
                l = r = 0;
                res++;
            }
        }
        return res;
    }
}
