package exer.leetcode.double63;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-15 19:03
 */
public class Solution2 {
    public boolean winnerOfGame(String colors) {
        int cntA = 0,cntB = 0;
        for(int i = 1;i<colors.length() - 1;i++){
            if(colors.charAt(i) == 'A' && colors.charAt(i-1) == 'A' && colors.charAt(i+1) == 'A') cntA++;
            else if(colors.charAt(i) == 'B' && colors.charAt(i-1) == 'B' && colors.charAt(i+1) == 'B') cntB++;
        }
        return cntA > cntB;
    }
}
