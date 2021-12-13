package exer.leetcode.jianhang;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-29 18:36
 */
public class Section2 {
    @Test
    public void test() {
        int[] hs = {4,6,1,8,4,10};
        int[] ints = analysisHistogram(hs, 4);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] analysisHistogram(int[] heights, int cnt) {
        int n = heights.length;
        Arrays.sort(heights);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i + cnt - 1 < n; i++) {
            min = Math.min(min, heights[i + cnt - 1] - heights[i]);
        }
        int i = 0;
        for (i = 0; i + cnt - 1 < n; i++) {
            if (heights[i + cnt - 1] - heights[i] == min) break;
        }
        int[] res = new int[cnt];
        for (int j = 0; j < cnt; j++) {
            res[j] = heights[i + j];
        }
        return res;
    }

}
