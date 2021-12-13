package exer.leetcode.week267;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-14 16:53
 */
public class Section4 {
    int[] f;

    public int find(int x) {
        return f[x] = f[x] == x ? x : find(f[x]);
    }

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        f = new int[n];
        for (int i = 0; i < n; i++)
            f[i] = i;
        boolean[] res = new boolean[requests.length];
        for (int i = 0; i < requests.length; i++) {
            int px = find(requests[i][0]);
            int py = find(requests[i][1]);
            // 如果之前同化过，表示该请求通过
            if (px == py) {
                res[i] = true;
                continue;
            }
            // 必须绕过所有的限制条件
            boolean flag = true;
            for (int[] restriction : restrictions) {
                if (find(restriction[0]) == px && find(restriction[1]) == py
                        || find(restriction[0]) == py && find(restriction[1]) == px) {
                    flag = false;
                    break;
                }
            }
            res[i] = flag;
            // 如果通过，默认将px的根节点置为py
            if (flag) f[px] = py;
        }
        return res;
    }
}
