package exer.leetcode.week251;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-25 15:43
 */
public class Section3 {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length, n = students[0].length;
        int maxScore = 0;
        int[] order = new int[m];
        for (int i = 0; i < m; i++) {
            order[i] = i;
        }
        List<List<Integer>> list = permute(order);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int temp = 0;
            List<Integer> o = list.get(i);
            for (int j = 0; j < m; j++) {
                temp += score(students[o.get(j)], mentors[j]);
            }
            maxScore = Math.max(maxScore, temp);
        }
        return maxScore;
    }

    public int score(int[] s, int[] t) {
        int n = s.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += s[i] == t[i] ? 1 : 0;
        }
        return res;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();

        for (int num : nums) output.add(num);

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;

    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if (first == n) res.add(new ArrayList<Integer>(output));
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}
