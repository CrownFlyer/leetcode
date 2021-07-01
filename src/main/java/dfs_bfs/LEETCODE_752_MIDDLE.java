package dfs_bfs;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-30 21:22
 */
public class LEETCODE_752_MIDDLE {
    @Test
    public void test() {
    }

    public int openLock(String[] deadends, String target) {
        String start = "0000";
        HashSet<String> set = new HashSet<>();
        for (String deadend : deadends) set.add(deadend);
        if (set.contains(start)) return -1;
        if (start.equals(target)) return 0;

        int[] dir = {-1, 1};
        // 记录总的遍历过的
        Set<String> visited = new HashSet<>();

        // 记录左右bfs
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(start);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(target);

        int step = 0;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            // 用小的集合来bfs
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            // 现在beginVisited为小的集合
            Set<String> nextVisited = new HashSet<>();
            for (String cur : beginVisited) {
                char[] chars = cur.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char origin = chars[i];
                    int num = chars[i] - '0';
                    for (int j = 0; j < 2; j++) {
                        int next = num + dir[j];
                        switch (next) {
                            case 10:
                                chars[i] = '0';
                                break;
                            case -1:
                                chars[i] = '9';
                                break;
                            default:
                                chars[i] = (char) (next + '0');
                                break;
                        }

                        String newGene = new String(chars);
                        if (!set.contains(newGene) && !visited.contains(newGene)) {
                            nextVisited.add(newGene);
                            visited.add(newGene);
                        }
                        if (endVisited.contains(newGene)) return step + 1;
                    }
                    chars[i] = origin;
                }
            }
            step++;
            beginVisited = nextVisited;
        }
        return -1;
    }

}
