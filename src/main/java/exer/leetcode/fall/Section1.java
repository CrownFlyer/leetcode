package exer.leetcode.fall;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-11 14:14
 */
public class Section1 {
    @Test
    public void test() {
        int[][] s = {{1,3},{5,4}};
        int[][] t = {{3,1},{6,5}};
        System.out.println(minimumSwitchingTimes(s, t));
    }

    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int m = source.length, n = source[0].length;
        int[] arr1 = new int[m * n];
        int[] arr2 = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr1[i * n + j] = source[i][j];
                arr2[i * n + j] = target[i][j];
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int idx1 = 0,idx2 = 0;
        int cnt = 0;
        while(idx1<m*n&&idx2<m*n){
            if(arr1[idx1]==arr2[idx2]) {
                cnt++;
                idx1++;
                idx2++;
            }
            else if(arr1[idx1]<arr2[idx2]) idx1++;
            else idx2++;
        }
        return m * n - cnt;
    }

}
