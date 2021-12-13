package exer.test;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-27 09:28
 */
public class LEETCODE_301_HARD {
    @Test
    public void test() {
        String s = "((((((((((((((((((((aaaaa";
        System.out.println(s.length());
        System.out.println(removeInvalidParentheses(s));
    }

    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        boolean[] masks = new boolean[n];
        char[] chs = s.toCharArray();
        Set<String> set = new HashSet<>();
        int lremove = 0, rremove = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') lremove++;
            else if (s.charAt(i) == ')') {
                if (lremove == 0) rremove++;
                else lremove--;
            }
        }

        for (int i = 0; i < (1 << n); i++) {
            if (Integer.bitCount(i) == lremove + rremove) {
                int k = i;
                Arrays.fill(masks, false);
                for (int j = 0; j < n; j++) {
                    if ((k & (1 << j)) != 0) masks[j] = true;
                }
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (!masks[j]) sb.append(chs[j]);
                }
                String str = sb.toString();
                if (check(str))
                    set.add(str);
            }
        }
        return new ArrayList<>(set);
    }

    public boolean check(String s) {
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (cnt == 0) return false;
                cnt--;
            } else if (c == '(') cnt++;
        }
        return cnt == 0;
    }
}
