package stackAndQueue;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-21 09:13
 */
public class LEETCODE_20_SIMPLE {
    @Test
    public void test() {
        String s = "{[()]}";
        System.out.println(isValid(s));
    }

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) return false;

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {   // 右括号
                if (dq.isEmpty() || dq.peek() != pairs.get(c)) return false;
                dq.pop();
            } else {
                dq.push(c);
            }
        }
        return dq.isEmpty();
    }
}
