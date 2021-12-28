package exer.leetcode.double63;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-15 19:03
 */
public class Solution1 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int n = seats.length;
        int res = 0;
        for(int i = 0;i<n;i++){
            res += Math.abs(seats[i]-students[i]);
        }
        return res;
    }
}
