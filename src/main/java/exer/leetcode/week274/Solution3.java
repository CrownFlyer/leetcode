package exer.leetcode.week274;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-02 15:28
 */
public class Solution3 {
    public boolean asteroidsDestroyed(int mass, int[] as) {
        Arrays.sort(as);
        long cur = mass;
        for(int i = 0;i<as.length;i++){
            if(cur<as[i]) return false;
            cur+=as[i];
        }
        return true;
    }
}
