package exer.test;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-15 10:53
 */
public class LEETCODE_38_MIDDLE {
    @Test
    public void test() {
        System.out.println(countAndSay(30));
    }

    public String countAndSay(int x) {
        String last = "1";
        while (x > 1) {
            int n = last.length();
            int idx = 0;
            char cur = last.charAt(idx);
            StringBuilder sb = new StringBuilder();
            while (idx < n) {
                int cnt = 0;
                while (idx < n && last.charAt(idx) == cur) {
                    idx++;
                    cnt++;
                }
                sb.append((char) (cnt + '0'));
                sb.append(cur);
                cur = idx < n ? last.charAt(idx) : cur;
            }
            last = sb.toString();
            x--;
        }
        return last;
    }
}
