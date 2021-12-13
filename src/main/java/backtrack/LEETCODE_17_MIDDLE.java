package backtrack;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-24 19:27
 */
public class LEETCODE_17_MIDDLE {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = new HashMap<Character, List<Character>>() {{
            put('2', Arrays.asList('a', 'b', 'c'));
            put('3', Arrays.asList('d', 'e', 'f'));
            put('4', Arrays.asList('g', 'h', 'i'));
            put('5', Arrays.asList('j', 'k', 'l'));
            put('6', Arrays.asList('m', 'n', 'o'));
            put('7', Arrays.asList('p', 'q', 'r', 's'));
            put('8', Arrays.asList('t', 'u', 'v'));
            put('9', Arrays.asList('w', 'x', 'y', 'z'));
        }};
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        StringBuilder sb = new StringBuilder();

        dfs(digits, res, sb, 0, digits.length(), map);
        return res;
    }

    private void dfs(String digits, List<String> res, StringBuilder sb, int cur, int n, Map<Character, List<Character>> map) {
        if (cur == n) {
            res.add(sb.toString());
            return;
        }
        for (char c : map.get(digits.charAt(cur))) {
            sb.append(c);
            dfs(digits, res, sb, cur + 1, n, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
