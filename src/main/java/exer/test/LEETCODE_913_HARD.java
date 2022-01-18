package exer.test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-04 12:09
 */
public class LEETCODE_913_HARD {
    static int N = 51;
    // dp[k][i][j]:当前为第k轮，mouse位于i，cat位于j的最终结果
    static int[][][] dp = new int[2 * N * N][N][N];
    int[][] g;
    int n;

    public int catMouseGame(int[][] graph) {
        this.g = graph;
        n = g.length;
        for (int k = 0; k < 2 * n * n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    dp[k][i][j] = -1;

        return dfs(0, 1, 2);
    }

    // k:turns,i:mouse,j=cat
    // returns:0->draw 1->mouse 2->cat
    private int dfs(int k, int i, int j) {
        int res = dp[k][i][j];
        // 保证每个点只经过一次
        if (i == 0) res = 1;
        else if (j == i) res = 2;
        else if (k == 2 * n * n) res = 0;
        else if (res == -1) {
            // 最优博弈:这里的原则不是去找最优的，而是遍历所有的路径，如果有则通过，没有则不通过
            // 对于每个主体不同
            if (k % 2 == 0) {
                boolean win = false, draw = false;
                for (int next : g[i]) {
                    int t = dfs(k + 1, next, j);
                    // 对于mouse，如果判定为1则剪枝
                    if (t == 1) win = true;
                    else if (t == 0) draw = true;
                    if (win) break;
                }
                if (win) res = 1;
                else if (draw) res = 0;
                else res = 2;
            } else {
                boolean win = false, draw = false;
                for (int next : g[j]) {
                    // cat can not into 0
                    if (next == 0) continue;
                    int t = dfs(k + 1, i, next);
                    // 对于cat，如果判定为2则剪枝
                    if (t == 2) win = true;
                    else if (t == 0) draw = true;
                    if (win) break;
                }
                if (win) res = 2;
                else if (draw) res = 0;
                else res = 1;
            }
        }
        dp[k][i][j] = res;
        return res;
    }
}
