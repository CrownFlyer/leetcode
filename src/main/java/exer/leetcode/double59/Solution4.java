package exer.leetcode.double59;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-30 18:32
 */
public class Solution4 {
    public int numberOfCombinations(String num) {
        final int mod = 1000_000_007;
        if(num.charAt(0) =='0') return 0;
        int n = num.length();
        // lcp[i][j]:记录num[i:] 和 num[j:]的最长公共前缀
        int[][] lcp = new int[n][n];
        for(int i = n-1;i>=0;i--){
            for(int j=n-1;j>=i;j--){
                lcp[i][j] = num.charAt(i)==num.charAt(j)?1+((i<n-1&&j<n-1)?lcp[i+1][j+1]:0):0;
            }
        }
        // cnt[i][j]:末尾为num[i,j]的方案数
        int[][] cnt = new int[n][n];
        // dp[i][j]表示末尾坐标为i但是开始坐标从0加到j-1的所有cnt和
        int[][] dp = new int[n][n+1];
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                if(num.charAt(i) == '0') cnt[i][j] = 0;
                else if(i == 0) cnt[i][j] = 1;
                else{
                    // 小于当前的数字的起点最大为2i-j-1，位数小于的话最小起点是2i-j
                    // 1.当前位数大于前一个位数的，长度大则肯定大
                    cnt[i][j] = (dp[i-1][i]-dp[i-1][Math.max(0,2*i-j)]+mod)%mod;
                    // 2.当前位数和前一个位数相同且比前一个数大的，这里比较利用lcp将能比较的位置通过O(1)找出来
                    if(2*i-j-1>=0&&(lcp[2*i-j-1][i]>=j-i+1||num.charAt(2*i-j-1+lcp[2*i-j-1][i])<num.charAt(i+lcp[2*i-j-1][i]))){
                        cnt[i][j]=(cnt[i][j]+cnt[2*i-j-1][i-1])%mod;
                    }
                }
                dp[j][i+1] = (dp[j][i] + cnt[i][j])%mod;
            }
        }
        return dp[n-1][n];
    }
}
