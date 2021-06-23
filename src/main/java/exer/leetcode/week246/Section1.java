package exer.leetcode.week246;

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
        String s = "52";
        System.out.println(test.largestOddNumber(s));
    }

    public String largestOddNumber(String num) {
        int n = num.length();
        for (int i = n-1; i >= 0; i--) {
            char c = num.charAt(i);
            if((c-'0')%2==1) {
                int index = 0;
                while(num.charAt(index)=='0') index++;
                return num.substring(index,i+1);
            }
        }
        return "";
    }
}
