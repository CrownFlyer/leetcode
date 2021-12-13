package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-25 08:21
 */
public class LEETCODE_39_MIDDLE {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList());
        return res;
    }

    public void dfs(int[] candidates, int cur, int idx, List<Integer> list) {
        if (idx == candidates.length) return;
        if (cur == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        dfs(candidates, cur, idx + 1, list);
        if (cur - candidates[idx] >= 0) {
            list.add(candidates[idx]);
            dfs(candidates, cur - candidates[idx], idx, list);
            list.remove(list.size() - 1);
        }
    }
}
