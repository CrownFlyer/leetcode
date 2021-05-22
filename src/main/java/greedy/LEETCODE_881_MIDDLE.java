package greedy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-20 20:14
 */
public class LEETCODE_881_MIDDLE {
    public static void main(String[] args) {
        int[] people = {3, 5, 3, 4};
        int limit = 5;
        System.out.println(numRescueBoats(people, limit));
    }

    // 超时
    public static int numRescueBoats1(int[] people, int limit) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int person : people) map.put(person, map.getOrDefault(person, 0) + 1);
        TreeSet<Integer> set = new TreeSet<>(map.keySet());
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        int cnt = 0;
        while (list.size() != 0) {
            Integer bigger = list.get(list.size() - 1);
            int biggerCnt = map.get(bigger);
            if (biggerCnt == 1) {
                set.remove(bigger);
                list.remove(bigger);
            } else {
                map.put(bigger, biggerCnt - 1);
            }
            cnt++;
            int rest = limit - bigger;
            Integer floor = set.floor(rest);
            if (floor != null) {
                int smallerCnt = map.get(floor);
                if (smallerCnt == 1) {
                    list.remove(floor);
                    set.remove(floor);
                } else {
                    map.put(floor, smallerCnt - 1);
                }
            }

        }
        return cnt;
    }

    // 双指针
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int res = 0;

        while(i<=j){
            res++;
            if(people[i]+people[j]<=limit) i++;
            j--;
        }
        return res;
    }
}
