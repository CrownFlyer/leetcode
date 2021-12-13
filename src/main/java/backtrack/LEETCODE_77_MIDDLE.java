package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-25 09:15
 */
public class LEETCODE_77_MIDDLE {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k, new ArrayList());
        return res;
    }

    public void dfs(int cur, int n, int k, List<Integer> list) {
        // 剪枝
        if (list.size() + (n - cur + 1) < k) return;

        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 考虑选择当前位置
        list.add(cur);
        dfs(cur + 1, n, k, list);
        list.remove(cur - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k, list);
    }

}
