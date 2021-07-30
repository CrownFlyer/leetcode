package doublePointer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-26 11:01
 */
public class LEETCODE_1713_HARD {
    @Test
    public void test() {
        int[] t = {16, 7, 20, 11, 15, 13, 10, 14, 6, 8};
        int[] arr = {11, 14, 15, 7, 5, 5, 6, 10, 11, 6};
        System.out.println(minOperations(t, arr));
    }

    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = target.length;
        for (int i = 0; i < n; i++) {
            map.put(target[i], i);
        }
        int len = arr.length;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Integer e = map.get(arr[i]);
            if (e != null) list.add(e);
        }
        int size = list.size();
        int[] index = new int[size];
        for (int i = 0; i < size; i++) {
            index[i] = list.get(i);
        }
        return n - lengthOfLIS(index);
    }

    public int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        // d[i]:表示长度为 i 的最长上升子序列的末尾元素的最小值
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) { // 如果通过则说明新的元素可以替换
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];   //将新的元素放入到对应的位置
            }
        }
        return len;
    }
}
