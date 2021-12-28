package counting;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-25 12:27
 */
public class LEETCODE_238_HARD {
    @Test
    public void test(){
        System.out.println(countDigitOne(15));
    }

    // O(logn)
    public int countDigitOne(int n) {
        long mulk = 1L;
        int res = 0;
        for(;n>=mulk;){
            // eg.1234 中1的个数
            // 当k=2时，表示百位上1的个数
            // (n/(mulk*10))*mulk表示百位更高位有值时，百位为1的个数
            // Math.min(Math.max(n%(10*mulk)-mulk+1,0),mulk) 表示百位上1的个数
            res += (n/(mulk*10))*mulk+Math.min(Math.max(n%(10*mulk)-mulk+1,0),mulk);
            mulk *=10;
        }
        return res;
    }
}
