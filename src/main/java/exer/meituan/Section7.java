package exer.meituan;

import java.io.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-14 10:37
 */

public class Section7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[] v = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            String[] datas = br.readLine().split(" ");
            int idx = 0;
            int tar = 0;
            while(v[(tar = Integer.parseInt(datas[idx]))]) idx++;
            v[tar] = true;
            bw.write(tar + " ");
        }
        br.close();
        bw.close();
    }
}
