package doublePointer;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-28 11:32
 */
public class LEETCODE_992_HARD {
    @Test
    public void test() {
        int[] nums = {1, 2, 1, 2, 3};
        System.out.println(subarraysWithKDistinct(nums, 2));
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostWithKDistinct(nums,k)-atMostWithKDistinct(nums,k-1);
    }

    public int atMostWithKDistinct(int[] A, int k) {
        int n = A.length;
        // 保证[l,r)之间为有效的
        int l = 0, r = 0;
        int[] cnt = new int[n + 1];
        // 优化判断条件，记录字符种类数
        int count = 0;
        int res = 0;
        while (r < n) {
            cnt[A[r]]++;
            if (cnt[A[r++]] == 1) count++;
            while (count > k) {
                cnt[A[l]]--;
                if (cnt[A[l++]] == 0) count--;
            }
            // 这里为什么是r-l：当选中一个连续子数组时，此时固定r，也即包含r的子数组个数为r-l
            // 由于遍历完所有的包含r的，保证了不重不漏
            res+=r-l;
        }
        return res;
    }
}
