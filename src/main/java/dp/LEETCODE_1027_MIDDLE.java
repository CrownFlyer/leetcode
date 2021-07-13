package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinTask;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-10 10:39
 */
public class LEETCODE_1027_MIDDLE {
    @Test
    public void test() {
        int[] nums = {3,6,9,12};
        System.out.println(longestArithSeqLength(nums));
    }

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        // key:表示等差序列的第一个下标，value:用于存储该元素不同的公差所包含的最长序列
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
            for (int j = i - 1; j >= 0; j--) {
                // 如果遇到了重复的元素，可以直接跳过，因为肯定不会比后面的元素组成更长的序列
                if (map.get(i).containsKey(nums[i] - nums[j])) continue;
                // 获取以这两个元素之间的差值为公差的最长序列长度
                int cur = map.get(j).getOrDefault(nums[i] - nums[j], 0);
                max = Math.max(max, cur + 2);
                map.get(i).put(nums[i] - nums[j], cur + 1);
            }
        }
        return max;
    }
}
