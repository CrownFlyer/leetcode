package exer.leetcode.week272;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-19 11:56
 */
public class Solution1 {
    public String firstPalindrome(String[] words) {
        for(String w:words){
            if(check(w)) return w;
        }
        return "";
    }

    public boolean check(String s){
        int n = s.length();
        for(int i = 0;i<n/2;i++){
            if(s.charAt(i) != s.charAt(n - 1 -i)) return false;
        }
        return true;
    }
}
