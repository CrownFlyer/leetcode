package exer.test;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-16 09:44
 */
public class LEETCODE_282_HARD {
    @Test
    public void test() {
        System.out.println(addOperators("2147483648", -2147483648));
    }

    // backtrace: O(n^4)
    int n;
    String num;
    int target;
    List<String> res;

    public List<String> addOperators(String num, int target) {
        this.n = num.length();
        this.num = num;
        this.target = target;
        this.res = new ArrayList<>();
        StringBuilder expr = new StringBuilder();
        dfs(expr, 0, 0, 0);
        return res;
    }

    private void dfs(StringBuilder expr, int i, long res, long mul) {
        if (i == n) {
            if (res == target)
                this.res.add(expr.toString());
            return;
        }

        int signIndex = expr.length();
        // 占位，下面填充符号
        if (i > 0) expr.append(0);
        long val = 0;
        // 枚举截取的数字长度，数字可以是单个0，但不能有前导零
        for (int j = i; j < n && (j == i || num.charAt(i) != '0'); j++) {
            val = val * 10 + num.charAt(j) - '0';
            expr.append(num.charAt(j));
            if (i == 0) {
                // 表达式开头不能添加符号
                dfs(expr, j + 1, val, val);
            } else {
                // 枚举符号
                expr.setCharAt(signIndex, '+');
                dfs(expr, j + 1, res + val, val);
                expr.setCharAt(signIndex, '-');
                dfs(expr, j + 1, res - val, -val);
                expr.setCharAt(signIndex, '*');
                dfs(expr, j + 1, res - mul + mul * val, mul * val);
            }
        }
        // 将StringBuilder的长度限制回signIndex，即将dfs的某条分支遍历完成
        expr.setLength(signIndex);

    }

    // 状态压缩O(4^4) * 栈求解表达式O(n)
    public List<String> addOperators1(String num, int target) {
        int n = num.length();
        List<String> res = new ArrayList<>();
        // 1:+ 2:- 3:*
        for (int i = 0; i < (int) Math.pow(4, n - 1); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(num.charAt(0));
            boolean valid = true;
            int temp_i = i;
            for (int j = 1; j < n; j++) {
                int state = temp_i % 4;
                switch (state) {
                    case 0:
                        sb.append('*');
                        break;
                    case 1:
                        sb.append('-');
                        break;
                    case 2:
                        sb.append('+');
                        break;
                    case 3:
                        int idx = sb.length() - 1;
                        while (idx >= 0 && sb.charAt(idx) == '0') idx--;
                        valid = idx >= 0 && sb.charAt(idx) > '0' && sb.charAt(idx) <= '9';
                        break;
                    default:
                        break;
                }
                temp_i /= 4;
                sb.append(num.charAt(j));
            }
            String s = sb.toString();
            if (valid && calculate(s) == target)
                res.add(s);
        }
        return res;
    }

    public long calculate(String s) {
        Deque<Long> stack = new LinkedList<>();
        char preSign = '+';
        long num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        long ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

}
