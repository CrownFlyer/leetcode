package exer.leetcode.week275;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-09 16:20
 */
public class Solution1 {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0;i<n;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0;j<n;j++){
                set.add(matrix[i][j]);
            }
            for(int k=1;k<=n;k++){
                if(!set.contains(k)) return false;
            }
        }
        for(int i = 0;i<n;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0;j<n;j++){
                set.add(matrix[j][i]);
            }
            for(int k=1;k<=n;k++){
                if(!set.contains(k)) return false;
            }
        }
        return true;
    }
}
