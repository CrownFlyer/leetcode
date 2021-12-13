package exer.test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-21 09:59
 */
public class LEETCODE_58_SIMPLE {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int i = n - 1;

        while (i >= 0 && s.charAt(i) == ' ') i--;
        if (i == -1) return 0;

        int j = i;
        while (i >= 0 && s.charAt(i) != ' ') i--;

        return j - i;
    }
}
