package sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-23 12:00
 */
public class LEETCODE_1333_MIDDLE {
    @Test
    public void test() {
        int[][] restaurants = {{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}};
        List<Integer> list = filterRestaurants(restaurants, 1, 50, 10);
        list.forEach(System.out::print);
    }

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < restaurants.length; i++) {
            List<Integer> temp = Arrays.stream(restaurants[i]).boxed().collect(Collectors.toList());
            list.add(temp);
        }
        List<Integer> res = list.stream()
                .filter(l -> {
                    return veganFriendly == 1 ? l.get(2) == 1 : l.get(2) == 0 || l.get(2) == 1;
                })
                .filter(l -> {
                    return maxPrice >= l.get(3);
                })
                .filter(l -> {
                    return maxDistance >= l.get(4);
                })
                .sorted(
                        (o1, o2) -> {
                            int temp = o2.get(1).compareTo(o1.get(1));
                            if (temp != 0) return temp;
                            return o2.get(0).compareTo(o1.get(0));
                        }
                )
                .map(l -> l.get(0))
                .collect(Collectors.toList());
//                .forEach(System.out::println);
        return res;
    }
}
