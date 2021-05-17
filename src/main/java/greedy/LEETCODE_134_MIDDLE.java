package greedy;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-12 15:34
 */
public class LEETCODE_134_MIDDLE {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            int total = 0;
            int j = i;
            while (total >= 0) {
                if (cnt == n) return i;
                total += gas[j % n] - cost[j++ % n];
                cnt++;
            }
        }
        return -1;
    }
}
