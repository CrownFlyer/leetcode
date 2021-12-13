package exer.test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-10 10:24
 */
public class LEETCODE_441_SIMPLE {
    public int arrangeCoins(int n) {
        // 始终能保证l是有效的，最后收敛到唯一一个l==r的地方，此时保证是最大的有效数，即为答案
        int l = 0, r = 1<<16;
        while(l<r){
            int m = l + (r-l+1)/2;
            if((long)m*(m+1) <= 2L*(long)n) l = m;
            else r = m - 1;
        }
        return l;
    }
}
