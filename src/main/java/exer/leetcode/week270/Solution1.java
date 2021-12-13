package exer.leetcode.week270;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-28 17:50
 */
public class Solution1 {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> res = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            if (digits[i] % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (digits[k] != 0 && i != j && i != k && j != k) {
                            res.add(digits[i] + digits[j] * 10 + digits[k] * 100);
                        }
                    }
                }
            }
        }
        int[] resa = new int[res.size()];
        int idx = 0;
        for (int num : res) {
            resa[idx++] = num;
        }
        Arrays.sort(resa);
        return resa;
    }
}
