package exer.leetcode.jianhang;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-29 18:36
 */
public class Section3 {
    @Test
    public void test() {
        int[][] ls = {{4165, 8075, 3072, 6302, 3747, 3616, 1893}, {7431, 3616, 3747, 1893, 8075, 3219}, {3072, 6302, 3747}, {3616, 3969}, {7431, 3616}};
        int[] ints = metroRouteDesignI(ls, 4165, 3219);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] metroRouteDesignI(int[][] lines, int start, int end) {
        Map<List<Integer>, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            for (int j = 1; j < lines[i].length; j++) {
                map.computeIfAbsent(Arrays.asList(lines[i][j - 1], i), t -> new ArrayList<>()).add(lines[i][j]);
                map.computeIfAbsent(Arrays.asList(lines[i][j], i), t -> new ArrayList<>()).add(lines[i][j - 1]);
            }
        }
        // Map.Entry<k,v>: k:int[]{换乘次数，当前站编号，地铁线数}，v:路径字符串
        PriorityQueue<Pair<int[], String>> q = new PriorityQueue<>((x, y) -> x.getKey()[0] == y.getKey()[0] ? x.getValue().compareTo(y.getValue()) : x.getKey()[0] - y.getKey()[0]);
        // 由于站编号范围为10000以内 因此用5个字符记录一个站点即可
        q.offer(new Pair(new int[]{0, start, -1}, String.format("%05d", start)));
        for (Map<List<Integer>, String> set = new HashMap<>(); ; ) {
            Pair<int[], String> cur = q.poll();
            // 如果当前站编号等于终点，即找到最终的路径，由堆保证是换乘次数最少且字典序最小的路线
            if (cur.getKey()[1] == end) {
                String[] paths = cur.getValue().split(" ");
                int[] path = new int[paths.length];
                for (int i = 0; i < paths.length; i++) {
                    path[i] = Integer.parseInt(paths[i]);
                }
                return path;
            }
            // 如果有新的节点 或者重复的节点有更短的路径，才会对set进行更新
            else if (set.getOrDefault(Arrays.asList(cur.getKey()[1], cur.getKey()[2]), "").compareTo(cur.getValue()) < 0) {
                set.put(Arrays.asList(cur.getKey()[1], cur.getKey()[2]), cur.getValue());
                for (int i = 0; i < lines.length; i++) {
                    // 根据当前地铁站编号及地铁线数查找邻近节点
                    for (int e : map.getOrDefault(Arrays.asList(cur.getKey()[1], i), new ArrayList<>())) {
                        // 这里是对线路地铁编号去重
                        if (!cur.getValue().contains(String.format("%05d", e))) {
                            q.offer(new Pair(
                                    // 添加新的一个节点时，如果继续遍历该条线路，不应该增加换乘次数，且定位路径的开始位置时应保留原始位置，否则将位置向前定位5个字符
                                    new int[]{cur.getKey()[0] + (i == cur.getKey()[2] ? 0 : 1), e, i},
                                    cur.getValue() + String.format(" %05d", e)));
                        }
                    }
                }
            }
        }
    }


}

