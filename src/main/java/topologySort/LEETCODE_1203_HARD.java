package topologySort;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-29 20:04
 */
public class LEETCODE_1203_HARD {
    @Test
    public void test() {

    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // 根据组和项目分别进行拓扑排序!!
        // 1、数据预处理，给没有归属的项目编上组号
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) group[i] = m++;
        }
        // 2、建立组和项目的邻接表
        List<Integer>[] groupAdj = new ArrayList[m];
        List<Integer>[] itemAdj = new ArrayList[n];
        for (int i = 0; i < m; i++) {
            groupAdj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            itemAdj[i] = new ArrayList<>();
        }

        // 3、构建图和统计入度数组
        int[] groupsIndegree = new int[m];
        int[] itemsIndegree = new int[n];
        for (int i = 0; i < group.length; i++) {
            int currentGroup = group[i];
            for (Integer beforeItem : beforeItems.get(i)) {
                int beforeGroup = group[beforeItem];
                // 只有不相同的组才需要进行拓扑排序
                if (beforeGroup != currentGroup) {
                    // 前继添加后继！
                    groupAdj[beforeGroup].add(currentGroup);
                    groupsIndegree[currentGroup]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (Integer item : beforeItems.get(i)) {
                itemAdj[item].add(i);
                itemsIndegree[i]++;
            }
        }

        // 4、得到组和项目的拓扑排序结果
        List<Integer> groupList = topologicalSort(groupAdj, groupsIndegree, m);
        if (groupList.size() == 0) return new int[0];
        List<Integer> itemList = topologicalSort(itemAdj, itemsIndegree, n);
        if (itemList.size() == 0) return new int[0];

        // 5、根据项目的拓扑排序结果，项目到组的多对一关系，建立到组到项目的一对多关系
        // key:group value:同一组的项目列表
        Map<Integer, List<Integer>> groups2Items = new HashMap<>();
        for (Integer item : itemList) {
            groups2Items.computeIfAbsent(group[item], key -> new ArrayList<>()).add(item);
        }

        // 6、把组的拓扑排序结果替换为项目的拓扑排序结果
        List<Integer> res = new ArrayList<>();
        for (Integer groupId : groupList) {
            List<Integer> items = groups2Items.getOrDefault(groupId, new ArrayList<>());
            res.addAll(items);
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    private List<Integer> topologicalSort(List<Integer>[] adj, int[] indegree, int n) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            Integer front = q.poll();
            res.add(front);
            for (Integer successor : adj[front]) {
                if (--indegree[successor] == 0) q.offer(successor);
            }
        }
        // 存在环
        if (res.size() != n) return new ArrayList<>();
        return res;
    }
}
