package exer.leetcode.week276;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-16 12:10
 */
public class Solution2 {
    public int minMoves(int target, int maxDoubles) {
        int res = 0;
        while(target>1&&maxDoubles>0){
            if(target%2==1){
                target--;
                res++;
            }else{
                target /= 2;
                maxDoubles--;
                res++;
            }
        }
        return res+target - 1;
    }
}
