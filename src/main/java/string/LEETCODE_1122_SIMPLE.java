package string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-22 12:07
 */
public class LEETCODE_1122_SIMPLE {
    @Test
    public void test() {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 19, 9, 2, 7};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] ints = relativeSortArray(arr1, arr2);
        for (int i : ints) {
            System.out.print(i);
        }
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        for (int i : arr1) {
            max = Math.max(max, i);   //每次都求max，获取arr1的最大值
        }


        int[] nums = new int[max+1];
        int[] res = new int[arr1.length];
        //遍历arr1,统计每个元素的数量
        for (int i : arr1) {
            nums[i]++;
        }
        //遍历arr2,处理arr2中出现的元素
        int index = 0;
        for (int i : arr2) {
            while (nums[i]>0){
                res[index++] = i;
                nums[i]--;
            }
        }
        //遍历nums,处理剩下arr2中未出现的元素 遍历自然排序 牛逼！
        for (int i = 0; i <= max; i++) {     //遍历nums可以遍历到max就停下了，不用到1001
            while (nums[i]>0){
                res[index++] = i;
                nums[i]--;
            }
        }
        return res;
    }

    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int arr1Length = arr1.length;
        int[] res = new int[arr1Length];
        BitSet used = new BitSet(arr1Length);
        ArrayList<Integer> list = new ArrayList<>();

        int index = 0;

        for (int i = 0; i < arr2.length; i++) {
            int goal = arr2[i];
            int temp = 0;
            while (temp != arr1Length) {
                if (arr1[temp] == goal) {
                    res[index] = goal;
                    used.set(temp);
                    index++;
                }
                temp++;
            }
        }
        for (int i = 0; i < arr1Length; i++) {
            if (!used.get(i)) list.add(arr1[i]);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            res[index++] = list.get(i);
        }
        return res;
    }
}
