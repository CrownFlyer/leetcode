package backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-29 16:42
 */
public class LEETCODE_40_MIDDLE {
    @Test
    public void test() {
        int[] cs = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(cs, 8));
    }

    List<int[]> freq = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates) {
            if (freq.isEmpty() || num != freq.get(freq.size() - 1)[0])
                freq.add(new int[]{num, 1});
            else
                freq.get(freq.size() - 1)[1]++;
        }
        dfs(0,target);
        return res;
    }

    public void dfs(int pos, int rest) {
        if (rest == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (pos == freq.size() || rest < freq.get(pos)[0]) return;

        // 不新添加pos的值
        dfs(pos + 1, rest);

        // 根据可选的个数和剩余可选的个数取最小值
        int end = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= end; i++) {
            cur.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }

        for (int i = 1; i <= end; i++) {
            cur.remove(cur.size() - 1);
        }
    }
}
