package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.OptionalInt;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-03 15:03
 */
public class LEETCODE_743_MIDDLE {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
//        int[][] times = {{1,2,1}};
        LEETCODE_743_MIDDLE test = new LEETCODE_743_MIDDLE();
        System.out.println(test.networkDelayTime(times, 4, 2));
    }

    HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
    int time = 0;
    int cnt = 0;
    public int networkDelayTime(int[][] times, int n, int k) {
        for (int[] tmp : times) {
            ArrayList list = new ArrayList();
            list.add(tmp[1]);
            list.add(tmp[2]);
            ArrayList<ArrayList<Integer>> tmpList = map.getOrDefault(tmp[0], new ArrayList<>());
            tmpList.add(list);
            map.put(tmp[0], tmpList);
        }

        time += dfs(k);
        if(cnt!=n) return -1;
        return time;
    }

    public int dfs(int k) {
        ArrayList<ArrayList<Integer>> list = map.get(k);
        cnt++;
        if (list == null) return 0;
        int n = list.size();
        int[] tempTime = new int[n];
        for (int i = 0; i < n; i++) {
            tempTime[i] = dfs(list.get(i).get(0))+list.get(i).get(1);
        }
        OptionalInt max = Arrays.stream(tempTime).max();
        return max.getAsInt();
    }


}
