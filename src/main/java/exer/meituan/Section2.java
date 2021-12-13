package exer.meituan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-11 16:06
 */
public class Section2 {
    // 逆序遍历，记录左右边界
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        int[] pre = new int[n + 1];

        for (int i = 0; i < n; i++) {
            nums[i + 1] = Integer.parseInt(sc.next());
            pre[i + 1] = pre[i] + nums[i + 1];
        }
        int[] cmd = new int[n];
        for (int i = 0; i < n; i++) {
            cmd[i] = Integer.parseInt(sc.next());
        }
        sc.close();
        // 记录倒序添加的组成堆的边界，由于后续只和堆的边界有关，堆里面的边界无影响
        int[][] d = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(d[i], -1);
        }
        int[] res = new int[n];
        int maxW = 0;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = maxW;
            if (i == 0) break;
            // 更新最大重量
            int cur = nums[cmd[i]];
            // 左边界和右边界
            int left = cmd[i], right = cmd[i];
            // 每次只会将左右两块区域连成一块，只需关心一段区间的左边界和右边界，就能通过前缀和数组查询到区间和
            // 只有相邻的才能连成一堆，如果不相邻，中间断开的部分一定是先从此处断开，不能视为一堆
            if (cmd[i] + 1 <= n && d[cmd[i] + 1][0] != -1) {
                cur += pre[d[cmd[i] + 1][1]] - pre[d[cmd[i] + 1][0] - 1];
                right = d[cmd[i] + 1][1];  // 更新右边界
            }
            if (cmd[i] - 1 >= 1 && d[cmd[i] - 1][1] != -1) {
                cur += pre[d[cmd[i] - 1][1]] - pre[d[cmd[i] - 1][0] - 1];
                left = d[cmd[i] - 1][0];  // 更新左边界
            }

            maxW = Math.max(maxW, cur);
            // 更新两端点的左右区间
            d[left][0] = left;
            d[left][1] = right;
            d[right][0] = left;
            d[right][1] = right;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }

    // 有序集合
    static TreeMap<Integer, Integer> map = new TreeMap<>();
    static TreeSet<Integer> bound = new TreeSet<>();
    static int[] prefix;

    public static void main(String[] args) throws Exception {
        // 加速 IO
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        String[] query = br.readLine().split(" ");
        br.close();

        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + Integer.parseInt(arr[i]);
        }

        bound.add(0);
        bound.add(n + 1);
        for (int i = 0; i < n; i++) {
            int pos = Integer.parseInt(query[i]);
            Integer left = bound.lower(pos);
            Integer right = bound.higher(pos);

            int seg_sum = prefix[right - 1] - prefix[left];
            Integer cnt = map.get(seg_sum);
            if (cnt != null) {
                if (cnt == 1) {
                    map.remove(seg_sum);
                } else {
                    map.put(seg_sum, cnt - 1);
                }
            }
            int left_sum = prefix[pos - 1] - prefix[left];
            int right_sum = prefix[right - 1] - prefix[pos];
            bound.add(pos);
            map.put(left_sum, map.getOrDefault(left_sum, 0) + 1);
            map.put(right_sum, map.getOrDefault(right_sum, 0) + 1);
            bw.write(map.lastKey() + "\n");
            // StringBuilder 可以加速字符串拼接
            // bw.write(new StringBuilder().append(map.lastKey())
            //          .append('\n').toString());
        }
        bw.close();
    }

}
