package exer.leetcode.week241;

import java.util.ArrayList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-16 09:55
 */
public class Section2 {
    public static void main(String[] args) {
        String s = "0101101";
        System.out.println(minSwaps(s));
    }

    public static int minSwaps(String s) {
        char[] chars = s.toCharArray();
        int[] cnt = new int[2];
        for (char c : chars) {
            cnt[c-'0']++;
        }
        if(Math.abs(cnt[0]-cnt[1])>1) return -1;

        int res;
        if(cnt[0]==cnt[1]){
            res=Math.min(getSum(chars,'0'),getSum(chars,'1'));
        }else {
            char ch = cnt[0]>cnt[1]?'0':'1';
            res = getSum(chars,ch);
        }
        return res;
    }

    public static int getSum(char[] chars,char ch){
        int res  = 0;
        for (int i = 0; i < chars.length; i+=2) {
            if(chars[i]!=ch) res++;
        }
        return res;
    }
}
