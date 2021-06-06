package exer.leetcode.week244;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-30 09:49
 */
public class Section2 {
    public static void main(String[] args) {
        Section2 test = new Section2();
        int[] nums = {1,1,1};
        System.out.println(test.reductionOperations(nums));
    }

    public int reductionOperations1(int[] nums) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });

        int min = Arrays.stream(nums).min().getAsInt();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{nums[i], i});
        }

        while (q.peek()[0] != min) {

        }
        return 0;

    }

    public int reductionOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int min = Arrays.stream(nums).min().getAsInt();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        ArrayList<int[]> list = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> next = it.next();
            list.add(new int[]{next.getKey(),next.getValue()});
        }
        Collections.sort(list,(o1,o2)->o1[0]-o2[0]);
        int size = list.size();
        int res = 0;
        for (int i = size-1; i > 0; i--) {
            res+=list.get(i)[1]*i;
        }
        return res;
    }

}
