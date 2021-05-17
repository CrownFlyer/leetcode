package sort;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-23 16:14
 */
public class LEETCODE_1481_MIDDLE {
    @Test
    public void test() {
        int[] arr = {1};
        int k = 1;
        System.out.println(findLeastNumOfUniqueInts(arr, k));
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = arr.length;
        Integer temp;
        for (int i = 0; i < size; i++) {
            temp = map.get(arr[i]);
            if (temp == null) map.put(arr[i], 1);
            else map.put(arr[i], temp + 1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int index = 0;
        while (k > 0) {
            if (k >= list.get(index)) k -= list.get(index++);
            else break;
        }
        while (index < list.size() && list.get(index) == 0) index++;
        return list.size() - index;
    }
}
