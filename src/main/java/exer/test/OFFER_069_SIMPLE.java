package exer.test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-14 10:37
 */
public class OFFER_069_SIMPLE {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while(l<r){
            int m = l + (r - l) / 2;
            if(arr[m] > arr[m - 1] && arr[m] > arr[m + 1]) return m;
            else if(arr[m] < arr[m + 1]) l = m + 1;
            else if(arr[m] > arr[m + 1]) r = m;
        }
        return l;
    }
}
