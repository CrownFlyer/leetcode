package dp;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-08 15:52
 */
public class LEETCODE_975_HARD {
    @Test
    public void test(){
        int[] arr = {10,13,12,14,15};
        System.out.println(oddEvenJumps(arr));
    }
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        // 为true表示从arr[i]开始奇数次跳可以到达末尾
        boolean[] odd = new boolean[n];
        // 为true表示从arr[i]开始偶数次跳可以到达末尾
        boolean[] even = new boolean[n];
        odd[n - 1] = even[n - 1] = true;

        TreeMap<Integer, Integer> vals = new TreeMap<>();
        vals.put(arr[n - 1], n - 1);

        for (int i = n - 2; i >= 0; i--) {
            if (vals.containsKey(arr[i])) {
                odd[i] = even[vals.get(arr[i])];
                even[i] = odd[vals.get(arr[i])];
            } else {
                // 偶数次找最大的小于值
                Integer lower = vals.lowerKey(arr[i]);
                // 奇数次找最小的大于值
                Integer higher = vals.higherKey(arr[i]);
                even[i] = lower == null ? even[i] : odd[vals.get(lower)];
                odd[i] = higher == null ? odd[i] : even[vals.get(higher)];
            }
            vals.put(arr[i], i);
        }

        int res = 0;
        // 计数从第一次起跳，只计算奇数的可到达的
        for (int i = 0; i < n; i++) {
            if(odd[i]) res++;
        }
        return res;
    }
}
