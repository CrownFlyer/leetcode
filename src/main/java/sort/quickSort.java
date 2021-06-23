package sort;

import java.util.Random;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-17 21:27
 */
public class quickSort {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1, 0, -3, -9};
        quickSort test = new quickSort();
        test.quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    Random random = new Random();

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int pivot = l + random.nextInt(r - l + 1);
        // 将基准值放到最后
        swap(nums, pivot, r);
        // 定义快慢指针
        int i = l - 1;
        for (int j = l; j < r; j++) {
            // 大于基准值的就跳过，一会会交换
            if (nums[j] <= nums[r]) swap(nums, ++i, j);
        }
        // i及i之前的都保证小于基准值，因此将基准值放到i+1处
        swap(nums, i + 1, r);
        // 除了基准值i+1的位置确定，其他的都没确定，递归
        quickSort(nums, l, i);
        quickSort(nums, i + 2, r);
    }

    public void swap(int[] nums, int i, int j) {
        // 如果引用相同，异或之后为0
        if (i == j) return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
