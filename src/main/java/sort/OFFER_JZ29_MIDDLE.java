package sort;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-20 21:48
 */
public class OFFER_JZ29_MIDDLE {
    @Test
    public void test() {

    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();

        int size = input.length;
        if (k > size) return res;

        sort(input, 0, input.length - 1);

        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 适合本身乱序的 要是大部分有序 效率则低
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
}
