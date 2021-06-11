package backtrack;

import sun.reflect.generics.tree.Tree;

import java.math.BigInteger;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-07 15:50
 */
public class LEETCODE_306_MIDDLE {
    public static void main(String[] args) {
        String s = "199100199";
        LEETCODE_306_MIDDLE test = new LEETCODE_306_MIDDLE();
        System.out.println(test.isAdditiveNumber(s));
    }

    // 暴力
    public boolean isAdditiveNumber1(String s) {
        int n = s.length();
        if (n < 3) return false;
        int start = 0;
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= n / 2; j++) {
                if(s.charAt(0)=='0'&&i>1){
                    start++;
                }
                if (s.charAt(i) == '0'&&j>1) {
                    break;
                }
                BigInteger first = new BigInteger(s.substring(start, i));
                BigInteger second = new BigInteger(s.substring(i, i + j));
                int index = i + j;
                boolean done = false;
                while (index < n) {
                    BigInteger res = first.add(second);
                    int size = res.toString().length();
                    if (n - index < size) break;
                    else {
                        if (res.toString().equals(s.substring(index, index + size))) {
                            index += size;
                            first = second;
                            second = res;
                        } else{
                            if(s.charAt(0)=='0') return false;
                            break;
                        }

                    }
                    if (index == n) done = true;
                }
                if (done) return true;
            }
        }
        return false;
    }

    // dfs:很严谨
    public boolean isAdditiveNumber(String num) {
        int length = num.length();
        if(length < 3) return false;

        long first = 0, second = 0;
        for(int i = 0; i < length - 2; i++) { // 第一个数
            if(i != 0 && first == 0) return false; // 开头不能是 0
            first = first * 10 + (num.charAt(i) - '0');
            second = 0;

            for(int j = i + 1; j < length - 1; j++) { // 第二个数
                if(j != i + 1 && second == 0) break; // 开头不能是 0
                second = second * 10 + (num.charAt(j) - '0');
                if(dfs(num, j + 1, length, first, second)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(String num, int index, int length, long first, long second) {
        if(index >= length) return true;

        long temp = 0;
        long sum = first + second;
        for(int i = index; i < length; i++) {
            if(i != index && temp == 0) return false; // 开头不能是 0
            temp = temp * 10 + (num.charAt(i) - '0');
            if(temp == sum && dfs(num, i + 1, length, second, sum)) {
                return true;
            } else if(temp > sum) { // 如果大于就肯定没有后续了，否则还可能继续添加数字
                return false;
            }
        }

        return false;
    }

}
