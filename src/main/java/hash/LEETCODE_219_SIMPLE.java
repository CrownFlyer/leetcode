package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-31 21:42
 */
public class LEETCODE_219_SIMPLE {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            if(set.size()>k) set.remove(nums[i-k]);
        }
        return false;
    }
}
