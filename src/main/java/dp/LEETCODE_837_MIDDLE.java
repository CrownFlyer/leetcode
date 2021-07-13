package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-10 10:39
 */
public class LEETCODE_837_MIDDLE {
    public int lenLongestFibSubseq(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);

        int n = nums.length;
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                int x = nums[i],y=nums[i]+nums[j];
                int cnt = 2;
                while(set.contains(x+y)){
                    int temp = y;
                    y+=x;
                    x = temp;
                    cnt++;
                }
                max = Math.max(max,cnt);
            }
        }
        return max>=3?max:0;
    }
}
