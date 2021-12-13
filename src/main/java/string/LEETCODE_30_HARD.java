package string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-14 21:39
 */
public class LEETCODE_30_HARD {
    @Test
    public void test() {
        String s = "aaa";
        String[] words = {"a", "a", "a"};
        System.out.println(findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> target = new HashMap<>();
        for (String word : words)
            target.put(word, target.getOrDefault(word, 0) + 1);
        int len1 = words[0].length(), len2 = words.length, len3 = len1 * len2;
        int n = s.length();

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i + len3 - 1 < n; i++) {
            Map<String, Integer> cur = new HashMap<>();
            for (int j = 0; j < len2; j++) {
                String substring = s.substring(i + j * len1, i + (j + 1) * len1);
                cur.put(substring, cur.getOrDefault(substring, 0) + 1);
            }
            boolean f = true;
            for (Map.Entry<String, Integer> entry : target.entrySet()) {
                if (cur.getOrDefault(entry.getKey(), 0).equals(entry.getValue())) {
                    f = false;
                    break;
                }
            }
            if (f) res.add(i);
        }
        return res;
    }
}
