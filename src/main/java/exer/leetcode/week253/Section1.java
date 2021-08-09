package exer.leetcode.week253;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-08 10:22
 */
public class Section1 {
    @Test
    public void test() {

    }

    public boolean isPrefixString(String s, String[] words) {
        int sLen = s.length();
        int cnt = 0;
        int i = 0;
        int n = words.length;
        StringBuilder sb = new StringBuilder();
        while (i < n && cnt < sLen) {
            cnt += words[i].length();
            sb.append(words[i++]);
        }
        return s.equals(sb.toString());

    }
}
