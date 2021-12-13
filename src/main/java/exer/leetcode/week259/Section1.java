package exer.leetcode.week259;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-19 14:46
 */
public class Section1 {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String op : operations) {
            res += getValue(op) ? 1 : -1;
        }
        return res;
    }

    public boolean getValue(String s) {
        for (char c : s.toCharArray()) {
            if (c == '+') return true;
            if (c == '-') return false;
        }
        return false;
    }
}
