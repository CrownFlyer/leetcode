package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-22 16:33
 */
public class LEETCODE_643_SIMPLE {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int i =0;i<k;i++){
            sum += nums[i];
        }
        double max = (double)sum/k;

        for(int i=k;i<n;i++){
            sum += nums[i]-nums[i-k];
            max = Math.max(max,(double)sum/k);
        }
        return max;
    }
}
