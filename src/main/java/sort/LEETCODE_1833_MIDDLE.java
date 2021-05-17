package sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-22 17:52
 */
public class LEETCODE_1833_MIDDLE {
    @Test
    public void test() {
        int[] costs = {1, 3, 2, 4, 1};
        Arrays.sort(costs);
        int coins = 7;
        System.out.println(maxIceCream(costs, coins));
    }

    public int maxIceCream(int[] costs, int coins) {
        sort(costs, 0, costs.length - 1);
        int index = 0;
        while (coins >= 0 && index < costs.length) {
            if (coins >= costs[index]) coins -= costs[index++];
            else break;
        }
        return index;
    }

    public void sort(int[] input, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int vot = input[begin];
        int i = begin, j = end;
        while (i != j) {
            while (i < j && vot <= input[j]) j--;
            swap(input, i, j);
            while (i < j && vot >= input[i]) i++;
            swap(input, i, j);
        }
        sort(input, begin, i - 1);
        sort(input, i + 1, end);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
