package array;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-04 18:14
 */
public class LEETCODE_53_SIMPLE {
    public static void main(String[] args) {
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        LEETCODE_53_SIMPLE test = new LEETCODE_53_SIMPLE();
        System.out.println(test.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int temp = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            temp+=nums[i];
            res = Math.max(temp,res);
            temp = temp<0?0:temp;
        }
        return res;
    }
}
