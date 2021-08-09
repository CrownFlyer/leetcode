package array;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-31 21:41
 */
public class LEETCODE_137_MIDDLE {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0;i<32;i++){
            int bit = 0;
            for(int num:nums){
                bit += (num >>i)&1;
            }
            res |= (bit % 3)<<i;
        }
        return res;
    }
}
