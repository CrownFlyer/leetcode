package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-22 15:29
 */
public class LEETCODE_75_MIDDLE {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n < 2) return;

        // 定义[0,zero)是0，[zero,i)是1，[i,two)是2
        int zero = 0, two = n;
        int i = 0;
        while (i < two) {
            if (nums[i] == 0) swap(nums, i++, zero++);
            else if(nums[i]==1) i++;
            else swap(nums,i,--two);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
