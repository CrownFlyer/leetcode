package exer.leetcode.week255;

import org.junit.Test;

import java.util.TreeMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-22 10:26
 */
public class Section4 {
    @Test
    public void test() {
        int[] sums = {-3,-2,-1,0,0,1,2,3};
        recoverArray(3,sums);
    }

    public int[] recoverArray(int n, int[] sums) {
        int bias = 0;
        for (int sum : sums) {
            bias = Math.min(bias, sum);
        }
        bias = -bias;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int sum : sums) {
            // 首先我们可以理解为将所有的负数转换为正数，之后再根据bias将求得的数转为负数
            map.merge(sum + bias, 1, Integer::sum);
        }

        int[] res = new int[n];
        // 首先去除一个空集
        int first = map.firstKey();
        map.put(first, map.get(first) - 1);
        if (map.get(first) == 0) map.remove(first);

        res[0] = map.firstKey();
        for (int i = 1; i < n; i++) {
            // 删除只由最小的i个元素组成的子集
            for (int mask = 0; mask < (1 << i); mask++) {
                if (((mask >>> (i - 1)) & 1) != 0) {    // 前i个元素组成的带有res[i-1]的掩码
                    int sum = 0;
                    for (int j = 0; j < i; j++) {   // 求由该掩码组成的元素子集和
                        if (((mask >>> j) & 1) != 0) sum += res[j];
                    }
                    map.put(sum, map.get(sum) - 1);
                    if (map.get(sum) == 0) map.remove(sum);
                }
            }
            res[i] = map.firstKey();
        }

        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (((i >>> j) & 1) != 0) sum += res[j];
            }
            if (sum == bias) {
                for (int j = 0; j < n; j++) {
                    if (((i >>> j) & 1) != 0) res[j] = -res[j];
                }
                break;
            }
        }

        return res;
    }


}
