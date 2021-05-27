package binarysearch;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-25 20:12
 */
public class LEETCODE_33_MIDDLE {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,1,1,1};
        System.out.println(search(arr, 2));
    }


    public static int search(int[] arr, int target) {
        int n = arr.length;

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (arr[mid] == target) return mid;
            if (arr[mid] >= arr[0]) {   // 判断[0,mid]是否有序，此处判断有序
                if (arr[mid] > target && arr[0] <= target) r = mid - 1;
                else l = mid + 1;
            } else { // [mid,r]部分有序
                if (arr[mid] < target && arr[n - 1] >= target) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }

}
