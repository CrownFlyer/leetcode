package exer.leetcode.double69;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-09 16:20
 */
public class Solution3 {
    public int longestPalindrome(String[] words) {
        int res = 0;
        boolean same = false;
        Map<String,Integer> map = new HashMap<>();
        for(String word:words){
            char[] newchar = new char[2];
            newchar[0] = word.charAt(1);
            newchar[1] = word.charAt(0);
            String newStr = new String(newchar);
            if(map.containsKey(newStr)){
                int cnt = map.get(newStr);
                map.put(newStr,cnt-1);
                if(cnt==1) map.remove(newStr);
                res += 4;
            }else {
                map.put(word,map.getOrDefault(word,0)+1);
            }
        }
        for(String key:map.keySet()){
            if(key.charAt(0)==key.charAt(1)){
                res += 2;
                break;
            }

        }
        return res;
    }
}
