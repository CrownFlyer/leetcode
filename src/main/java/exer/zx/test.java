package exer.zx;

import java.util.LinkedHashSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-24 16:48
 */
public class test {
    public static void main(String[] args) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(3);
        set.add(2);
        set.add(4);
        set.add(1);
        set.remove(2);
        set.add(2);
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
