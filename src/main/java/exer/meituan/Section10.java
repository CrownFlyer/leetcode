package exer.meituan;

import java.io.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-15 15:29
 */
public class Section10 {
    // 二分查找 O(nlogn)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] init = br.readLine().split(" ");
        int m = Integer.parseInt(init[0]), n = Integer.parseInt(init[1]);
        String[] datas = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(datas[i]);
        }
        int res = 0;
        for (int l = 1; l < m; l++) {
            int rl = l, rr = m;
            while (rl < rr) {
                int mid = (rl + rr) / 2;
                // 保证rr一直可行
                if (check(nums, l, mid)) rr = mid;
                else rl = mid + 1;
            }
            if (check(nums, l, rr)) res += m - rr + 1;
        }

        bw.write(res + "\n");
        br.close();
        bw.close();
    }

    public static boolean check(int[] nums, int l, int r) {
        int n = nums.length;
        int last = -1;
        for (int j = 0; j < n; j++) {
            if (nums[j] < l || nums[j] > r) {
                if (last > nums[j]) return false;
                last = nums[j];
            }
        }
        return true;
    }

}
