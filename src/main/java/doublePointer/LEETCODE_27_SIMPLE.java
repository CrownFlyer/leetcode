package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-21 16:37
 */
public class LEETCODE_27_SIMPLE {

    public int removeElement(int[] nums, int val) {
        int n = nums.length;

        // 保证[0,l) 都是移除元素后的有效元素
        int l = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] != val) nums[l++] = nums[r];
        }
        return l;
    }
}
