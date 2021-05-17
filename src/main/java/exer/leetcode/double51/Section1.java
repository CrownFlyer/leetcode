package exer.leetcode.double51;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-13 09:58
 */
public class Section1 {
    public static void main(String[] args) {
        String s = "a1c1e1";
        System.out.println(replaceDigits(s));
    }

    public static String replaceDigits(String s) {
        int n = s.length();
        char[] chars = new char[n];
        int i = 0;
        while(i<n){
            if(i%2==0) chars[i] = s.charAt(i);
            else{
                chars[i]=(char)(chars[i-1]+(int)(s.charAt(i)-'0'));
            }
            i++;
        }
        return String.valueOf(chars);
    }
}
