package exer.leetcode.double66;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-28 17:52
 */
public class Solution1 {
    public int countWords(String[] words1, String[] words2) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> dup = new HashSet<>();
        for (String word : words1) {
            if (set1.contains(word)) dup.add(word);
            set1.add(word);
        }
        for (String word : dup) set1.remove(word);

        dup.clear();
        for (String word : words2) {
            if (set2.contains(word)) dup.add(word);
            set2.add(word);
        }
        for (String word : dup) set2.remove(word);

        int res = 0;
        for (String word : set1) {
            if (set2.contains(word)) res++;
        }

        return res;

    }
}
