package doublePointer;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-22 16:33
 */
public class LEETCODE_1052_MIDDLE {
    @Test
    public void test(){
        int[] cs = {1,0,1,2,1,1,7,5};
        int[] gs = {0,1,0,1,0,1,0,1};
        System.out.println(maxSatisfied(cs, gs, 3));
    }
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int res = 0;
        for(int i=0;i<n;i++){
            res += customers[i]*(1-grumpy[i]);
            customers[i]*= grumpy[i];
        }

        int sum = 0;
        for(int i=0;i<minutes;i++){
            sum += customers[i];
        }
        int max = sum;
        for(int i=minutes;i<n;i++){
            sum += customers[i]-customers[i-minutes];
            max = Math.max(max,sum);
        }

        return res + max;
    }
}
