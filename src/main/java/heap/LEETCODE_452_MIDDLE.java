package heap;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-03 10:09
 */
public class LEETCODE_452_MIDDLE {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        PriorityQueue<HashMap.Entry<Character, Integer>> q = new PriorityQueue<>((o1,o2)->o2.getValue()-o1.getValue());
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        Iterator<Map.Entry<Character, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            q.offer(iter.next());
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            Map.Entry<Character, Integer> e = q.poll();
            int cnt = e.getValue();
            char c = e.getKey();
            while(cnt!=0) {
                cnt--;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
