package exer.test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-18 10:36
 */
public class LEETCODE_476_SIMPLE {
    public int findComplement(int num) {
        int n;
        for (n = 30; n >= 0; n--) {
            if ((num & (1 << n)) != 0) break;
        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            if ((num & (1 << i)) == 0) res |= (1 << i);
        }
        return res;
    }
}
