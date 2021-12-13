package exer.meituan;

import java.io.*;
import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-17 18:53
 */

public class Section14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] init = br.readLine().split(" ");
        int x = Integer.parseInt(init[0]), y = Integer.parseInt(init[1]);
        String[] s = br.readLine().split(" ");
        int[][] nums = new int[x + y][2];

        for (int i = 0; i < (x + y); i++) {
            nums[i][0] = Integer.parseInt(s[i]);
            nums[i][1] = i;
        }

        char[] res = new char[x + y];
        if (y > x) {
            Arrays.sort(nums, (a, b) -> b[0] - a[0]);
            for (int i = 0; i < x; i++) {
                res[nums[i][1]] = 'A';
            }
            for (int i = 0; i < y; i++) {
                res[nums[x + i][1]] = 'B';
            }
        } else if (y == x) {
            for (int i = 0; i < x; i++) {
                res[i] = 'A';
                res[i + x] = 'B';
            }
        } else {
            Arrays.sort(nums, (a, b) -> a[0] - b[0]);
            for (int i = 0; i < x; i++) {
                res[nums[i][1]] = 'A';
            }
            for (int i = 0; i < y; i++) {
                res[nums[x + i][1]] = 'B';
            }
        }
        bw.write(new String(res) + "\n");
        br.close();
        bw.close();
    }
}
