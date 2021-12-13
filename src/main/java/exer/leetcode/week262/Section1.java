package exer.leetcode.week262;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-10 10:24
 */
public class Section1 {
    @Test
    public void test() {

    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        for (int n1 : nums1) {
            set1.add(n1);
        }
        for (int n1 : nums2) {
            set2.add(n1);
        }
        for (int n1 : nums3) {
            set3.add(n1);
        }

        int[] cnt = new int[101];
        for (Integer n1 : set1) {
            cnt[n1]++;
        }
        for (Integer n1 : set2) {
            cnt[n1]++;
        }
        for (Integer n1 : set3) {
            cnt[n1]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            if (cnt[i] >= 2) res.add(i);
        }
        return res;

    }

}
