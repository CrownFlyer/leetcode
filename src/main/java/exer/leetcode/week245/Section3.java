package exer.leetcode.week245;

import java.util.ArrayList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-12 22:20
 */
public class Section3 {
    public static void main(String[] args) {
        Section3 test = new Section3();
        int tri[][] = {{2,5,3},{1,8,4},{1,7,5}};
        int [] tar = {2,7,5};
        System.out.println(test.mergeTriplets(tri, tar));
    }

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]) list.add(i);
        }
        int[] max = new int[3];
        int size = list.size();
        for (int i = 0; i < size; i++) {
            max[0] = Math.max(max[0],triplets[list.get(i)][0]);
            max[1] = Math.max(max[1],triplets[list.get(i)][1]);
            max[2] = Math.max(max[2],triplets[list.get(i)][2]);
        }
        return max[0]==target[0] && max[1]==target[1] && max[2]==target[2];
    }
}
