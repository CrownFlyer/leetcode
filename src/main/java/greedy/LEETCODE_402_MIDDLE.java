package greedy;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-22 20:07
 */
public class LEETCODE_402_MIDDLE {
    @Test
    public void test() {
        String s = "1432219";
        System.out.println(new LEETCODE_402_MIDDLE().removeKdigits(s, 3));
    }

    public String removeKdigits(String num, int k) {
        Deque<Character> dq = new LinkedList<>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            while (!dq.isEmpty() && k > 0 && dq.peekLast() > c) {
                dq.pollLast();
                k--;
            }
            dq.offerLast(c);
        }
        for (int i = 0; i < k; i++) {
            dq.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()&&dq.peekFirst() == '0') dq.pollFirst();
        while (!dq.isEmpty()) sb.append(dq.pollFirst());
        String res = sb.toString();
        return res.length()==0?"0":res;
    }


}
