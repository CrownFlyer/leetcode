package greedy;

import sun.reflect.generics.tree.Tree;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-09 20:11
 */
public class LEETCODE_1578_MIDDLE {
    public static void main(String[] args) {
        String s = "aabaa";
        int[] costs = {1, 2, 3, 4, 1};
        System.out.println(minCost(s, costs));
    }

    public static int minCost(String s, int[] cost) {
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            int tempMax = 0;
            int tempRes = 0;

            while (i < s.length() && s.charAt(i) == ch) {
                tempMax = Math.max(tempMax, cost[i]);
                tempRes += cost[i];
                i++;
            }
            res += (tempRes - tempMax);
        }
        return res;
    }
}
