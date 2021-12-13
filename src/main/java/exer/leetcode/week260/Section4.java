package exer.leetcode.week260;

import org.junit.Test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-26 22:48
 */
public class Section4 {
    @Test
    public void test() {
        String s = "7+3*1*2";
        System.out.println(scoreOfStudents(s, new int[]{20, 13, 42}));
    }

    public int scoreOfStudents(String s, int[] answers) {
        int n = s.length();
        Deque<Integer> stk = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*'){
                stk.push((s.charAt(i + 1) - '0') * stk.pop());
                // 由于下一个数字已经算过了 这里包含循环的+1 这里再加个1，跳过该数字
                i++;
            }
            else if (s.charAt(i) != '+')
                stk.push(s.charAt(i) - '0');
        }
        int correct = 0;
        while (!stk.isEmpty())
            correct += stk.pop();

        // 区间DP
        int[] nums = new int[(n + 1) / 2];
        boolean[] op = new boolean[n / 2];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '+')
                op[i / 2] = true;
            else if (s.charAt(i) != '*')
                nums[i / 2] = s.charAt(i) - '0';
        }

        int len = (n + 1) / 2;
        // dp[i][j]:表示nums[i,j]之间的组合数
        Set<Integer>[][] dp = new HashSet[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = new HashSet();
            dp[i][i].add(nums[i]);
        }

        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = new HashSet<>();
                for (int k = i; k < j; k++) {
                    for (int l : dp[i][k]) {
                        // 注意这里是k，因为左边数字对应的后一位符号存在相同与相同下标的op中
                        if (op[k]) {
                            for (Integer r : dp[k + 1][j]) {
                                if (l + r <= 1000)
                                    dp[i][j].add(l + r);
                            }
                        }else {
                            for (Integer r : dp[k + 1][j]) {
                                if (l * r <= 1000)
                                    dp[i][j].add(l * r);
                            }
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int ans : answers) {
            if(ans == correct)
                res += 5;
            else if(dp[0][len-1].contains(ans)) res+=2;
        }
        return res;
    }


}
