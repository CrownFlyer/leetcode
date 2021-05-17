package sort;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-23 17:08
 */
public class LEETCODE_164_HARD {
    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 1};
        System.out.println(maximumGap(arr));

    }

    public static int maximumGap(int[] nums) {
        int size = nums.length;
        int res = 0;
        if (size < 2) return 0;

        radixsort(nums);
        for (int i = 0; i < size - 1; i++) {
            if (res < nums[i + 1] - nums[i]) res = nums[i + 1] - nums[i];
        }
        return res;
    }

    // my writing edition
    public static void radixsort(int[] arr) {
        int max = 0;
        for (int item : arr) {
            if (max < item) max = item;
        }
        int radix = (max + "").length();

        int[][] bucketElements = new int[10][arr.length];
        int[] bucketCounts = new int[10];
        for (int i = 0, temp = 1; i < radix; i++, temp *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digit = arr[j] % (temp * 10) / temp;
                bucketElements[digit][bucketCounts[digit]++] = arr[j];
            }
            int index = 0;
            int tempCnt = 0;
            for (int k = 0; k < 10; k++) {
                while (bucketCounts[k] != tempCnt) arr[index++] = bucketElements[k][tempCnt++];
                bucketCounts[k] = 0;
                tempCnt = 0;
            }
        }
    }

    public static void radixSort(int[] arr) {

        //找到最大数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数的位数
        int maxLength = (max + "").length();

        //定义一个二维数组，表示桶（10表示0~9，总共10个数），每个桶最大则为数组个数
        //可以想象，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶实际存放的数据量，定义一个一维数组记录每个桶的每次放入的数据个数
        //bucketElementCounts[i]表示放入bucket[i]桶的个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0, temp = 1; i < maxLength; i++, temp *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素对应的位进行排序，个位、十位、...
                int digitOfElement = arr[j] / temp % 10;
                //放入到对应桶
                bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = arr[j];
//            bucketElementCounts[digitOfElement]++;
            }

            //按照桶的顺序（一维数组的下标依次取出数据，放入原来数组）
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i+1轮处理后，需要将每个bucketElementCounts[k]置零
                bucketElementCounts[k] = 0;
            }
        }
    }
}
