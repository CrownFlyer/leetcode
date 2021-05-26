package binarysearch;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-25 17:18
 */
public class LEETCODE_34_MIDDLE {
    public static void main(String[] args) {
        int[] arr = {3,4,5,5,5,5,5,6,7};
        for (int i : searchRange(arr, 5)) {
            System.out.println(i);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[]{-1, -1};

        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1; // 向下取整，往左收敛
            if (nums[mid] >= target) r = mid;   // 往左收敛，所以一定是找到第一个target
            else l = mid + 1;
        }
        if(nums[l]!=target) return new int[]{-1, -1};

        int lend = l, rend = l;
        while (lend >= 0 && nums[lend] == target) lend--;
        while (rend < n && nums[rend] == target) rend++;
        return new int[]{lend+1,rend-1};
    }
}
