package exer.leetcode.week258;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-12 10:27
 */
public class Section4 {
    @Test
    public void test() {
        int[] ps = {-1, 0, 0, 2};
        int[] ns = {1, 2, 3, 4};
        System.out.println(smallestMissingValueSubtree(ps, ns));
    }

    int n;
    int[] parent;
    int[] num;
    boolean[] exist;
    int[] res;
    int p = 1;
    // <k,v>:<parentNode,List<childNode>>
    Map<Integer, List<Integer>> edges;


    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        n = nums.length;
        parent = parents;
        num = nums;
        // 因为最大基因值为n+1
        exist = new boolean[n + 2];
        edges = new HashMap<>();
        res = new int[n];
        for (int i = 0; i < n; i++) {
            edges.putIfAbsent(parents[i], new ArrayList<>());
            edges.get(parents[i]).add(i);
        }
        // 标记完后，计算出不含1的子树的答案都是1，此时含1的子树答案还是0
        dfsAbout1(0);
        dfsRes(0);
        return res;
    }

    boolean dfsAbout1(int root) {
        List<Integer> children = edges.get(root);
        // f判断子树是否包含1
        boolean f = false;
        if (children != null) {
            for (Integer child : children) {
                f |= dfsAbout1(child);
            }
        }
        if (num[root] == 1) f = true;
        if (!f) res[root] = 1;
        return f;
    }

    void dfsRes(int root) {
        List<Integer> children = edges.get(root);
        if (children != null) {
            // 先递归处理含1的子树
            for (Integer child : children) {
                if (res[child] != 1)
                    dfsRes(child);
            }
            // 处理不含1的子树，记录当前子树内含有哪些数
            for (Integer child : children) {
                if (res[child] == 1)
                    dfsAdd(child);
            }
        }
        // 记录当前子树根节点的整数
        exist[num[root]] = true;
        // 寻找当前缺失的第一个整数
        while (exist[p])
            p++;
        res[root] = p;
    }

    void dfsAdd(int root) {
        exist[num[root]] = true;
        List<Integer> children = edges.get(root);
        if (children != null) {
            for (Integer child : children) {
                dfsAdd(child);
            }
        }
    }


}
