package exer.leetcode.lcp;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-25 14:54
 */
public class LCP_48_HARD {
    @Test
    public void test() {
        int[][] ps = {{0, 0, 0}, {0, 6, 0}, {1, 1, 0}, {1, 5, 0}, {3, 0, 1}, {3, 1, 1}, {3, 2, 1}, {3, 4, 1}, {4, 2, 0}, {4, 4, 0}};
        System.out.println(gobang(ps));
    }

    public String gobang(int[][] pieces) {
        // 这里并非上下左右，而是横竖，左上左下四个方向
        int[][] dirs = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}};
        // Pair重写了equals方法，代替了很多int[]的场景
        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        for (int[] piece : pieces) map.put(new Pair<>(piece[0], piece[1]), piece[2]);
        Set<List<Pair<Integer, Integer>>>[] svp = new HashSet[2];
        for (int i = 0; i < 2; i++) {
            svp[i] = new HashSet<>();
        }
        for (int[] piece : pieces) {
            int x = piece[0], y = piece[1], z = piece[2];
            for (int d = 0; d < 4; d++) {
                // 对于每个方向遍历起始点
                for (int s = -4; s <= 0; s++) {
                    List<Integer> w = new ArrayList<>();
                    // 按该方向数5个点
                    for (int i = 0; i < 5; i++) {
                        int nx = x + dirs[d][0] * (i + s);
                        int ny = y + dirs[d][1] * (i + s);
                        w.add(map.getOrDefault(new Pair<>(nx, ny), -1));
                    }
                    boolean res = true;
                    int blank = 0;
                    for (int i = 0; i < 5; i++) {
                        if (w.get(i) == -1) blank++;
                        else if (w.get(i) != z) res = false;
                    }
                    // 如果有另外的棋子，直接continue
                    if (!res) continue;
                    // 空格数不能超过2，即2步之内必须获胜
                    if (blank <= 2) {
                        // 记录下还差两步胜利的空格坐标
                        List<Pair<Integer, Integer>> u = new ArrayList<>();
                        for (int i = 0; i < 5; i++) {
                            if (w.get(i) == -1) {
                                int nx = x + dirs[d][0] * (i + s);
                                int ny = y + dirs[d][1] * (i + s);
                                u.add(new Pair<>(nx, ny));
                            }
                        }
                        svp[z].add(u);
                    }
                }
            }
        }
        // 黑棋先手，如果黑棋有只差一步获胜的，黑棋赢
        for (List<Pair<Integer, Integer>> vp : svp[0]) {
            if (vp.size() == 1) return "Black";
        }

        // 记录白棋还有一次赢的坐标个数，不会出现重复的，因为Set<List<Pair>> 由于Pair重写了equals方法，有效去重
        int w = 0;
        // 记录白棋还差一步赢的坐标
        Pair<Integer, Integer> p = null;
        for (List<Pair<Integer, Integer>> vp : svp[1]) {
            if (vp.size() == 1) {
                w++;
                p = vp.get(0);
            }
        }

        // 如果黑棋不能一步获胜，白棋有不止一个只差一步获胜的坐标，白棋胜
        if (w > 1) return "White";

        // 如果双方都不能第一步获胜，则最多看黑棋能不能获胜
        // 寻找黑棋有能连接两条边的坐标
        Map<Pair<Integer, Integer>, Integer> cnt = new HashMap<>();
        for (List<Pair<Integer, Integer>> vp : svp[0]) {
            for (Pair<Integer, Integer> p1 : vp) {
                cnt.put(p1, cnt.getOrDefault(p1, 0) + 1);
            }
        }

        // 如果黑棋能有效连接两条边且白棋没有要获胜的（或者要获胜的点被黑棋的交叉点正好占了），此时只能围堵黑棋的棋子，但围堵不过来,黑棋胜
        // 否则黑棋不能有效进攻或者只能第一步围堵白棋的快要赢的那一步，但双方都不能获胜，返回"None"
        for (Map.Entry<Pair<Integer, Integer>, Integer> entry : cnt.entrySet()) {
            // 注意 这里用equals
            if (entry.getValue() > 1 && (w == 0 || p.equals(entry.getKey()))) return "Black";
        }
        return "None";
    }


}
