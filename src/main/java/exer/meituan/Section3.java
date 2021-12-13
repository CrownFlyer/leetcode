package exer.meituan;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Section3 {

    // 堆 O(mlogM)
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] data = reader.readLine().split(" ");
        int n = Integer.parseInt(data[0]), m = Integer.parseInt(data[1]);
        // 最大的用小顶堆
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        for (int i = 1; i <= n; i++) {
            String[] row = reader.readLine().split(" ");
            int v = Integer.parseInt(row[0]), w = Integer.parseInt(row[1]);
            int x = v + 2 * w;
            if (queue.size() < m) {
                queue.offer(new int[]{x, i});
            } else {
                if (queue.peek()[0] < x) {
                    queue.poll();
                    queue.offer(new int[]{x, i});
                } else if (queue.peek()[0] == x && i < queue.peek()[1]) {
                    queue.poll();
                    queue.offer(new int[]{x, i});
                }
            }
        }
        int[] arr = new int[m];
        int index = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            arr[index++] = poll[1];
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            writer.write(arr[i] + " ");
        }

        writer.close();
        reader.close();
    }

}
