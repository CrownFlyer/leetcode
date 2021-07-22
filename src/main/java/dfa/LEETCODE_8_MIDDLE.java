package dfa;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-15 11:46
 */
public class LEETCODE_8_MIDDLE {
    @Test
    public void test() {
        System.out.println(myAtoi("-9123134324324432"));
    }

    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.res);
    }

    class Automaton {
        public int sign = 1;
        public long res = 0L;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                res = res * 10 + c - '0';
                res = sign == 1 ? Math.min(res, (long) Integer.MAX_VALUE) : Math.min(res, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) sign = c == '+' ? 1 : -1;
        }

        public int get_col(char c) {
            if (c == ' ') return 0;
            else if (c == '+' || c == '-') return 1;
            else if (Character.isDigit(c)) return 2;
            else return 3;
        }

    }
}
