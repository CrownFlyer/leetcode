package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-21 20:34
 */
public class LEETCODE_80_MIDDLE {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n<=2) return n;

        int l = 2,r = 2;
        while (r < n) {
            if(nums[l-2] != nums[r]){
                nums[l++] = nums[r];
            }
            r++;
        }
        return l;
    }
}
