package greedy;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-22 16:45
 */
public class LEETCODE_135_HARD {
    @Test
    public void test() {
        int[] r = {1,2,2};
        System.out.println(new LEETCODE_135_HARD().candy(r));
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] dispatch = new int[n];
        dispatch[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) dispatch[i] = dispatch[i - 1] + 1;
            else dispatch[i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) dispatch[i] = Math.max(dispatch[i],dispatch[i + 1] + 1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) res += dispatch[i];
        return res;
    }
}
