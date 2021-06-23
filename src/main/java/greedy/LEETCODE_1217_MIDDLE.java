package greedy;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-22 14:37
 */
public class LEETCODE_1217_MIDDLE {
    @Test
    public void test(){
        int[] pos = {2,2,2,3,3};
        System.out.println(new LEETCODE_1217_MIDDLE().minCostToMoveChips(pos));
    }

    public int minCostToMoveChips(int[] position) {
        int evenNum=0, oddNum=0;
        for(int i = 0; i < position.length; i++){
            if(position[i] %2== 1)   ++oddNum;
            else ++evenNum;
        }
        return Math.min(oddNum,evenNum);
    }

}
