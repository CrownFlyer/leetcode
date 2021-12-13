package exer.meituan;

import java.io.*;
import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-15 15:29
 */
public class Section11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] datas = br.readLine().split(" ");
        long[] cnt = new long[4];
        for (int i = 0; i < 4; i++) {
            cnt[i] = Integer.parseInt(datas[i]);
        }
        int[][] price = new int[3][2];
        for (int i = 0; i < 3; i++) {
            price[i][0] = Integer.parseInt(datas[4 + i]);
            price[i][1] = i;
        }
        Arrays.sort(price, (x, y) -> y[0] - x[0]);
        long res = 0;
        int idx = 0;
        while (cnt[3] > 0 && idx < 3) {
            long num = Math.min(cnt[3], cnt[price[idx][1]]);
            res += price[idx++][0] * num;
            cnt[3] -= num;
        }
        bw.write(res + "\n");
        br.close();
        bw.close();
    }

}
