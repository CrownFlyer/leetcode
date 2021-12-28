package exer.leetcode.double60;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-24 17:26
 */
public class Solution4 {
    class Solution {
        final int mod = 1000_000_007;
        public int numberOfGoodSubsets(int[] nums) {
            int[] cnt = new int[31];
            for(int num:nums) cnt[num]++;
            int[] invalid = {4,8,9,12,16,18,20,24,25,27,28};
            for(int i = 0;i<invalid.length;i++) cnt[invalid[i]] = 0;

            int[] mutex = new int[31];
            for(int i = 2;i<31;i++){
                for(int j = 2;j<31;j++){
                    if(i!=j && gcd(i,j)>1){
                        mutex[i] |= 1 << j;
                    }
                }
            }

            return (int)(dfs(2,0,cnt,mutex) * pow(2,cnt[1]) % mod);
        }

        // 每次递归后，x,y都会交换，不会出现死循环
        public int gcd(int x,int y){
            if(y % x == 0) return x;
            return gcd(y%x,x);
        }

        public long dfs(int n,int chose,int[] cnt,int[] mutex){
            if(n == 31) return chose>0?1:0;
            long res = dfs(n+1,chose,cnt,mutex);
            if(cnt[n]>0 && (mutex[n] & chose) == 0)
                res += cnt[n] * dfs(n+1,chose|(1<<n),cnt,mutex);
            return res % mod;
        }

        // compute x^y
        public long pow(int x,int n){
            if (n == 0) return 1;
            long y = pow(x, n / 2);
            return n % 2 == 1 ? y * y * x %mod : y * y % mod;
        }

    }
}
