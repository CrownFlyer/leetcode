package exer.leetcode.double68;

import java.math.BigInteger;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-27 22:24
 */
public class Solution4 {
    public String abbreviateProduct(int left, int right) {
        long zero = 0;
        // 计算后缀，并统计末位0的个数
        boolean flag = true;
        long suf = 1L;
        for (int i = left; i <= right; i++) {
            suf *= i;
            while (suf % 10 == 0) {
                zero++;
                suf /= 10;
            }
            // 这里是保留后11位，保证在d<=10的情况下无精度损失
            if (suf > 10_000_000_000L) {
                flag = false;
                suf %= 10_000_000_000L;
            }
        }
        if (flag) return suf + "e" + zero;
        // 计算前缀
        long pre = 1L;
        for (int i = left; i <= right; i++) {
            pre *= i;
            // 这里是保留前12位，是因为范围是在[1,10^6]，总共七位数，如果要计算到前五位，应该从前（7+5）十二位开始考虑
            // 处理后缀的时候，这里需要考虑的是前12位的原因是 如果要影响前5位的值，那必然至少是前x位才能影响到，由于我们的数的范围是[1,10^6]，所以最多是x-(6+1)>=5 所以x至少要考虑12位的影响
            // 那如果这里取前13位也是可以的不过会导致long溢出
            while (pre > 1000_000_000_000L) {
                pre /= 10;
            }
        }
        String x = String.valueOf(pre), y = String.valueOf(suf);
        return x.substring(0, 5) + "..." + y.substring(y.length() - 5) + "e" + zero;
    }
}
