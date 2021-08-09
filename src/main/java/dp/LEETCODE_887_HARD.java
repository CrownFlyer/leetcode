package dp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-07 15:52
 */
public class LEETCODE_887_HARD {
    @Test
    public void test() {
        System.out.println(superEggDrop(1, 2));
    }

    Map<Integer, Integer> cache = new HashMap<>();

    public int superEggDrop(int k, int n) {
        return dp(k,n);
    }

    public int dp(int k, int n) {
        if (!cache.containsKey(hash(k, n))) {
            int res = 0;
            if (n == 0) return 0;
            else if (k == 1) return n;
            else {
                int l = 1, r = n;
                while (l + 1 < r) {
                    int m = (l + r) / 2;
                    int t1 = dp(k - 1, m - 1);
                    int t2 = dp(k, n - m);

                    if (t1 < t2) l = m;
                    else if (t1 > t2) r = m;
                    else {
                        l = m;
                        r = m;
                    }
                }
                res = 1 + Math.min(Math.max(dp(k-1,l-1),dp(k,n-l)),Math.max(dp(k-1,r-1),dp(k,n-r)));
            }
            cache.put(hash(k,n),res);
        }

        return cache.get(hash(k, n));
    }

    public int hash(int k, int n) {
        return n * 100 + k;
    }
}
