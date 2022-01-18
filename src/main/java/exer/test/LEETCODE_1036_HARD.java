package exer.test;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-11 11:01
 */
public class LEETCODE_1036_HARD {
    @Test
    public void test() {
        int[][] bs = {{0,999991},{0,999993},{0,999996},{1,999996},{1,999997},{1,999998},{1,999999}};
        int[] s = {0,999997};
        int[] t = {0, 2};
        System.out.println(isEscapePossible(bs, s, t));
    }

    int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int MAX;
    long BASE = (long) 10e5;
    Set<Long> blk = new HashSet<>();

    public boolean isEscapePossible(int[][] blocked, int[] s, int[] t) {
        int n = blocked.length;
        MAX = n * (n - 1) / 2;
        for (int[] pos : blocked)
            blk.add(BASE * pos[0] + pos[1]);
        // 总共
        //  1.两个点都没有束缚->都能走超过MAX的步数
        //  2.两个点存在有束缚->都在有限的步数内判断
        return check(s, t) && check(t, s);
    }

    boolean check(int[] a, int[] b) {
        Deque<int[]> q = new LinkedList<>();
        q.offer(a);
        Set<Long> v = new HashSet<>();
        while (!q.isEmpty() && v.size() <= MAX) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == b[0] && cur[1] == b[1]) return true;
                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dirs[j][0], ny = cur[1] + dirs[j][1];
                    long hash = BASE * nx + ny;
                    if (nx >= 0 && nx < BASE && ny >= 0 && ny < BASE
                            && !blk.contains(hash) && !v.contains(hash)) {
                        // 如果在有限步数内遍历到，则表示可达
                        v.add(hash);
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        // 如果双方都能走无限步，则也能可达
        return v.size() > MAX;
    }

}
