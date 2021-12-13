package exer.meituan;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-15 15:29
 */


public class Section12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] inits = br.readLine().split(" ");
        int M = Integer.parseInt(inits[0]), N = Integer.parseInt(inits[1]), Q = Integer.parseInt(inits[2]);

        //<k,v>:<sequence of book,number of row>
        Map<Integer, Integer> map = new HashMap<>();
        boolean[] v = new boolean[M + 1];
        boolean[] lock = new boolean[N + 1];
        for (int i = 0; i < Q; i++) {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "1":
                    int idx_of_book = Integer.parseInt(cmd[1]);
                    int idx_of_row = Integer.parseInt(cmd[2]);
                    if (!v[idx_of_book] && (!map.containsKey(idx_of_book) || !lock[map.get(idx_of_book)]) && !lock[idx_of_row]) {
                        map.put(idx_of_book, idx_of_row);
                    }
                    break;
                case "2":
                    lock[Integer.parseInt(cmd[1])] = true;
                    break;
                case "3":
                    lock[Integer.parseInt(cmd[1])] = false;
                    break;
                case "4":
                    int idx_of_queryBook = Integer.parseInt(cmd[1]);
                    if (map.containsKey(idx_of_queryBook) && !lock[map.get(idx_of_queryBook)] && !v[idx_of_queryBook]) {
                        v[idx_of_queryBook] = true;
                        bw.write(map.remove(idx_of_queryBook) + "\n");
                    } else bw.write(-1 + "\n");
                    break;
                case "5":
                    int idx_of_returnBook = Integer.parseInt(cmd[1]);
                    v[idx_of_returnBook] = false;
                    break;
                default:
                    break;
            }
        }

        br.close();
        bw.close();
    }

}

