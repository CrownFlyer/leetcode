package exer.leetcode.week245;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-12 22:20
 */
public class Section1 {
    public static void main(String[] args) {
        Section1 test = new Section1();
        String[] s= {"caaaaa","aaaaaaaaa","a","bbb","bbbbbbbbb","bbb","cc","cccccccccccc","ccccccc","ccccccc","cc","cccc","c","cccccccc","c"};
        System.out.println(test.makeEqual(s));
    }
    public boolean makeEqual(String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        int size = words.length;
        if(size == 1) return true;
        for (String word : words) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c =word.charAt(i);
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        int cnt = map.get(words[0].charAt(0));

        while (it.hasNext()) {
            Map.Entry<Character, Integer> next = it.next();
            int v = next.getValue();
            if(v%size!=0) return false;
            if(v<size) return false;
        }
        return true;
    }
}
