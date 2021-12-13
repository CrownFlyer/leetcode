package exer.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-22 10:44
 */
public class LEETCODE_229_MIDDLE {
    // HashMap:O(n) O(n)
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() > nums.length / 3) res.add(entry.getKey());
        return res;
    }

    // 摩尔投票:O(n) O(1)
    public List<Integer> majorityElement1(int[] nums) {
        int element1 = 0, element2 = 0;
        int vote1 = 0, vote2 = 0;

        for (int num : nums) {
            if (vote1 > 0 && num == element1) vote1++;
            else if (vote2 > 0 && num == element2) vote2++;
            else if (vote1 == 0) {
                element1 = num;
                vote1++;
            } else if (vote2 == 0) {
                element2 = num;
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }

        // 选出之后再检测一次
        int cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (num == element1) cnt1++;
            else if (num == element2) cnt2++;
        }

        List<Integer> res = new ArrayList<>();
        if (cnt1 > nums.length / 3) res.add(element1);
        if (cnt2 > nums.length / 3) res.add(element2);
        return res;
    }
}
