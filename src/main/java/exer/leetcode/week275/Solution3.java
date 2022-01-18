package exer.leetcode.week275;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-09 16:20
 */
public class Solution3 {
    public int wordCount(String[] startWords, String[] targetWords) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : targetWords) {
            char[] chs = word.toCharArray();
            Arrays.sort(chs);
            String str = new String(chs);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        Set<String> res = new HashSet<>();
        for (String s : startWords) {
            int[] newcnt = new int[26];
            int m = s.length();
            for (int i = 0; i < m; i++) {
                newcnt[s.charAt(i) - 'a']++;
            }
            char[] cs = new char[m + 1];
            for (int i = 0; i < m; i++) cs[i] = s.charAt(i);

            for (int i = 0; i < 26; i++) {
                char[] temp = new char[m + 1];
                if (newcnt[i] == 0) {
                    cs[m] = (char) (i + 'a');
                    for (int j = 0; j <= m; j++) temp[j] = cs[j];
                    Arrays.sort(temp);
                    String str = new String(temp);
                    if (map.containsKey(str)) {
                        res.add(str);
                    }
                }
            }
        }

        int resn = 0;
        for (String re : res) {
            resn += map.get(re);
        }

        return resn;
    }
}
