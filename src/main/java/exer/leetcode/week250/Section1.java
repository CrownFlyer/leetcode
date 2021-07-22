package exer.leetcode.week250;

import java.util.HashSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-21 09:06
 */
public class Section1 {
    public int canBeTypedWords(String text, String brokenLetters) {
        int cnt = 0;
        HashSet<Character> set = new HashSet<>();
        int m = brokenLetters.length();
        for (int i = 0; i < m; i++) {
            set.add(brokenLetters.charAt(i));
        }
        String[] strs = text.split(" ");
        for (String str : strs) {
            int len = str.length();
            for (int i = 0; i < len; i++) {
                if (set.contains(str.charAt(i))) {
                    cnt--;
                    break;
                }
            }
            cnt++;
        }
        return cnt;
    }
}
