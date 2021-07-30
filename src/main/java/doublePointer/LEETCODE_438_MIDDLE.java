package doublePointer;

import org.junit.Test;
import sun.nio.cs.ext.PCK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-24 10:38
 */
public class LEETCODE_438_MIDDLE {

    @Test
    public void test() {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    // 暴力
    public List<Integer> findAnagrams1(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> res = new ArrayList<>();
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        String pSorted = new String(pArray);
        for (int i = 0; i <= sLen - pLen; i++) {
            char[] cur = s.substring(i, i + pLen).toCharArray();
            Arrays.sort(cur);
            if (new String(cur).equals(pSorted)) res.add(i);
        }
        return res;
    }

    // 滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        int[] cur = new int[26];
        int[] target = new int[26];
        int pLen = p.length();
        int sLen = s.length();
        List<Integer> res = new ArrayList<>();

        if (sLen < pLen) return res;
        for (int i = 0; i < pLen; i++) {
            target[p.charAt(i) - 'a']++;
        }

        int l = 0, r;
        for (r = 0; r < pLen - 1; r++) {
            cur[s.charAt(r) - 'a']++;
        }
        while (r < sLen) {
            cur[s.charAt(r++) - 'a']++;
            if (check(cur, target)) res.add(l);
            cur[s.charAt(l++) - 'a']--;
        }
        return res;
    }

    public boolean check(int[] cur, int[] target) {
        for (int i = 0; i < 26; i++) {
            if (cur[i] < target[i]) return false;
        }
        return true;
    }

}
