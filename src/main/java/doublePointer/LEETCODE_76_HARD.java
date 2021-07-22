package doublePointer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-02 11:45
 */
public class LEETCODE_76_HARD {
    public static void main(String[] args) {
        LEETCODE_76_HARD test = new LEETCODE_76_HARD();
        System.out.println(test.minWindow("ADOBECODEBANC", "ABC"));
    }

    Map<Character, Integer> dst = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            dst.put(c, dst.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int resL = -1, resR = -1;
        int minLen = Integer.MAX_VALUE;
        while (r < sLen) {
            r++;
            if (r < sLen && dst.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    resL = l;
                    resR = l + minLen;
                }
                if (dst.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.get(s.charAt(l)) - 1);
                }
                l++;
            }
        }
        return resL == -1 ? "" : s.substring(resL, resR);
    }
    public boolean check() {
        Iterator<Map.Entry<Character, Integer>> iter = dst.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Character, Integer> entry = iter.next();
            Character k = entry.getKey();
            Integer v = entry.getValue();
            if (cnt.getOrDefault(k, 0) < v) return false;
        }
        return true;
    }

    // ----------------------------------------------------
    Map<Character,Integer> cur = new HashMap<>();
    Map<Character,Integer> target = new HashMap<>();

    public String minWindow1(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        if(sLen<tLen) return "";

        for (int i = 0; i < tLen; i++) {
            target.put(t.charAt(i),target.getOrDefault(t.charAt(i),0)+1);
        }

        int len = sLen+1;
        String res = "";
        int l = 0,r = 0;
        boolean f = false;
        while(r<sLen){
            cur.put(s.charAt(r),cur.getOrDefault(s.charAt(r++),0)+1);
            while (check1(cur,target)){
                cur.put(s.charAt(l),cur.get(s.charAt(l++))-1);
                f = true;
            }
            if(f&&r-l+1<len) {
                res = s.substring(l-1,r);
                len = r-l+1;
                f = false;
            }
        }
        return res;
    }

    public boolean check1(Map<Character,Integer> cur,Map<Character,Integer> target){
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            if(cur.getOrDefault(entry.getKey(),0)<entry.getValue()) return false;
        }
        return true;
    }

}
