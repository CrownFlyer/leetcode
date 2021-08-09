package hash;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-31 21:42
 */
public class LEETCODE_217_SIMPLE {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]) return true;
        }
        return false;
    }
}
