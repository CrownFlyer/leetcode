package exer.leetcode.week251;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-25 13:14
 */
public class Section1 {
    public int getLucky(String s, int k) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int temp = s.charAt(i) - 'a' + 1;
            if (temp >= 10) temp = temp / 10 + temp % 10;
            res += temp;
        }
        k--;
        while (k != 0) {
            int temp = res;
            res = 0;
            while (temp != 0) {
                res += temp % 10;
                temp /= 10;
            }
            k--;
        }
        return res;


    }
}
