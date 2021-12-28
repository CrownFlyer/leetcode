package exer.leetcode.double65;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-15 11:09
 */
public class Solution1 {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for(int i = 0;i<word1.length();i++){
            cnt1[word1.charAt(i)-'a']++;
        }
        for(int i = 0;i<word2.length();i++){
            cnt2[word2.charAt(i)-'a']++;
        }
        for(int i = 0;i<26;i++){
            if(Math.abs(cnt1[i] - cnt2[i]) > 3) return false;
        }
        return true;
    }
}
