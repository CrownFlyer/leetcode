package exer.meituan;

import java.io.*;
import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-12 11:17
 */
public class Section4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        Arrays.fill(b, -1);
        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(nums[i]);
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] op = br.readLine().split(" ");
            if (op[0].equals("1")) {
                System.arraycopy(a, Integer.parseInt(op[2]) - 1, b, Integer.parseInt(op[3]) - 1, Math.min(Integer.parseInt(op[1]), n - Integer.parseInt(op[3]) + 1));
            } else {
                bw.write(b[Integer.parseInt(op[1]) - 1] + "\n");
            }
        }
        br.close();
        bw.close();
    }
}
