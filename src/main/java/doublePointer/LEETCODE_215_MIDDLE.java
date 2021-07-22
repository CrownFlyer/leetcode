package doublePointer;

import java.util.Random;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-22 15:50
 */
public class LEETCODE_215_MIDDLE {
    private static Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // 第k大元素的下标
        int target = n - k;
        int l = 0, r = n - 1;
        while (true) {
            int pIndex = partition(nums, l, r);

            if (pIndex == target) return nums[pIndex];
            else if (pIndex < target) l = pIndex + 1;
            else r = pIndex - 1;
        }


    }

    private int partition(int[] nums, int l, int r) {
        int randomIndex = l + random.nextInt(r - l + 1);
        swap(nums, l, randomIndex);

        int pivot = nums[l];
        // [left+1,le] <= pivot
        // (le,i] > pivot
        int le = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] <= pivot) swap(nums, ++le, i);
        }
        swap(nums, le, l);
        return le;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
