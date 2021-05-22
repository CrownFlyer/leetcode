package greedy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-21 11:18
 */
public class LEETCODE_1620_MIDDLE {
    public static void main(String[] args) {
        int[][] towers = {{42,0,0}};
        int radius = 7;
        int[] ints = bestCoordinate(towers, radius);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static int[] bestCoordinate(int[][] towers, int radius) {
        HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();
        for (int[] tower : towers) {
            for (int x = -1 * radius; x <= radius; x++) {
                int y = (int) Math.sqrt(radius * radius - x * x);
                for (int j = -1 * y; j <= y; j++) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(tower[0] + x);
                    list.add(tower[1] + j);
                    map.put(list, 0);
                }
            }
        }

        Iterator<Map.Entry<ArrayList<Integer>, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            int signal = 0;
            Map.Entry<ArrayList<Integer>, Integer> next = it.next();
            for (int[] tower : towers) {
                double dist = helper(next.getKey(), tower);
                if (dist <= radius) signal += (int)(tower[2] / (1 + dist));
            }
            map.put(next.getKey(), signal);
        }
        Optional<Integer> max = map.values().stream().max((a, b) -> a - b);
        if(max.get().equals(0)) {
            int[] res = new int[2];
            return res;
        }
        List<Map.Entry<ArrayList<Integer>, Integer>> temp = map.entrySet().stream()
                .filter(a -> a.getValue().equals(max.get()))
                .sorted(
                        (a, b) -> {
                            if (!a.getKey().get(0).equals(b.getKey().get(0)) ) return a.getKey().get(0) - b.getKey().get(0);
                            else return a.getKey().get(1) - b.getKey().get(1);
                        })
                .collect(Collectors.toList());
        return temp.get(0).getKey().stream().mapToInt(Integer::valueOf).toArray();
    }

    public static double helper(ArrayList<Integer> list, int[] tower) {
        return Math.sqrt(Math.pow(list.get(0) - tower[0], 2) + Math.pow(list.get(1) - tower[1], 2));
    }
}
