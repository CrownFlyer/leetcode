package exer.leetcode.double68;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-27 22:24
 */
public class Solution1 {
    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for(String s:sentences){
            res = Math.max(res,s.split(" ").length);
        }
        return res;
    }
}
