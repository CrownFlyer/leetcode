package exer.meituan;

import java.io.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-15 15:29
 */

public class Section13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) == 'E' ? 1 : -1;
        }
        int[] pre = new int[n + 1];
        // min记录之前的前缀和中最小的前缀和，方便计算出最大区间和，max为E、F数量之差的最大值
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
            min = Math.min(min, pre[i]);
            max = Math.max(max, pre[i] - min);
        }
        bw.write(max + "\n");
        br.close();
        bw.close();
    }
}
