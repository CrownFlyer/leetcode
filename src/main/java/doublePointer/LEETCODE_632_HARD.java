package doublePointer;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-01 14:48
 */
public class LEETCODE_632_HARD {
    public static void main(String[] args) {
        LEETCODE_632_HARD test = new LEETCODE_632_HARD();
        int[][] nums = {{4, 10, 15, 24, 26}, {0, 9, 12, 20}, {5, 18, 22, 30}};
//        int[][] nums = {{2, 3}, {1, 2, 3}, {1, 2, 3}};
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int integer : nums[i]) {
                temp.add(integer);
            }
            list.add(temp);
        }
        int[] res = test.smallestRange(list);
        Arrays.stream(res).forEach(System.out::println);
    }

    public int[] smallestRange1(List<List<Integer>> nums) {
        int rangeLeft = 0, rangeRight = Integer.MAX_VALUE;
        int minRange = rangeRight - rangeLeft;
        int max = 0;
        int size = nums.size();
        int[] next = new int[size];
        // 这里维护一个小顶锥是因为让堆中包含所有列表的一个元素，这里是小顶锥的原因是要使得区间尽可能的小
        PriorityQueue<Integer> q = new PriorityQueue<>((x, y) -> nums.get(x).get(next[x]) - nums.get(y).get(next[y]));
        for (int i = 0; i < size; i++) {
            q.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        while (true) {
            // 每次去掉最小值目的是将使得区间更大的最小值去掉，换上一个更小的区间的值，
            int minIndex = q.poll();
            int curRange = max - nums.get(minIndex).get(next[minIndex]);
            if (curRange < minRange) {  // 这里严格等于的原因是避免左区间被右区间替换
                minRange = curRange;
                rangeLeft = nums.get(minIndex).get(next[minIndex]);
                rangeRight = max;
            }
            next[minIndex]++;
            if (next[minIndex] == nums.get(minIndex).size()) {
                break;
            }
            q.offer(minIndex);
            max = Math.max(max, nums.get(minIndex).get(next[minIndex]));
        }
        return new int[]{rangeLeft, rangeRight};
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int xMin = Integer.MAX_VALUE, xMax = (-1)*Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (Integer x : nums.get(i)) {
                List<Integer> list = map.getOrDefault(x, new ArrayList<Integer>());
                list.add(i);
                map.put(x, list);
                xMin = Math.min(x, xMin);
                xMax = Math.max(x, xMax);
            }
        }

        int[] freq = new int[n];
        int inside = 0;
        int l = xMin, r = xMin - 1;
        int resL = xMin, resR = xMax;
        while (r < xMax) {
            r++;
            if (map.containsKey(r)) {
                for (Integer index : map.get(r)) {
                    freq[index]++;
                    if(freq[index]==1){
                        inside++;
                    }
                }
                while(inside==n){
                    if(r-l<resR-resL){
                        resR = r;
                        resL = l;
                    }
                    if(map.containsKey(l)){
                        for (Integer index : map.get(l)) {
                            freq[index]--;
                            if(freq[index]==0){
                                inside--;
                            }
                        }
                    }
                    l++;
                }
            }
        }
        return new int[]{resL,resR};
    }
}
