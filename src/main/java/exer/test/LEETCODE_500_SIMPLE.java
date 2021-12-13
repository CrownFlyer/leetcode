package exer.test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-31 09:52
 */
public class LEETCODE_500_SIMPLE {
    public String[] findWords(String[] words) {
        Map<Integer, Set<Character>> map = new HashMap<Integer, Set<Character>>() {{
            put(1, new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p','Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P')));
            put(2, new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l','A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L')));
            put(3, new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm','Z', 'X', 'C', 'V', 'B', 'N', 'M')));
        }};
        List<String> res = new ArrayList<>();
        for (String word : words) {
            int i;
            for (i = 1; i <= 3; i++) {
                if (map.get(i).contains(word.charAt(0))) break;
            }
            int idx = 1;
            while (idx < word.length() && map.get(i).contains(word.charAt(idx))) idx++;
            if (idx == word.length()) res.add(word);
        }
        String[] resArray = new String[res.size()];
        res.toArray(resArray);
        return resArray;

    }
}
