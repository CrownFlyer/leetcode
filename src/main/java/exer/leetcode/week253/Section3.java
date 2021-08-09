package exer.leetcode.week253;

import org.junit.Test;

import java.util.Stack;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-08 10:22
 */
public class Section3 {
    @Test
    public void test() {
        String s = "[]";
        System.out.println(minSwaps(s));
    }


    public int minSwaps(String s) {
        int n = s.length();
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        boolean[] v = new boolean[n];

        while (i < n) {
            if (s.charAt(i) == '[') stack.push(i);
            else if (!stack.isEmpty()) {
                v[stack.pop()] = true;
                v[i] = true;
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for(i=0;i<n;i++){
            if(!v[i]) sb.append(s.charAt(i));
        }
        String S = sb.toString();
        n = S.length();
        int min = (n + 2) / 4;
        int max = n / 2;
        int cnt = 0;
        for (int index = n / 2; index < n; index++) {
            if (!v[index] && S.charAt(index) == ']') cnt++;
        }
        return Math.min(Math.abs(cnt - min), Math.abs(cnt - max));
    }


}
