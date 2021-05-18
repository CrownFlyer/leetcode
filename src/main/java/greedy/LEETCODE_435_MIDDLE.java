package greedy;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-18 16:40
 */
public class LEETCODE_435_MIDDLE {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return 0;
        Arrays.sort(intervals, (int[] i1, int[] i2) -> i1[1] - i2[1]);

        int valid = 1;
        int right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if(intervals[i][0]>=right){
                valid++;
                right = intervals[i][1];
            }
        }
        return n-valid;
    }
}
