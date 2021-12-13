package exer.test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-01 10:42
 */
public class LEETCODE_575_SIMPLE {
    // 假设糖果种类有m种，糖果数为n，则分配给A的糖果种数最多不超过n/2和m，如果m>n/2，则表明糖果种类足够，最多为n/2，如果m<n/2，则表明种类少，最多只能分配m
    // 综合Math.min(m,n/2)
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<Integer>();
        for (int candy : candyType) {
            set.add(candy);
        }
        return Math.min(set.size(), candyType.length / 2);
    }

    // 模拟
    public int distributeCandies1(int[] candyType) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int candy : candyType)
            map.put(candy, map.getOrDefault(candy, 0) + 1);
        int[][] arr = new int[map.size()][2];
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        for (int i = 0; i < map.size(); i++) {
            Map.Entry<Integer, Integer> next = it.next();
            arr[i][0] = next.getValue();
            arr[i][1] = next.getKey();
        }
        Arrays.sort(arr, (x, y) -> y[0] - x[0]);
        int n = candyType.length >> 1;
        int cnt = 0;
        int idx = 0;
        while (idx < arr.length && cnt < n)
            cnt += arr[idx++][0] - 1;
        if (cnt >= n) return n;
        else {
            idx = 0;
            while (cnt < n)
                cnt += arr[idx++][0] - 1;
            return arr.length - idx;
        }
    }
}
