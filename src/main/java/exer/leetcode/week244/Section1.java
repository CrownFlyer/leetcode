package exer.leetcode.week244;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-30 09:49
 */
public class Section1 {
    public static void main(String[] args) {
        Section1 test = new Section1();
        int[][] arr = {{0, 0}, {1, 0}};
        int[][] res = {{1, 0}, {0, 0}};
        int[][] rotate = test.rotate(arr);
        System.out.println(test.findRotation(arr, res));
        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                System.out.println(rotate[i][j]);
            }
        }
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (check(mat, target)) return true;
            mat = rotate(mat);
        }
        return false;
    }

    public int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            int temp[] = new int[n];
            for (int j = 0; j < n; j++) {
                res[i][j] = mat[j][n - i - 1];
            }
        }
        return res;
    }

    public boolean check(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }
}
