package exer.leetcode.double51;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-13 16:14
 */
public class test {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        System.out.println(map);
        map.forEach((k, v) -> System.out.println("(k=" + k + ",v=" + v + ")"));
        map.entrySet().stream().forEach(System.out::println);
        System.out.println();
        System.out.println(new ArrayList<Integer>().getClass());
    }
}
