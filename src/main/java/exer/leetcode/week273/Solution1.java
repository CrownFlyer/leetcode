package exer.leetcode.week273;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-27 22:22
 */
public class Solution1 {
    public boolean isSameAfterReversals(int num) {
        int cur = num;
        if (num == 0) return true;
        StringBuilder sb = new StringBuilder();
        while (cur > 0) {
            sb.append(cur % 10);
            cur /= 10;
        }
        cur = Integer.parseInt(sb.toString());
        System.out.println(cur);
        sb = new StringBuilder();
        while (cur > 0) {
            sb.append(cur % 10);
            cur /= 10;
        }
        cur = Integer.parseInt(sb.toString());
        return num == cur;
    }

    public boolean isSameAfterReversals2(int num) {
        return num != 0 && num % 10 != 0;
    }
}
