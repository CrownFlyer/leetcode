package exer.leetcode.double66;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-28 17:52
 */
public class Solution2 {
    public int minimumBuckets(String street) {
        int n = street.length();
        char[] chs = street.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chs[i] == 'H' && ((i - 1) < 0 || chs[i - 1] == 'H') && (i + 1 >= n || chs[i + 1] == 'H')) return -1;
        }

        // 上一个桶的位置
        int last = -2;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (chs[i] == 'H') {
                // 上一个桶不能把当前的雨水装下
                if (i - 1 != last) {
                    res++;
                    last = i + 1;
                }
            }
        }
        return res;
    }
}
