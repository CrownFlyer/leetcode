package exer.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-29 09:21
 */
public class LEETCODE_1104_MIDDLE {
    @Test
    public void test() {
        System.out.println(pathInZigZagTree(14));
    }

    public List<Integer> pathInZigZagTree(int label) {
        int power = 1;
        while (1 << power <= label) {
            power += 1;
        }

        if (power % 2 == 0) label = getReverse(label, power);

        List<Integer> res = new ArrayList<>();
        while (label > 0) {
            res.add(0, power % 2 == 0 ? getReverse(label, power) : label);
            label >>= 1;
            power--;
        }

        return res;
    }

    public int getReverse(int label, int power) {
        return (1 << power - 1) + (1 << power) - label - 1;
    }
}
