package doublePointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-31 10:04
 */
public class LEETCODE_987_HARD {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> list = new ArrayList<>();
        dfs(list, root, 0, 0);
        Collections.sort(list, (x, y) -> {
            if (x[1] != y[1]) return x[1] - y[1];
            else if (x[2] != y[2]) return y[2] - x[2];
            else return x[0] - y[0];
        });
        List<List<Integer>> res = new ArrayList<>();
        int size = list.size();
        int i = 0;
        int cur = list.get(0)[1];
        List<Integer> temp = new ArrayList<>();
        while (i < size) {
            if (list.get(i)[1] == cur) temp.add(list.get(i)[0]);
            else {
                res.add(temp);
                temp = new ArrayList<>();
                cur = list.get(i)[1];
                temp.add(list.get(i)[0]);
            }
            i++;
        }
        res.add(temp);
        return res;
    }

    public void dfs(List<int[]> list, TreeNode node, int cur, int layer) {
        if (node == null) return;
        list.add(new int[]{node.val, cur, layer});
        dfs(list, node.left, cur - 1, layer - 1);
        dfs(list, node.right, cur + 1, layer - 1);
    }
}
