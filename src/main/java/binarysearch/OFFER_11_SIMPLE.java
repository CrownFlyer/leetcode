package binarysearch;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-26 15:30
 */
public class OFFER_11_SIMPLE {
    public static void main(String[] args) {
        int [] arr = {2,2,2,0,1};
        System.out.println(minArray(arr));
    }

    public static int minArray(int[] numbers) {
        int n = numbers.length;

        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            // 下面的判断条件都是严格的，因此可以正确分辨左右有序序列
            if(numbers[mid]>numbers[r]) l = mid+1;
            else if(numbers[mid]<numbers[r]) r = mid;
            else r--;
        }
        return numbers[l];
    }
}
