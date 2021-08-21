package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-09 10:00
 */
public class LEETCODE_121_SIMPLE {
    @Test
    public void test(){
        int[] ps = {7,1,5,3,6,4};
        System.out.println(maxProfit(ps));
    }
    public int maxProfit(int prices[]) {
        int n = prices.length;
        // 记录最小收入点
        int purchasePrice = prices[0];
        int max = 0;
        for(int i=1;i<n;i++){
            purchasePrice = Math.min(purchasePrice,prices[i]);
            max = Math.max(max,prices[i]-purchasePrice);
        }
        return max;
    }
}
