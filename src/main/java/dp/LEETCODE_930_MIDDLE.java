package dp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-08 23:13
 */
public class LEETCODE_930_MIDDLE {
    @Test
    public void test() {
        int[] nums = {0,0,0,0,0};
        int goal = 0;
        System.out.println(numSubarraysWithSum(nums, goal));
    }

    public int numSubarraysWithSum1(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        for (int num : nums) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += num;
            res += map.getOrDefault(sum - goal, 0);
        }
        return res;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int left1=0,left2=0,right = 0;
        int res = 0;
        int sum1 = 0,sum2 = 0;
        while(right<n){
            sum1 += nums[right];
            while(left1<=right&&sum1>goal){
                sum1-=nums[left1++];
            }
            sum2+=nums[right];
            while(left2<=right&&sum2>=goal){
                sum2-=nums[left2++];
            }
            res +=left2-left1;
            right++;
        }
        return res;
    }
}
