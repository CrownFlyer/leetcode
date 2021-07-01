package dfs_bfs;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-30 20:54
 */
public class LEETCODE_433_MIDDLE {
    @Test
    public void test() {
        String s = "AACCGGTT";
        String e = "AACCGGTT";
        String[] b = {};
        System.out.println(minMutation(s, e, b));
    }

    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>();
        for (String s : bank) set.add(s);
        if(start.equals(end)) return 0;
        if (set.size() == 0 || !set.contains(end)) return -1;

        char[] lib = {'A', 'C', 'G', 'T'};

        // 记录总的遍历过的
        Set<String> visited = new HashSet<>();

        // 记录左右bfs
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(start);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(end);

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
                    for (int j = 0; j < 4; j++) {
                        chars[i] = lib[j];
                        String newGene = new String(chars);
                        if (set.contains(newGene) && !visited.contains(newGene)) {
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
