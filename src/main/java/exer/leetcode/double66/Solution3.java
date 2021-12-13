package exer.leetcode.double66;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-28 17:52
 */
public class Solution3 {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int minR = Math.min(startPos[0],homePos[0]),maxR = Math.max(startPos[0],homePos[0]);
        int minC = Math.min(startPos[1],homePos[1]),maxC = Math.max(startPos[1],homePos[1]);
        int res = 0;
        for(int i = minR+1;i<=maxR;i++){
            res += rowCosts[i];
        }
        if(startPos[0] > homePos[0]) res += rowCosts[minR] - rowCosts[maxR];
        for(int i = minC+1;i<=maxC;i++){
            res += colCosts[i];
        }
        if(startPos[1] > homePos[1]) res += colCosts[minC] - colCosts[maxC];
        return res;
    }
}
