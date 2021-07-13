package binarysearch;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-12 11:18
 */
public class LEETCODE_275_MIDDLE {
    @Test
    public void test() {
        int[] arr = {100};
        System.out.println(hIndex(arr));
    }

    public int hIndex(int[] cs) {
        int n = cs.length;
        int l = 0, r = n;

        while (l < r) {
            // 由于l端是不变的，要退出循环条件，必须将h往右靠
            int h = l + (r - l + 1) / 2;
            // 满足条件 缩小空间且不排除正确答案，这里保证l为正确答案
            if (cs[n - h] >= h) l = h;
            else r = h - 1;
        }
        // h表示满足索引树
        // 这里的判断条件为：cs[n-h]保证有n-h个元素满足条件，如果这n-h个元素中最小的都满足，则所有的都满足
        return l;
    }
}
