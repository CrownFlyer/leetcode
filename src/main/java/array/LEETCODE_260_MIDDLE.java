package array;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-31 21:41
 */
public class LEETCODE_260_MIDDLE {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for(int num:nums){
            res ^= num;
        }

        int div = 1;
        while((div&res)==0) div<<=1;

        int num1 = 0,num2 =0;
        for(int num:nums){
            if((div&num)!=0) num1 ^= num;
            else num2 ^= num;
        }
        return new int[]{num1,num2};
    }
}
