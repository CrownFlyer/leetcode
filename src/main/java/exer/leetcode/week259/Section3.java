package exer.leetcode.week259;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-19 15:15
 */
public class Section3 {
    class DetectSquares {
        Map<Integer, Map<Integer,Integer>> map;

        public DetectSquares() {
            map = new HashMap<>();
        }

        public void add(int[] point) {
            map.putIfAbsent(point[0], new HashMap<>());
            Map<Integer, Integer> map1 = this.map.get(point[0]);
            map1.put(point[1],map1.getOrDefault(point[1],0)+1);
        }

        public int count(int[] point) {
            int res = 0;
            Map<Integer, Integer> map1 = map.get(point[0]);
            if (map1 == null) return 0;
            for (Integer y : map1.keySet()) {
                if(y == point[1]) continue;
                int l = Math.abs(y-point[1]);
                Map<Integer, Integer> map2 = this.map.get(point[0] + l);
                if(map2!=null){
                    res += map1.get(y)* map2.getOrDefault(point[1],0)*map2.getOrDefault(y,0);
                }
                Map<Integer, Integer> map3 = this.map.get(point[0] - l);
                if(map3!=null){
                    res += map1.get(y)* map3.getOrDefault(point[1],0)*map3.getOrDefault(y,0);
                }

            }
            return res;
        }
    }
}
