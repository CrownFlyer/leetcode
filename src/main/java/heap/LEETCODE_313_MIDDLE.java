package heap;

import java.util.PriorityQueue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-03 10:38
 */
public class LEETCODE_313_MIDDLE {
    public static void main(String[] args) {
        int n = 10;
        int[] primes = {2, 3, 5};
        LEETCODE_313_MIDDLE test = new LEETCODE_313_MIDDLE();
        System.out.println(test.nthSuperUglyNumber(n, primes));
    }

    public int nthSuperUglyNumber1(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        // 第一个元素为丑数，第二个元素记录了基于哪一个过去的丑数计算，第三个元素记录了基于哪一个质因子的计算
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int len = primes.length;
        for (int i = 0; i < len; i++) {
            pq.offer(new int[]{primes[i], 0, i});
        }
        for (int i = 1; i < n; i++) {
            int[] tmp = pq.poll();
            ugly[i] = tmp[0];
            tmp[0] = ugly[++tmp[1]] * primes[tmp[2]];
            pq.offer(tmp);
            if (ugly[i] == ugly[i - 1]) i--;
        }
        return ugly[n - 1];
    }

    public int nthSuperUglyNumber2(int n, int[] primes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] res = new int[n];
        int len = primes.length;
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < len; j++) {
                pq.offer(res[i-1]*primes[j]);
            }
            res[i]= pq.poll();
            if(res[i]==res[i-1]) i--;
        }
        return res[n-1];
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
