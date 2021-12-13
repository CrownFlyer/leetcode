package exer.leetcode.week261;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-03 12:13
 */
public class Section1 {
    @Test
    public void test() {

    }

    public int minimumMoves(String s) {
        int n = s.length();
        int i = 0;
        int res = 0;
        while(i<n){
            if(s.charAt(i) == 'X'){
                res++;
                i += 3;
            }else i++;
        }
        return res;
    }
}
